package info.axes.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ShowingDto implements Serializable {

    private long id;
    private String showingDate;
    private String showingHour;
    private String movieTitle;
    private String hallName;
    private float ticketPrice;
}
