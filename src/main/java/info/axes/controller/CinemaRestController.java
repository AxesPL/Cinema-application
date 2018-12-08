package info.axes.controller;

import info.axes.model.dto.AvailableHoursDto;
import info.axes.model.dto.HallDto;
import info.axes.model.dto.MovieDto;
import info.axes.model.dto.ShowingDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface CinemaRestController {
    @RequestMapping(method = RequestMethod.GET, path = "/showings/{showingDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ShowingDto>> getShowingsByShowingDate(@PathVariable("showingDate") String showingDate);

    @RequestMapping(method = RequestMethod.DELETE, path = "/showings/{id}")
    ResponseEntity<Void> deleteShowingById(@PathVariable("id") long showingId);

    @RequestMapping(method = RequestMethod.GET, path = "/halls")
    ResponseEntity<List<HallDto>> getAllHalls();

    @RequestMapping(method = RequestMethod.GET, path = "/movies")
    ResponseEntity<List<MovieDto>> getAllMovies();

    @RequestMapping(method = RequestMethod.GET, path = "/halls/{hallId}/{showingDate}/get-available-hours")
    ResponseEntity<List<AvailableHoursDto>> getAvailableHoursByShowing(@PathVariable("hallId") long hallId, @PathVariable("showingDate") String showingDate);
}
