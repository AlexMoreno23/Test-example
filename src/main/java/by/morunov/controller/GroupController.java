package by.morunov.controller;

import by.morunov.model.dto.GroupDto;
import by.morunov.service.impl.GroupServiceImpl;
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
@RequestMapping("/group")
public class GroupController {

    private final GroupServiceImpl groupService;

    @ApiOperation(value = "show all groups", response = List.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GroupDto> getAllStudents(){
        return groupService.getAllGroups();
    }

    @ApiOperation(value = "add new group", response = GroupDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GroupDto addGroup(@RequestBody GroupDto groupDto){
        return groupService.addGroup(groupDto);
    }

    @ApiOperation(value = "delete group", response = GroupDto.class)
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/delete/{id}")
    public void deleteGroup(@PathVariable ("id") Long id){
        groupService.deleteGroup(id);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "update group", response = GroupDto.class)
    public GroupDto update(@PathVariable("id") Long id,
                             @RequestBody GroupDto newGroup){
        GroupDto groupDto = groupService.getById(id);
        groupDto.setGroupNumber(newGroup.getGroupNumber());
        return groupService.addGroup(groupDto);
    }


}
