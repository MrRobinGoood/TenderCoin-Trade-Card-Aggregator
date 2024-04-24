package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "email")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String emailName;

    private String applyLink;
}
