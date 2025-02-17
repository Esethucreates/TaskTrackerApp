package com.esethucreates.Tasks.controllers;

import com.esethucreates.Tasks.domain.dto.TaskDTO;
import com.esethucreates.Tasks.domain.entities.Task;
import com.esethucreates.Tasks.mappers.TaskMapper;
import com.esethucreates.Tasks.repositories.TaskRepository;
import com.esethucreates.Tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists/{task_list_id}/tasks")
public class TasksController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;


    @Autowired
    public TasksController(TaskService taskService, TaskMapper taskMapper,
                           TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<TaskDTO> listTasks(@PathVariable("task_list_id") UUID taskListId) {
        return taskService.listTasks(taskListId).stream()
                .map(taskMapper::toDTO)
                .toList();
    }

    @PostMapping
    public TaskDTO createTask(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskDTO taskDTO) {

        Task createdTask = taskService.createTask(
                taskListId,
                taskMapper.fromDTO(taskDTO)
        );
        return taskMapper.toDTO(createdTask);
    }

    @GetMapping(path = "/{task_id}")
    public Optional<TaskDTO> getTask(
            @PathVariable("task_list_id") UUID taskListId,
            @PathVariable("task_id") UUID taskId

    ) {
        return taskService.getTask(taskListId, taskId).map(taskMapper::toDTO);
    }

    @PutMapping(path = "/{task_id}")
    public TaskDTO updateTask(
            @PathVariable("task_list_id") UUID taskListId,
            @PathVariable("task_id") UUID taskId,
            @RequestBody TaskDTO taskDTO
    ) {
        Task updatedTask = taskService.updateTask(taskListId,
                taskId,
                taskMapper.fromDTO(taskDTO)
        );
        return taskMapper.toDTO(updatedTask);
    }

    @DeleteMapping(path = "/{task_id}")
    public void deleteTask(
            @PathVariable("task_list_id") UUID taskListId,
            @PathVariable("task_id") UUID taskId
    ) {
        taskService.delete(taskListId, taskId);
    }
}
