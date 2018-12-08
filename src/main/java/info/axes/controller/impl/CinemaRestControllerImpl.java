package info.axes.controller.impl;

import info.axes.controller.CinemaRestController;
import info.axes.model.dto.AvailableHoursDto;
import info.axes.model.dto.HallDto;
import info.axes.model.dto.MovieDto;
import info.axes.model.dto.ShowingDto;
import info.axes.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class CinemaRestControllerImpl implements CinemaRestController {

    private final CinemaService cinemaService;

    @Override
    public ResponseEntity<List<ShowingDto>> getShowingsByShowingDate(@PathVariable("showingDate") String showingDate) {
        return ResponseEntity.ok(cinemaService.getAllShowingsByShowingDate(showingDate));
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

}
