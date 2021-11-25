package by.morunov.controller;

import by.morunov.model.dto.SubjectDto;
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
@RequestMapping(name = "/subject")
@RestController
public class SubjectController {

    private final SubjectServiceImpl subjectService;

    @ApiOperation(value = "show all subjects", response = List.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubjectDto> getAllSubjects() {
        return subjectService.getAll();
    }

    @ApiOperation(value = "add new subject", response = SubjectDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SubjectDto addSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.addSubject(subjectDto);
    }

    @ApiOperation(value = "delete subject", response = SubjectDto.class)
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/delete/{id}")
    public void deleteSubject(@PathVariable ("id") Long id) {
        subjectService.deleteSubject(id);
    }

    @PutMapping(value = "/update/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "update subject", response = SubjectDto.class)
    public SubjectDto update(@PathVariable("id") Long id,
                             @RequestBody SubjectDto newSubject) {
        SubjectDto subjectDto = subjectService.getSubjectById(id);
        subjectDto.setNameSubject(newSubject.getNameSubject());
        return subjectService.addSubject(subjectDto);
    }
}
