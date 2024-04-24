package ru.algor.aggregator.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.algor.aggregator.composite.key.TeamUserKey;
import ru.algor.aggregator.enums.TeamRole;

import java.time.LocalDateTime;

@Table(name = "team_users")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@IdClass(TeamUserKey.class)
public class TeamUser {

    @Id
    @ManyToOne
    @JoinColumn(name = "team", referencedColumnName = "id")
    private Team team;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_obj", referencedColumnName = "id")
    private User user;

    @Column(name = "default_access_level", nullable = false)
    private String defaultAccessLevel;

    @Column(name = "hr_access", nullable = false)
    private String hrAccess;

    @Enumerated(EnumType.STRING)
    @Column(name = "team_role", nullable = false)
    private TeamRole teamRole;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "archive_at")
    private LocalDateTime archiveAt;
}
