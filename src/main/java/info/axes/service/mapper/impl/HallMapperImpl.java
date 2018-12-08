package info.axes.service.mapper.impl;

import info.axes.model.dto.HallDto;
import info.axes.model.entity.Hall;
import info.axes.service.mapper.HallMapper;
import org.springframework.stereotype.Component;

@Component
public class HallMapperImpl implements HallMapper {


    @Override
    public HallDto mapToDto(Hall hall) {
        HallDto hallDto = new HallDto();
        hallDto.setHallName(hall.getHallName());
        hallDto.setId(hall.getId());
        return hallDto;
    }
}
