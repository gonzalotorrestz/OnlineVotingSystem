package dev.gonzalotorrestz.onlinevotingsystem.exception;

import dev.gonzalotorrestz.onlinevotingsystem.dto.ResponseDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO<?>> handleValidationExceptions(@NotNull MethodArgumentNotValidException ex) {
        String errorMessage = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        ResponseDTO<?> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        responseDTO.setMessage(errorMessage);
        return ResponseEntity.badRequest().body(responseDTO);
    }
}
