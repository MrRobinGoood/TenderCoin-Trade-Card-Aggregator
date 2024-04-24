package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.algor.aggregator.composite.key.InviteKey;

@Table(name = "invite")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@IdClass(InviteKey.class)
public class Invite {

    @Id
    @ManyToOne
    @JoinColumn(name = "team", referencedColumnName = "id")
    private Team team;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_obj", referencedColumnName = "id")
    private User user;

    @Column(name = "invite_message", length = 500)
    private String inviteMessage;

//    @Column(name = "created_at", nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at", nullable = false)
//    private LocalDateTime updatedAt;
//
//    @Column(name = "archive_at")
//    private LocalDateTime archiveAt;
}
