package by.morunov.service.impl;

import by.morunov.model.dto.SubjectDto;
import by.morunov.repository.SubjectRepo;
import by.morunov.service.SubjectService;
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
public class SubjectServiceImpl implements SubjectService {

    private final SubjectConverter subjectConverter;
    private final SubjectRepo subjectRepo;

    @Override
    public SubjectDto addSubject(SubjectDto subjectDto){
        return subjectConverter.toDto(subjectRepo.save(subjectConverter.toEntity(subjectDto)));
    }

    @Override
    public List<SubjectDto> getAll(){
        return subjectConverter.toDto(subjectRepo.findAll());
    }

    @Override
    public SubjectDto getSubjectById(Long id){
        return subjectConverter.toDto(subjectRepo.getById(id));
    }

    @Override
    public void deleteSubject(Long id){
        subjectRepo.deleteById(id);
    }
}
