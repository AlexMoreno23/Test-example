package by.morunov.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alex Morunov
 */
@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long groupNumber;
}
