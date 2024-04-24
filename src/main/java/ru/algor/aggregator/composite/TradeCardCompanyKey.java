package ru.algor.aggregator.composite;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.algor.aggregator.entity.Company;
import ru.algor.aggregator.entity.TradeCard;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TradeCardCompanyKey implements Serializable {
    private TradeCard tradeCard;
    private Company company;
}
