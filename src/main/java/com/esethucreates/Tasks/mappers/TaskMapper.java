package com.esethucreates.Tasks.mappers;

import com.esethucreates.Tasks.domain.dto.TaskDTO;
import com.esethucreates.Tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDTO(TaskDTO taskDTO);

    TaskDTO toDTO(Task task);
}
