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
public class SubjectDto {

    private Long id;
    @ApiModelProperty(value = "name subject", example = "Math")
    private String nameSubject;
}
