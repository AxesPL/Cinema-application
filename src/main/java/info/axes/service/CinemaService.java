package info.axes.service;

import info.axes.model.dto.AvailableHoursDto;
import info.axes.model.dto.HallDto;
import info.axes.model.dto.MovieDto;
import info.axes.model.dto.ShowingDto;

import java.util.List;

public interface CinemaService {
    List<ShowingDto> getAllShowingsByShowingDate(String showingDate);
    void deleteShowingById(long showingId);
    List<HallDto> getAllHalls();
    List<MovieDto> getAllMovies();
    List<AvailableHoursDto> getAvailableHoursByShowingId(long hallId, String showingDate);
}
