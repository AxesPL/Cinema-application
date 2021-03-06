package info.axes.repository;

import info.axes.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket,Long>{

    List<Ticket> findAllByShowing_ShowingDateBetween(LocalDate start,LocalDate end);

}
