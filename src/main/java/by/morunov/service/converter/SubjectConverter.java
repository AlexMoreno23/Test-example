package by.morunov.service.converter;

import by.morunov.model.dto.SubjectDto;
import by.morunov.model.entity.Subject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex Morunov
 */
@Component
public class SubjectConverter implements Converter<Subject, SubjectDto>{
    @Override
    public Subject toEntity(SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setId(subjectDto.getId());
        subject.setNameSubject(subjectDto.getNameSubject());
        return subject;
    }

    @Override
    public List<Subject> toEntity(List<SubjectDto> subjectDtos) {
        return subjectDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public SubjectDto toDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setNameSubject(subject.getNameSubject());
        return subjectDto;
    }

    @Override
    public List<SubjectDto> toDto(List<Subject> subjects) {
        return subjects.stream().map(this::toDto).collect(Collectors.toList());
    }
}
