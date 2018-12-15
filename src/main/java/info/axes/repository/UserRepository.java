package info.axes.repository;

import info.axes.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByUsername(String username);
}
