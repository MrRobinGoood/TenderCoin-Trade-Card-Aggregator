package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "region")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private Long id;
    @Column(nullable = false)
    private String title;
}
