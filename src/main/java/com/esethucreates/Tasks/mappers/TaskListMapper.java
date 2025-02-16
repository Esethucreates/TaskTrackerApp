package com.esethucreates.Tasks.mappers;

import com.esethucreates.Tasks.domain.dto.TaskListDTO;
import com.esethucreates.Tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDTO(TaskListDTO taskListDTO);

    TaskListDTO toDTO(TaskList taskList);
}
