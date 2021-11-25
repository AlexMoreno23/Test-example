package by.morunov.service.impl;

import by.morunov.model.dto.GroupDto;
import by.morunov.model.dto.StudentDto;
import by.morunov.model.dto.SubjectDto;
import by.morunov.repository.GroupRepo;
import by.morunov.repository.StudentRepo;
import by.morunov.repository.SubjectRepo;
import by.morunov.service.StudentService;
import by.morunov.service.converter.GroupConverter;
import by.morunov.service.converter.StudentConverter;
import by.morunov.service.converter.SubjectConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Alex Morunov
 */
@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepo studentRepo;
    private final SubjectRepo subjectRepo;
    private final GroupRepo groupRepo;
    private final StudentConverter studentConverter;
    private final SubjectConverter subjectConverter;
    private final GroupConverter groupConverter;


    @Override
    public List<StudentDto> getStudentsByGroup(Long idGroup) {
        return studentConverter.toDto(studentRepo.getStudentsByGroup(idGroup));
    }

    @Override
    public List<StudentDto> getStudentsBySubject(Long id) {

        return studentConverter.toDto(studentRepo.findStudentsBySubject(id));
    }


    @Override
    public StudentDto getStudentById(Long id) {
        return studentConverter.toDto(studentRepo.getById(id));
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        return studentConverter.toDto(studentRepo.save(studentConverter.toEntity(studentDto)));
    }

    @Override
    public StudentDto addSubjectToStudent(Long idStudent, Long idSubject) {
        StudentDto studentDto = studentConverter.toDto(studentRepo.findById(idStudent).orElseThrow(()
                -> new NullPointerException("Student not found")));
        List<SubjectDto> subjectList = subjectConverter.toDto(studentDto.getSubjectList());
        SubjectDto subject = subjectConverter.toDto(subjectRepo.findById(idSubject).orElseThrow(() ->
                new NullPointerException("subject not found")));
        subjectList.add(subject);
        studentDto.setSubjectList(subjectConverter.toEntity(subjectList));
        return studentConverter.toDto(studentRepo.save(studentConverter.toEntity(studentDto)));
    }

    @Override
    public StudentDto addStudentToGroup(Long idStudent, Long idGroup) {
        GroupDto groupDto =groupConverter.toDto(groupRepo.getById(idGroup));
        StudentDto studentDto = studentConverter.toDto(studentRepo.getById(idStudent));
        studentDto.setGroup(groupConverter.toEntity(groupDto));
        return studentConverter.toDto(studentRepo.save(studentConverter.toEntity(studentDto)));
    }


    @Override
    public List<StudentDto> getAllStudents() {
        return studentConverter.toDto(studentRepo.findAll());
    }

    @Override
    public void
    deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }


}
