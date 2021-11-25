package by.morunov.repository;

import by.morunov.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alex Morunov
 */
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {


    @Query("select distinct s \n"+
            "from Student s \n" +
            "join s.group g \n" +
            "where g.id = :idGroup")
    List<Student> getStudentsByGroup(Long idGroup);



    @Query("select distinct s  \n" +
            "from Student s  \n" +
            "join s.subjectList subject \n" +
            "where subject.id = :id")
    List<Student> findStudentsBySubject(Long id);

}
