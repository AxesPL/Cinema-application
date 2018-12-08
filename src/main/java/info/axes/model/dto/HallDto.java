package info.axes.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HallDto implements Serializable {
    private long id;
    private String hallName;
}
