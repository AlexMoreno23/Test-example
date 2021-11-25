package by.morunov.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author Alex Morunov
 */

@Entity
@Table(name = "subjects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameSubject;


}
