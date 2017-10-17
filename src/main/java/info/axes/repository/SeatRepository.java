package info.axes.repository;

import info.axes.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SeatRepository extends JpaRepository<Seat,Long>{

    @Query("Select s from Seat s where s.hall.id=:idHall")
    List<Seat> allSeatsByHallId(@Param("idHall") Long idHall);
}
