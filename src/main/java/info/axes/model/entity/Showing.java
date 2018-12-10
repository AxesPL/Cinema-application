package info.axes.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public  class Showing {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;

    private LocalDate showingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Hall hall;

    @ManyToOne(fetch = FetchType.EAGER)
    private ShowingHour showingHour;

    private float showingBasePrice;
}
