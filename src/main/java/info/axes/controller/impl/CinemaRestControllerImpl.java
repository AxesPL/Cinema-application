package info.axes.controller.impl;

import info.axes.controller.CinemaRestController;
import info.axes.model.api.UpcomingMovieDto;
import info.axes.model.dto.*;
import info.axes.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@AllArgsConstructor(onConstructor = @_(@Autowired))
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200")
public class CinemaRestControllerImpl implements CinemaRestController {

    private final CinemaService cinemaService;

    @Override
    public ResponseEntity<List<ShowingDto>> getShowingsByShowingDate() {
        return ResponseEntity.ok(cinemaService.getAllShowingsByShowingDate());
    }

    @Override
    public ResponseEntity<Void> deleteShowingById(@PathVariable("id") long showingId) {
        cinemaService.deleteShowingById(showingId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<HallDto>> getAllHalls() {
        return ResponseEntity.ok(cinemaService.getAllHalls());
    }

    @Override
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(cinemaService.getAllMovies());
    }

    @Override
    public ResponseEntity<List<AvailableHoursDto>> getAvailableHoursByShowing(long hallId, String showingDate) {
        return ResponseEntity.ok(cinemaService.getAvailableHoursByShowingId(hallId,showingDate));
    }

    @Override
    public ResponseEntity<Void> saveShowing(@RequestBody SaveShowingDto saveShowingDto) {
        cinemaService.saveShowing(saveShowingDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<TicketSalesMonthReport>> getIncomeFromLast6Months() {
        return ResponseEntity.ok(cinemaService.getTicketSalesReportsFromLast6Months());
    }

    @Override
    public ResponseEntity<List<UpcomingMovieDto>> getUpcomingMovies() {
        return ResponseEntity.ok(cinemaService.getUpcomingMovies());
    }

    @Override
    public ResponseEntity<Void> saveMovie(@RequestBody UpcomingMovieDto movie) {
        cinemaService.saveMovie(movie);
        return ResponseEntity.ok(null);
    }

}
