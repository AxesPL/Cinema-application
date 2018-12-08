package info.axes.service.mapper.impl;

import info.axes.model.dto.AvailableHoursDto;
import info.axes.model.entity.ShowingHour;
import info.axes.service.mapper.ShowingHourMapper;
import org.springframework.stereotype.Component;

@Component
public class ShowingHourMapperImpl implements ShowingHourMapper {
    @Override
    public AvailableHoursDto mapToDto(ShowingHour showingHour) {
        AvailableHoursDto dto = new AvailableHoursDto();
        dto.setHour(showingHour.getShowingHour());
        return dto;
    }
}
