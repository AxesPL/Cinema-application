package info.axes.controller;

import info.axes.model.Movie;
import info.axes.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieRestController {

    private MovieRepository movieRepo;

    @Autowired
    public MovieRestController(MovieRepository movieRepo){
        this.movieRepo = movieRepo;
    }
    @GetMapping(path = "api/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Movie>> allMovies(){
        List<Movie> allMovies = movieRepo.findAll();
        return ResponseEntity.ok(allMovies);
    }

}
