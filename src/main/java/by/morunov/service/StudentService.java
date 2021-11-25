package by.morunov.service;

import by.morunov.model.dto.StudentDto;
import by.morunov.model.entity.Group;

import java.util.List;

/**
 * @author Alex Morunov
 */
public interface StudentService {

    List<StudentDto> getStudentsByGroup(Long idGroup);
    List<StudentDto> getStudentsBySubject (Long id);
    List<StudentDto> getAllStudents();
    void deleteStudent(Long id);
    StudentDto getStudentById(Long id);
    StudentDto addStudent(StudentDto studentDto);
    StudentDto addSubjectToStudent(Long idStudent, Long idSubject);
    StudentDto addStudentToGroup(Long idStudent, Long idGroup);



}
