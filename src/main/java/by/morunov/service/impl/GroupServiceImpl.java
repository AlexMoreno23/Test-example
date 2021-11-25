package by.morunov.service.impl;

import by.morunov.model.dto.GroupDto;
import by.morunov.repository.GroupRepo;
import by.morunov.service.GroupService;
import by.morunov.service.converter.GroupConverter;
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
public class GroupServiceImpl implements GroupService {

    private final GroupRepo groupRepo;
    private final GroupConverter groupConverter;


    @Override
    public GroupDto addGroup(GroupDto groupDto) {
        return groupConverter.toDto(groupRepo.save(groupConverter.toEntity(groupDto)));
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepo.deleteById(id);
    }

    @Override
    public List<GroupDto> getAllGroups() {
        return groupConverter.toDto(groupRepo.findAll());
    }

    @Override
    public GroupDto getById(Long id){
        return groupConverter.toDto(groupRepo.getById(id));
    }

}
