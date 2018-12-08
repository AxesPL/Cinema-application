package info.axes.repository;

import info.axes.model.entity.ShowingHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowingHourRepository extends JpaRepository<ShowingHour,String> {
}
