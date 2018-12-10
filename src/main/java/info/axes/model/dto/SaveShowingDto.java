package info.axes.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaveShowingDto {
    private long movieId;
    private long hallId;
    private String showingDate;
    private float ticketPrice;
    private String showingHour;
}
