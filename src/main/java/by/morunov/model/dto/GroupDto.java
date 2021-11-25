package by.morunov.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Alex Morunov
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class GroupDto {

    private Long id;
    @ApiModelProperty(value = "group number", example = "2132")
    private Long groupNumber;
}
