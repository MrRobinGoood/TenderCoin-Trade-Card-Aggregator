package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name = "message_answer")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class MessageAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "message_query", referencedColumnName = "id")
    private MessageQuery messageQuery;

    @Column(name = "answer_description")
    private String answerDescription;

    @ManyToOne
    @JoinColumn(name = "thread", referencedColumnName = "id")
    private Thread thread;

//    @Column(name = "created_at", nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "archive_at")
//    private LocalDateTime archiveAt;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Collection> collections;
}
