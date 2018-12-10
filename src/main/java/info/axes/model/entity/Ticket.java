package info.axes.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Showing showing;

    private float paidPrice;
}
