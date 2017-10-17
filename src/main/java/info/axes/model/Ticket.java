package info.axes.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Showing showing;
    @ManyToOne
    private Seat seat;
    private String status;
}
