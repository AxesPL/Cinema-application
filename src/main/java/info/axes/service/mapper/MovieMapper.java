package info.axes.service.mapper;

import info.axes.model.dto.MovieDto;
import info.axes.model.entity.Movie;

public interface MovieMapper {
    MovieDto mapToDto(Movie movie);
}
