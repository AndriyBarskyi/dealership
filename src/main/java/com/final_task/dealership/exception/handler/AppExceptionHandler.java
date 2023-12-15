package com.final_task.dealership.exception.handler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.userapi.exception.EmailAlreadyTakenException;
import com.example.userapi.exception.EntityNotExistsException;
import com.example.userapi.exception.IncorrectPasswordException;
import com.example.userapi.exception.InvalidTokenException;
import com.example.userapi.exception.PasswordsDontMatchException;

import io.jsonwebtoken.MalformedJwtException;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponse handleConstraintViolationException(
        ConstraintViolationException ex) {
        List<FieldError> fieldErrors = ex.getConstraintViolations()
            .stream()
            .map(violation -> {
                String invalidValue = (violation.getInvalidValue() != null) ?
                    violation.getInvalidValue().toString() : "null";
                return new FieldError(
                    violation.getPropertyPath().toString(),
                    violation.getMessage(),
                    invalidValue
                );
            })
            .toList();

        return ErrorResponse.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .timestamp(LocalDateTime.now())
            .message("Validation failed")
            .errors(fieldErrors)
            .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailAlreadyTakenException.class)
    public ErrorResponse handleEmailAlreadyTakenException(
        EmailAlreadyTakenException ex) {
        return ErrorResponse.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .timestamp(LocalDateTime.now())
            .message(ex.getMessage())
            .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordsDontMatchException.class)
    public ErrorResponse handlePasswordsDontMatchException(
        PasswordsDontMatchException ex) {
        return ErrorResponse.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .timestamp(LocalDateTime.now())
            .message(ex.getMessage())
            .build();
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleUnprocessableMsgException(
        HttpMessageNotReadableException msgNotReadable) {
        return ErrorResponse.builder()
            .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
            .timestamp(LocalDateTime.now())
            .message(msgNotReadable.getMessage())
            .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleInternalServerError(Exception ex) {
        return ErrorResponse.builder()
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .timestamp(LocalDateTime.now())
            .message(ex.getMessage())
            .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotExistsException.class)
    public ErrorResponse handleEntityNotExistsException(
        EntityNotExistsException ex) {
        return ErrorResponse.builder()
            .status(HttpStatus.NOT_FOUND.value())
            .timestamp(LocalDateTime.now())
            .message(ex.getMessage())
            .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsernameNotFoundException.class)
    public ErrorResponse handleUsernameNotFoundException(
        UsernameNotFoundException ex) {
        return ErrorResponse.builder()
            .status(HttpStatus.NOT_FOUND.value())
            .timestamp(LocalDateTime.now())
            .message(ex.getMessage())
            .build();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(IncorrectPasswordException.class)
    public ErrorResponse handleIncorrectPasswordException(
        IncorrectPasswordException ex) {
        return ErrorResponse.builder()
            .status(HttpStatus.UNAUTHORIZED.value())
            .timestamp(LocalDateTime.now())
            .message(ex.getMessage())
            .build();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ErrorResponse handleInternalAuthenticationServiceException(
        InternalAuthenticationServiceException ex) {
        return ErrorResponse.builder()
            .status(HttpStatus.UNAUTHORIZED.value())
            .timestamp(LocalDateTime.now())
            .message(ex.getMessage())
            .build();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({InvalidTokenException.class, MalformedJwtException.class})
    public ErrorResponse handleInvalidTokenException(
        InvalidTokenException ex) {
        return ErrorResponse.builder()
            .status(HttpStatus.UNAUTHORIZED.value())
            .timestamp(LocalDateTime.now())
            .message(ex.getMessage())
            .build();
    }
}
