package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.algor.aggregator.composite.key.TradeCardCompanyKey;
import ru.algor.aggregator.enums.CompanyRole;

@Table(name = "trade_card_company")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@IdClass(TradeCardCompanyKey.class)
public class TradeCardCompany {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trade_card", referencedColumnName = "id")
    private TradeCard tradeCard;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company", referencedColumnName = "id")
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(name = "company_role", nullable = false)
    private CompanyRole companyRole;

//    @Column(name = "created_at", nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at", nullable = false)
//    private LocalDateTime updatedAt;
//
//    @Column(name = "archive_at")
//    private LocalDateTime archiveAt;
}
