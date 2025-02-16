package com.esethucreates.Tasks.mappers.impl;

import com.esethucreates.Tasks.domain.dto.TaskListDTO;
import com.esethucreates.Tasks.domain.entities.Task;
import com.esethucreates.Tasks.domain.entities.TaskList;
import com.esethucreates.Tasks.domain.entities.TaskStatus;
import com.esethucreates.Tasks.mappers.TaskListMapper;
import com.esethucreates.Tasks.mappers.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    @Autowired
    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDTO(TaskListDTO taskListDTO) {
        return new TaskList(
                taskListDTO.id(),
                taskListDTO.title(),
                taskListDTO.description(),
                Optional.ofNullable(taskListDTO.tasks())
                        .map(taskDTOS -> taskDTOS.stream()
                                .map(taskMapper::fromDTO)
                                .toList()
                        ).orElse(null),
                null,
                null

        );
    }

    @Override
    public TaskListDTO toDTO(TaskList taskList) {
        return new TaskListDTO(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0),
                calculateTaskListProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::toDTO).toList())
                        .orElse(null)
        );
    }

    private Double calculateTaskListProgress(List<Task> tasks) {
        if (null == tasks) {
            return null;
        }
        long closedTaskCount = tasks.stream()
                .filter(task -> TaskStatus.CLOSED == task.getStatus())
                .count();

        return (double) closedTaskCount / tasks.size();
    }
}
