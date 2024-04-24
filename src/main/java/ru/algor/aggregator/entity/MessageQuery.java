package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "message_query")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class MessageQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "send_by", referencedColumnName = "id")
    private User sendBy;

    @Column(name = "user_query", nullable = false)
    private String userQuery;

    @ManyToOne
    @JoinColumn(name = "filters", referencedColumnName = "id")
    private Filters filters;

    @ManyToOne
    @JoinColumn(name = "thread", referencedColumnName = "id")
    private Thread thread;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User createdBy;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "archive_at")
    private LocalDateTime archiveAt;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Collection> collections;
}
