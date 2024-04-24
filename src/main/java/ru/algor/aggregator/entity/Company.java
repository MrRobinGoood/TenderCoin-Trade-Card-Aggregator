package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "company")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "number_inn", unique = true)
    private Integer numberInn;

    @Column(name = "number_kpp")
    private Integer numberKpp;

    @Column(name = "business_address")
    private String businessAddress;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "short_name")
    private String shortName;

//    @Column(name = "created_at", nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at", nullable = false)
//    private LocalDateTime updatedAt;
//
//    @Column(name = "archive_at")
//    private LocalDateTime archiveAt;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CompanySourceLink> companySourceLinks;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TradeCardCompany> tradeCardCompanies;
}
