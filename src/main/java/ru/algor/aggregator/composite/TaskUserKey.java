package ru.algor.aggregator.composite;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.algor.aggregator.entity.Task;
import ru.algor.aggregator.entity.User;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TaskUserKey implements Serializable {
    private Task task;
    private User user;
}
