package by.morunov.service.converter;

import by.morunov.model.dto.StudentDto;
import by.morunov.model.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex Morunov
 */
@Component
public class StudentConverter implements Converter<Student, StudentDto> {
    @Override
    public Student toEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setGroup(studentDto.getGroup());
        student.setSubjectList(studentDto.getSubjectList());
        return student;
    }

    @Override
    public List<Student> toEntity(List<StudentDto> studentDtos) {
        return studentDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public StudentDto toDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setGroup(student.getGroup());
        studentDto.setSubjectList(student.getSubjectList());
        return studentDto;
    }

    @Override
    public List<StudentDto> toDto(List<Student> students) {
        return students.stream().map(this::toDto).collect(Collectors.toList());
    }
}
