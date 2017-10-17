package info.axes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data public  class Showing {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Movie movie;
    @JsonFormat(locale ="pl",shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm",timezone="Europe/Warsaw")
    private Date showingDate;
    @ManyToOne
    private Hall hall;
    private float showingBasePrice;
}
