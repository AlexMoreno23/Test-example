package by.morunov.model.dto;

import by.morunov.model.entity.Group;
import by.morunov.model.entity.Subject;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * @author Alex Morunov
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class StudentDto {

    private Long id;
    @ApiModelProperty(value = "first name of student", example = "Alex")
    private String firstName;
    @ApiModelProperty(value = "last name of student", example = "Morunov")
    private String lastName;
    @ApiModelProperty(value = "group number", example = "2314")
    private Group group;
    @ApiModelProperty(value = "list of student's subjects", example = "Math")
    private List<Subject> subjectList;
}
