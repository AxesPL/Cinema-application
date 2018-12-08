package info.axes.repository;

import info.axes.model.entity.Showing;
import info.axes.model.entity.ShowingHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource
public interface ShowingRepository extends JpaRepository<Showing,Long> {
    List<Showing> findAllByShowingDate(LocalDate showingDate);
    boolean existsByHall_IdAndShowingDateAndShowingHour(long hallId,LocalDate showingDate, ShowingHour showingHour);
}
