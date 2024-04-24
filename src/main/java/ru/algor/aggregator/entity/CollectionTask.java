package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.algor.aggregator.composite.key.CollectionTaskKey;

@Table(name = "collection_task")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@IdClass(CollectionTaskKey.class)
public class CollectionTask {

    @Id
    @ManyToOne
    @JoinColumn(name = "collection", referencedColumnName = "id")
    private Collection collection;

    @Id
    @ManyToOne
    @JoinColumn(name = "task", referencedColumnName = "id")
    private Task task;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User createdBy;

//    @Column(name = "created_at", nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at", nullable = false)
//    private LocalDateTime updatedAt;
//
//    @Column(name = "archive_at")
//    private LocalDateTime archiveAt;
}
