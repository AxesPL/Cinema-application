package info.axes.service.mapper;

import info.axes.model.dto.ShowingDto;
import info.axes.model.entity.Showing;

public interface ShowingMapper {
    ShowingDto mapToDto(Showing showing);
}
