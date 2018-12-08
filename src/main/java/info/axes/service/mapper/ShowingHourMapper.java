package info.axes.service.mapper;

import info.axes.model.dto.AvailableHoursDto;
import info.axes.model.entity.ShowingHour;

public interface ShowingHourMapper{
    AvailableHoursDto mapToDto(ShowingHour showingHour);
}
