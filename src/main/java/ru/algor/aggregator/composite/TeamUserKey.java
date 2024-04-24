package ru.algor.aggregator.composite;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.algor.aggregator.entity.Team;
import ru.algor.aggregator.entity.User;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TeamUserKey implements Serializable {
    private Team team;
    private User user;
}