package info.axes.service.impl;

import info.axes.model.dto.AvailableHoursDto;
import info.axes.model.dto.HallDto;
import info.axes.model.dto.MovieDto;
import info.axes.model.dto.ShowingDto;
import info.axes.model.entity.Showing;
import info.axes.model.entity.ShowingHour;
import info.axes.repository.HallRepository;
import info.axes.repository.MovieRepository;
import info.axes.repository.ShowingHourRepository;
import info.axes.repository.ShowingRepository;
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
import java.time.format.DateTimeFormatter;
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

    private final DateTimeFormatter formatterToDto = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public List<ShowingDto> getAllShowingsByShowingDate(String showingDate) {
        LocalDate showingDateParam = LocalDate.parse(showingDate, formatterToDto);
        List<Showing> showingsByDate = showingRepository.findAllByShowingDate(showingDateParam);
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
}
