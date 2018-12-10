package info.axes.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UpcomingMovieDto implements Serializable {

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("title")
    private String title;
}
