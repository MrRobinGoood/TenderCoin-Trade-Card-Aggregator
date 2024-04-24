package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "documents")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "source_description")
    private String sourceDescription;

    @Column(name = "generated_description")
    private String generatedDescription;

    @Column(name = "source_link", nullable = false)
    private String sourceLink;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "trade_card", referencedColumnName = "id")
    private TradeCard tradeCard;

}
