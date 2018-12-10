package info.axes.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class UpcomingMoviesResponseDto implements Serializable {
    @JsonProperty("results")
    private List<UpcomingMovieDto> upcomingMoviesDto;

}
