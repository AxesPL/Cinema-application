package info.axes;

import info.axes.model.*;
import info.axes.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CinemaApplication {

	public static void main(String[] args) throws ParseException {

        ConfigurableApplicationContext ctx =SpringApplication.run(CinemaApplication.class, args);
    /*
        HallRepository hallRepo = ctx.getBean(HallRepository.class);
        Hall hall = hallRepo.findOne(1L);
        ShowingRepository showRepo = ctx.getBean(ShowingRepository.class);
        TicketRepository ticketRepo = ctx.getBean(TicketRepository.class);
        MovieRepository movieRepo = ctx.getBean(MovieRepository.class);
        List<Movie> movies = movieRepo.findAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm");
        String stringData = "05-09-2017 16:00";
        Date initialDate = sdf.parse(stringData);

        List<Showing> showings = new ArrayList<>();



        for(Movie movie : movies){
            for(int i=0;i<11;i++) {
                Showing showing = new Showing();
                showing.setHall(hall);
                showing.setMovie(movie);
                Date showingDate = new Date(initialDate.getTime()+i*86400000);
                showing.setShowingDate(showingDate);
                showings.add(showing);
            }
        }

        showings.forEach(showRepo::save);

        TicketRepository ticketRepo = ctx.getBean(TicketRepository.class);
        ShowingRepository showRepo = ctx.getBean(ShowingRepository.class);
        SeatRepository seatRepo = ctx.getBean(SeatRepository.class);
        List<Ticket> tickets = new ArrayList<>();
        List<Showing> showings = showRepo.findAll();
        List<Seat> seats = seatRepo.allSeatsByHallId(1L);
        for(Showing show : showings){
            for(Seat seat : seats){
                Ticket ticket = new Ticket();
                ticket.setShowing(show);
                ticket.setSeat(seat);
                tickets.add(ticket);
                ticket.setStatus("available");
            }

        }
        tickets.forEach(ticketRepo::save);
        */
    }
}
