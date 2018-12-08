package info.axes.service.mapper;

import info.axes.model.dto.HallDto;
import info.axes.model.entity.Hall;

public interface HallMapper {
    HallDto mapToDto(Hall hall);
}
