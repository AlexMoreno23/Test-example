package by.morunov.service;

import by.morunov.model.dto.SubjectDto;

import java.util.List;

/**
 * @author Alex Morunov
 */

public interface SubjectService {
    SubjectDto addSubject(SubjectDto subjectDto);
    List<SubjectDto> getAll();
    SubjectDto getSubjectById(Long id);
    void deleteSubject(Long id);
}
