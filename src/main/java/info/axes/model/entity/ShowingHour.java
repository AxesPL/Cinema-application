package info.axes.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "showing_hours")
@Data
@NoArgsConstructor
public class ShowingHour  {

    @Id
    @Column(length = 10)
    private String showingHour;
}
