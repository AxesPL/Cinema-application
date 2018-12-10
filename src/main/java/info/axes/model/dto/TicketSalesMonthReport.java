package info.axes.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TicketSalesMonthReport implements Serializable {
    private int monthNumer;
    private float income;
}
