package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "purchase_object")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class PurchaseObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "purchaseObject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TradeCardPurchaseObject> tradeCardPurchaseObjects;
}
