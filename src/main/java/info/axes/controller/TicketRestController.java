package info.axes.controller;

import info.axes.model.Ticket;
import info.axes.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class TicketRestController {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketRestController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping(path = "/api/tickets/sold/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ticket>> allSoldTicketsOnShowId(@PathVariable Long id) {
        List<Ticket> allSoldTicketsOnShow = ticketRepository.allSoldTicketsByShowingId(id);
        return ResponseEntity.ok(allSoldTicketsOnShow);
    }
    @GetMapping(path = "/api/tickets/free/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ticket>> allFreeTicketsOnShowId(@PathVariable Long id){
        List<Ticket> allFreeTicketsOnShow = ticketRepository.allFreeTicketsByShowingId(id);
        return ResponseEntity.ok(allFreeTicketsOnShow);
    }
    @GetMapping(path = "api/tickets/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ticket>> allTicketsOnShowId(@PathVariable Long id){
        List<Ticket> allTicketsOnShowId = ticketRepository.allTicketsByShowingId(id);
        return ResponseEntity.ok(allTicketsOnShowId);
    }
    @GetMapping(path="api/tickets/{id}/seatrow/{seatRow}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ticket>> allTicketsOnShowIdOnBySeatNumber(@PathVariable Long id,@PathVariable String seatRow){
        List<Ticket> allTicketsOnShowIdOnBySeatNumber = ticketRepository.allTicketsByShowingIdAndSeatRow(id,seatRow);
        return ResponseEntity.ok(allTicketsOnShowIdOnBySeatNumber);
    }

}
