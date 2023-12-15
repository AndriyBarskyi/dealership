package com.final_task.dealership.exception.handler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private LocalDateTime timestamp;
    private String message;
    private List<FieldError> errors;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class FieldError {
    private String field;
    private String message;
    private String rejectedValue;
}

