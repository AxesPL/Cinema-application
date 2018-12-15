package info.axes.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
public class Authority implements Serializable {

    @Id
    private long id;

    private String name;
}
