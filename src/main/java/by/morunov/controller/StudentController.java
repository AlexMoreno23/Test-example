package by.morunov.controller;

import by.morunov.model.dto.StudentDto;
import by.morunov.service.impl.StudentServiceImpl;
import by.morunov.service.impl.SubjectServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alex Morunov
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentServiceImpl studentService;
    private final SubjectServiceImpl subjectService;

    @ApiOperation(value = "show all students", response = List.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @ApiOperation(value = "add new student", response = StudentDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public StudentDto addStudent(@RequestBody StudentDto studentDto){
        return studentService.addStudent(studentDto);
    }

    @ApiOperation(value = "show student by id", response = StudentDto.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDto getStudent(@PathVariable ("id") Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping(value = "subject/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "show all student by subject id", response = List.class)
    public List<StudentDto> getAllStudentBySubject(@PathVariable ("id") Long id){
        return studentService.getStudentsBySubject(id);
    }

    @GetMapping(value = "/group/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "show all student by group id", response = List.class)
    public List<StudentDto> getAllByGroup(@PathVariable ("id") Long id){
        return studentService.getStudentsByGroup(id);
    }

    @PutMapping(value = "update/{id}")
    @ApiOperation(value = "update student", response = StudentDto.class)
    public StudentDto update(@PathVariable("id") Long id,
                             @RequestBody StudentDto newStudent){
         StudentDto student = studentService.getStudentById(id);
         student.setFirstName(newStudent.getFirstName());
         student.setLastName(newStudent.getLastName());
         return studentService.addStudent(student);
    }

    @PutMapping(value = "{id}/add_subject/{subject_id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "add a subject to a student", response = StudentDto.class)
    public StudentDto addSubjectToStudent(@PathVariable ("id") Long id,
                                          @PathVariable ("subject_id") Long subject_id){
        return studentService.addSubjectToStudent(id, subject_id);
    }

    @PutMapping(value = "{id}/add-group/{id_group}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "add a student to a group", response = StudentDto.class)
    public StudentDto addStudentToGroup(@PathVariable ("id") Long id,
                                        @PathVariable ("id_group") Long id_group){
        return studentService.addStudentToGroup(id, id_group);
    }


    @DeleteMapping(value = "delete/{id}")
    @ApiOperation(value = "delete student")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }



}
