package ru.algor.aggregator.composite;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.algor.aggregator.entity.Collection;
import ru.algor.aggregator.entity.Task;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class CollectionTaskKey implements Serializable {
    private Collection collection;
    private Task task;
}
