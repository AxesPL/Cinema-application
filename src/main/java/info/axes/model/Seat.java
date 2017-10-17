package info.axes.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Seat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seatRow;
    private int seatNumber;
    @ManyToOne
    @JoinColumn(name = "idHall")
    private Hall hall;
}
