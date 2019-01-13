package info.axes.service.mapper.impl;

import info.axes.model.dto.SaveShowingDto;
import info.axes.model.dto.ShowingDto;
import info.axes.model.entity.Hall;
import info.axes.model.entity.Movie;
import info.axes.model.entity.Showing;
import info.axes.model.entity.ShowingHour;
import info.axes.service.mapper.ShowingMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Component
public class ShowingMapperImpl implements ShowingMapper {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public ShowingDto mapToDto(Showing showing) {
        ShowingDto showingDto = new ShowingDto();
        showingDto.setHallName(showing.getHall().getHallName());
        showingDto.setId(showing.getId());
        showingDto.setMovieTitle(showing.getMovie().getMovieTitle());
        showingDto.setTicketPrice(showing.getShowingBasePrice());
        showingDto.setShowingDate(showing.getShowingDate().format(formatter));
        showingDto.setShowingHour(showing.getShowingHour().getShowingHour());
        return showingDto;
    }

    @Override
    public Showing mapToDbo(SaveShowingDto saveShowingDto) {
        Showing showing = new Showing();
        showing.setHall(new Hall(saveShowingDto.getHallId()));
        showing.setMovie(new Movie(saveShowingDto.getMovieId()));
        showing.setShowingBasePrice(saveShowingDto.getTicketPrice());
        showing.setShowingHour(new ShowingHour(saveShowingDto.getShowingHour()));
        showing.setShowingDate(LocalDate.parse(saveShowingDto.getShowingDate(),formatter));
        return showing;
    }
}
