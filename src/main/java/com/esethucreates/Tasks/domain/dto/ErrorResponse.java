package com.esethucreates.Tasks.domain.dto;

public record ErrorResponse(
        int Status,
        String message,
        String details
) {
}
