package info.axes.service.impl;

import info.axes.component.ClientApi;
import info.axes.model.api.UpcomingMovieDto;
import info.axes.model.dto.*;
import info.axes.model.entity.Showing;
import info.axes.model.entity.ShowingHour;
import info.axes.model.entity.Ticket;
import info.axes.repository.*;
import info.axes.service.CinemaService;
import info.axes.service.mapper.HallMapper;
import info.axes.service.mapper.MovieMapper;
import info.axes.service.mapper.ShowingHourMapper;
import info.axes.service.mapper.ShowingMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
@Log
public class CinemaServiceImpl implements CinemaService {

    private final ShowingRepository showingRepository;

    private final ShowingMapper showingMapper;

    private final HallRepository hallRepository;

    private final HallMapper hallMapper;

    private final MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    private final ShowingHourRepository showingHourRepository;

    private final ShowingHourMapper showingHourMapper;

    private final TicketRepository ticketRepository;

    private final ClientApi clientApi;

    private final DateTimeFormatter formatterToDto = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public List<ShowingDto> getAllShowingsByShowingDate(String showingDate) {
        LocalDate showingDateParam = LocalDate.parse(showingDate, formatterToDto);
        showingDateParam = showingDateParam.minusDays(1);
        List<Showing> showingsByDate = showingRepository.findAllByShowingDateAfter(showingDateParam);
        return showingsByDate.stream().map(showingMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteShowingById(long showingId) {
        showingRepository.deleteById(showingId);
    }

    @Override
    public List<HallDto> getAllHalls() {
        return hallRepository.findAll().stream().map(hallMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream().map(movieMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<AvailableHoursDto> getAvailableHoursByShowingId(long hallId, String showingDate) {
        List<ShowingHour> showingHours = showingHourRepository.findAll();
        LocalDate showingDateParam = LocalDate.parse(showingDate, formatterToDto);
        return showingHours.stream().filter(showingHour -> {
            return !showingRepository.existsByHall_IdAndShowingDateAndShowingHour(hallId, showingDateParam, showingHour);
        }).map(showingHourMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void saveShowing(SaveShowingDto saveShowingDto) {
        showingRepository.save(showingMapper.mapToDbo(saveShowingDto));
    }

    @Override
    public List<TicketSalesMonthReport> getTicketSalesReportsFromLast6Months() {
        Month currentMonth = LocalDate.now().getMonth();
        LinkedList<Month> reportMonths = new LinkedList<>();
        for (int i = 1; i <= 6; i++) {
            reportMonths.add(currentMonth.minus(i));
        }
        //need to change the year
        LocalDate reportStartingDate;
        LocalDate reportEndingDate;

        if (reportMonths.getFirst().getValue() < reportMonths.getLast().getValue()) {

            reportStartingDate = LocalDate.of(LocalDate.now().getYear() - 1, reportMonths.getLast(), 1);

            if (LocalDate.now().getMonth().equals(Month.JANUARY)) {

                reportEndingDate = LocalDate.of(LocalDate.now().getYear() - 1, reportMonths.getFirst(), reportMonths.getFirst().length(checkLeapYear(LocalDate.now().getYear())));

            } else
                reportEndingDate = LocalDate.of(LocalDate.now().getYear() - 1, reportMonths.getFirst(), reportMonths.getFirst().length(checkLeapYear(LocalDate.now().getYear())));
        } else {
            reportStartingDate = LocalDate.of(LocalDate.now().getYear(), reportMonths.getLast(), 1);

            reportEndingDate = LocalDate.of(LocalDate.now().getYear(), reportMonths.getFirst(), reportMonths.getFirst().length(checkLeapYear(LocalDate.now().getYear())));
        }
        List<Ticket> ticketSoldBetweenDates = ticketRepository.findAllByShowing_ShowingDateBetween(reportStartingDate, reportEndingDate);
        return reportMonths.stream().map(month -> {
            TicketSalesMonthReport report = new TicketSalesMonthReport();
            report.setIncome((float) ticketSoldBetweenDates.stream().filter(ticket -> ticket.getShowing().getShowingDate().getMonth().equals(month)).mapToDouble(Ticket::getPaidPrice).sum());
            report.setMonthNumer(month.getValue());
            return report;
        }).collect(Collectors.toList());
    }

    @Override
    public List<UpcomingMovieDto> getUpcomingMovies() {
        return clientApi.getUpcomingMovies().getUpcomingMoviesDto();
    }

    @Override
    public void saveMovie(UpcomingMovieDto movieDto) {
        movieRepository.save(movieMapper.mapToDbo(movieDto));
    }

    private boolean checkLeapYear(int year) {
        return year % 4 == 0;
    }


}
