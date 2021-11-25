package by.morunov.service.converter;

import by.morunov.model.dto.GroupDto;
import by.morunov.model.entity.Group;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex Morunov
 */
@Component
public class GroupConverter implements Converter<Group, GroupDto>{
    @Override
    public Group toEntity(GroupDto groupDto) {
        Group group = new Group();
        group.setId(groupDto.getId());
        group.setGroupNumber(groupDto.getGroupNumber());
        return group;
    }

    @Override
    public List<Group> toEntity(List<GroupDto> groupDtos) {
        return groupDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public GroupDto toDto(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setGroupNumber(group.getGroupNumber());
        return groupDto;
    }

    @Override
    public List<GroupDto> toDto(List<Group> groups) {
        return groups.stream().map(this::toDto).collect(Collectors.toList());
    }
}
