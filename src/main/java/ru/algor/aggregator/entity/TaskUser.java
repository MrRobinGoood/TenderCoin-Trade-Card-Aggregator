package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.algor.aggregator.composite.TaskUserKey;
import ru.algor.aggregator.enums.TaskRelation;

@Table(name = "task_users")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@IdClass(TaskUserKey.class)
public class TaskUser {

    @Id
    @ManyToOne
    @JoinColumn(name = "task", referencedColumnName = "id")
    private Task task;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_obj", referencedColumnName = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "access_level", nullable = false)
    private AccessLevel accessLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_relation", nullable = false)
    private TaskRelation taskRelation;

//    @Column(name = "created_at", nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at", nullable = false)
//    private LocalDateTime updatedAt;
//
//    @Column(name = "archive_at")
//    private LocalDateTime archiveAt;
}
