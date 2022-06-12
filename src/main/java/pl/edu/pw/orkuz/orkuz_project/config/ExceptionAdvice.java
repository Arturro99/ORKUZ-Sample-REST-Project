package pl.edu.pw.orkuz.orkuz_project.config;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.edu.pw.orkuz.orkuz_project.endpoint.ErrorResponse;
import pl.edu.pw.orkuz.orkuz_project.exception.core.ConflictException;
import pl.edu.pw.orkuz.orkuz_project.exception.core.NotFoundException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse notFound(NotFoundException e) {
        return ErrorResponse.error(e.getErrorKey(), e.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(CONFLICT)
    public ErrorResponse conflict(ConflictException e) {
        return ErrorResponse.error(e.getErrorKey(), e.getMessage());
    }
}
