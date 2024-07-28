package willianssantos.elibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import willianssantos.elibrary.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
