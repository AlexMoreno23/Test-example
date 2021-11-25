package by.morunov.service;

import by.morunov.model.dto.GroupDto;

import java.util.List;

/**
 * @author Alex Morunov
 */
public interface GroupService {

    GroupDto addGroup(GroupDto groupDto);
    void deleteGroup(Long id);
    List<GroupDto> getAllGroups();
    GroupDto getById(Long id);
}
