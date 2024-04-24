package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.algor.aggregator.composite.TradeCardPurchaseObjectKey;
import ru.algor.aggregator.enums.MeasureUnit;

@Table(name = "trade_card_purchase_object")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@IdClass(TradeCardPurchaseObjectKey.class)
public class TradeCardPurchaseObject {
    @Id
    @ManyToOne
    @JoinColumn(name = "trade_card", referencedColumnName = "id")
    private TradeCard tradeCard;
    @Id
    @ManyToOne
    @JoinColumn(name = "purchase_object", referencedColumnName = "id")
    private PurchaseObject purchaseObject;

    @Column(name = "count_of", nullable = false)
    private Double countOf;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_unit", nullable = false)
    private MeasureUnit measureUnit;

    @Column(name = "delivery_address")
    private String deliveryAddress;
}
