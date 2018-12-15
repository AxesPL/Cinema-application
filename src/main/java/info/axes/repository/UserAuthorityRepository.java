package info.axes.repository;

import info.axes.model.entity.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority,Long> {
    List<UserAuthority> findAllByUser_Id(long id);
}
