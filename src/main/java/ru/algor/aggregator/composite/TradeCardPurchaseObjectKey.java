package ru.algor.aggregator.composite;

import lombok.*;
import ru.algor.aggregator.entity.PurchaseObject;
import ru.algor.aggregator.entity.TradeCard;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TradeCardPurchaseObjectKey implements Serializable {
    private TradeCard tradeCard;
    private PurchaseObject purchaseObject;
}
