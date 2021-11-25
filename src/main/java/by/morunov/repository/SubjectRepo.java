package by.morunov.repository;

import by.morunov.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alex Morunov
 */
@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
