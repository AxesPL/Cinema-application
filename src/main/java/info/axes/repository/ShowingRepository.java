package info.axes.repository;

import info.axes.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface ShowingRepository extends JpaRepository<Showing,Long> {
    List<Showing> findAllByShowingDate(Date showingDate);
    List<Showing> findAllByShowingDateBetween(Date showingDate1, Date showingDate2);
}
