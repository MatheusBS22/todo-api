package com.mbsousa.ToDoApi.exception;
import com.mbsousa.ToDoApi.response.StandardResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public StandardResponseApi<Void>handleNotFound(ResourceNotFoundException ex) {
        return new StandardResponseApi<>(null, null, ex.getMessage(), 404);


    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public StandardResponseApi<Void>handleValidationErrors(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult().getFieldErrors()
                     .stream()
                     .map(e -> e.getField() + ": " + e.getDefaultMessage())
                     .collect(Collectors.joining(", "));

             return new StandardResponseApi<>(null, null, errors, 400);
    }


}

