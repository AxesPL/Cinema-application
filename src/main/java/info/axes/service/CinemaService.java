package info.axes.service;

import info.axes.model.api.UpcomingMovieDto;
import info.axes.model.dto.*;

import java.util.List;

public interface CinemaService {
    List<ShowingDto> getAllShowingsByShowingDate(String showingDate);
    void deleteShowingById(long showingId);
    List<HallDto> getAllHalls();
    List<MovieDto> getAllMovies();
    List<AvailableHoursDto> getAvailableHoursByShowingId(long hallId, String showingDate);
    void saveShowing(SaveShowingDto saveShowingDto);
    List<TicketSalesMonthReport> getTicketSalesReportsFromLast6Months();
    List<UpcomingMovieDto> getUpcomingMovies();
    void saveMovie(UpcomingMovieDto movieDto);
}
