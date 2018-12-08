package info.axes.service.mapper.impl;

import info.axes.model.dto.ShowingDto;
import info.axes.model.entity.Showing;
import info.axes.service.mapper.ShowingMapper;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;


@Component
public class ShowingMapperImpl implements ShowingMapper {

    private final DateTimeFormatter formatterToDto = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public ShowingDto mapToDto(Showing showing) {
        ShowingDto showingDto = new ShowingDto();
        showingDto.setHallName(showing.getHall().getHallName());
        showingDto.setId(showing.getId());
        showingDto.setMovieTitle(showing.getMovie().getMovieTitle());
        showingDto.setTicketPrice(showing.getShowingBasePrice());
        showingDto.setShowingDate(showing.getShowingDate().format(formatterToDto));
        return showingDto;
    }
}
