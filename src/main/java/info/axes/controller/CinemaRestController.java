package info.axes.controller;

import info.axes.model.api.UpcomingMovieDto;
import info.axes.model.dto.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CinemaRestController {
    @RequestMapping(method = RequestMethod.GET, path = "/showings", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ShowingDto>> getShowingsByShowingDate();

    @RequestMapping(method = RequestMethod.DELETE, path = "/showings/{id}")
    ResponseEntity<Void> deleteShowingById(@PathVariable("id") long showingId);

    @RequestMapping(method = RequestMethod.GET, path = "/halls")
    ResponseEntity<List<HallDto>> getAllHalls();

    @RequestMapping(method = RequestMethod.GET, path = "/movies")
    ResponseEntity<List<MovieDto>> getAllMovies();

    @RequestMapping(method = RequestMethod.GET, path = "/halls/{hallId}/{showingDate}/get-available-hours")
    ResponseEntity<List<AvailableHoursDto>> getAvailableHoursByShowing(@PathVariable("hallId") long hallId, @PathVariable("showingDate") String showingDate);

    @RequestMapping(method = RequestMethod.POST, path = "/showings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> saveShowing(@RequestBody SaveShowingDto saveShowingDto);

    @RequestMapping(method = RequestMethod.GET, path="/income",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TicketSalesMonthReport>> getIncomeFromLast6Months();

    @RequestMapping(method = RequestMethod.GET, path="/movies-upcoming",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UpcomingMovieDto>> getUpcomingMovies();

    @RequestMapping(method = RequestMethod.POST, path = "/movies",consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> saveMovie(@RequestBody UpcomingMovieDto movie);
}
