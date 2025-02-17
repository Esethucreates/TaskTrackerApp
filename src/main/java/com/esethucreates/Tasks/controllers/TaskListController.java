package com.esethucreates.Tasks.controllers;

import com.esethucreates.Tasks.domain.dto.TaskListDTO;
import com.esethucreates.Tasks.domain.entities.TaskList;
import com.esethucreates.Tasks.mappers.TaskListMapper;
import com.esethucreates.Tasks.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    @Autowired
    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }


    @GetMapping
    public List<TaskListDTO> listTaskLists() {
        return taskListService.listTaskList().stream()
                .map(taskListMapper::toDTO)
                .toList();

    }

    @PostMapping
    public TaskListDTO createTaskList(@RequestBody TaskListDTO taskListDTO) {
        TaskList createdTaskList = taskListService.createTaskList(
                taskListMapper.fromDTO(taskListDTO)
        );
        return taskListMapper.toDTO(createdTaskList);
    }


    @GetMapping(path = "/{task_list_id}")
    public Optional<TaskListDTO> getTaskList(@PathVariable("task_list_id") UUID taskListId) {
        return taskListService.getTaskList(taskListId).map(taskListMapper::toDTO);
    }

    @PutMapping(path = "/{task_list_id}")
    public TaskListDTO updateTaskList(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskListDTO taskListDTO
    ) {

        TaskList updateTaskList = taskListService.updateTaskList(
                taskListId,
                taskListMapper.fromDTO(taskListDTO)
        );
        return taskListMapper.toDTO(updateTaskList);
    }

    @DeleteMapping(path = "/{task_list_id}")
    public void deleteTaskList(@PathVariable("task_list_id") UUID taskListId) {
        taskListService.deleteTaskList(taskListId);
    }
}
