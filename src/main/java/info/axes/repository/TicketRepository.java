package info.axes.repository;

import info.axes.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket,Long>{



    @Query("Select t from Ticket t where t.showing.id = :idShowing")
    List<Ticket> allTicketsByShowingId(@Param("idShowing") Long idShowing);

    @Query("Select t from Ticket t where t.showing.id = :idShowing AND t.status='sold'")
    List<Ticket> allSoldTicketsByShowingId(@Param("idShowing") Long idShowing);

    @Query("Select t from Ticket t where t.showing.id = :idShowing AND t.status='free'")
    List<Ticket> allFreeTicketsByShowingId(@Param("idShowing") Long idShowing);

    @Query("Select t from Ticket t where t.showing.id = :idShowing AND t.seat.seatRow= :seatRow")
    List<Ticket> allTicketsByShowingIdAndSeatRow(@Param("idShowing") Long idShowing, @Param("seatRow") String seatRow);
}
