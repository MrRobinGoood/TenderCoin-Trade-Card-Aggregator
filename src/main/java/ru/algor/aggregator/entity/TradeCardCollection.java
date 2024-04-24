package ru.algor.aggregator.entity;

import jakarta.persistence.*;

import java.util.List;

import lombok.*;

@Table(name = "trade_card_collection")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class TradeCardCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trade_card", referencedColumnName = "id")
    private TradeCard tradeCard;

    @ManyToOne
    @JoinColumn(name = "collection", referencedColumnName = "id")
    private Collection collection;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User createdBy;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Commentary> commentaries;

//    @Column(name = "created_at", nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at", nullable = false)
//    private LocalDateTime updatedAt;
//
//    @Column(name = "archive_at")
//    private LocalDateTime archiveAt;
}
