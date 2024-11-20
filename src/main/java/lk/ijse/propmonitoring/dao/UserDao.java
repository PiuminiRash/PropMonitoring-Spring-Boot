package lk.ijse.propmonitoring.dao;

import lk.ijse.propmonitoring.entity.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
