package info.axes.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class MovieDto implements Serializable {

    private long id;
    private String movieTitle;
    private String movieDescription;
    //in minutes
    private int movieDuration;
}
