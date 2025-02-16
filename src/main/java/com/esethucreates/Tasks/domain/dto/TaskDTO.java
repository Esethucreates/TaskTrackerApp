package com.esethucreates.Tasks.domain.dto;

import com.esethucreates.Tasks.domain.entities.TaskPriority;
import com.esethucreates.Tasks.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDTO(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
