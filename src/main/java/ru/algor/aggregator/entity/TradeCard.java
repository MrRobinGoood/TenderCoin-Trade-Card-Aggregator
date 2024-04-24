package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.algor.aggregator.enums.CurrencyType;
import ru.algor.aggregator.enums.TradeStatus;
import ru.algor.aggregator.enums.TradeType;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "trade_card")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class TradeCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "generated_description")
    private String generatedDescription;

    @Column(name = "terms_contract")
    private String termsContract;

    @Column(name = "start_price")
    private Double startPrice;

    @Column(name = "publication_datetime", nullable = false)
    private LocalDateTime publicationDatetime;

    @Column(name = "finish_datetime", nullable = false)
    private LocalDateTime finishDatetime;

    @Column(name = "last_update_datetime", nullable = false)
    private LocalDateTime lastUpdateDatetime;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_type")
    private CurrencyType currencyType;

    @Column(name = "source_link", nullable = false)
    private String sourceLink;

    @ManyToOne
    @JoinColumn(name = "region", referencedColumnName = "id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "country", referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy = "tradeCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents;

    @OneToMany(mappedBy = "tradeCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TradeCardPurchaseObject> tradeCardPurchaseObjects;

    @OneToMany(mappedBy = "tradeCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TradeCardCompany> tradeCardCompanies;

    @OneToMany(mappedBy = "tradeCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TradeCardCollection> tradeCardCollections;

    @Enumerated(EnumType.STRING)
    @Column(name = "trade_status", nullable = false)
    private TradeStatus tradeStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "trade_type", nullable = false)
    private TradeType tradeType;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "archive_at")
    private LocalDateTime archiveAt;
}
