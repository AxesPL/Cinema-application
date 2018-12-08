package info.axes.service.mapper.impl;

import info.axes.model.dto.MovieDto;
import info.axes.model.entity.Movie;
import info.axes.service.mapper.MovieMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl implements MovieMapper {
    @Override
    public MovieDto mapToDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setMovieDescription(movie.getMovieDescription());
        movieDto.setMovieDuration(movie.getMovieDuration());
        movieDto.setMovieTitle(movie.getMovieTitle());
        return movieDto;
    }
}
