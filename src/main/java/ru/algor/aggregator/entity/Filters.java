package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.algor.aggregator.enums.SortingDirection;

import java.time.LocalDate;

@Table(name = "filters")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Filters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private Long id;

    @Column(name = "trade_type")
    private String tradeType;

    @ManyToOne
    @JoinColumn(name = "sorting_field", referencedColumnName = "id")
    private SortingField sortingField;

    @Enumerated(EnumType.STRING)
    @Column(name = "sorting_direction")
    private SortingDirection sortingDirection;

    @Column(name = "start_price_from")
    private Double startPriceFrom;

    @Column(name = "start_price_up_to")
    private Double startPriceUpTo;

    @Column(name = "publication_date_from")
    private LocalDate publicationDateFrom;

    @Column(name = "publication_date_up_to")
    private LocalDate publicationDateUpTo;

    @Column(name = "finish_date_from")
    private LocalDate finishDateFrom;

    @Column(name = "finish_date_up_to")
    private LocalDate finishDateUpTo;
}
