package com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.handler;

import com.github.renatocardosoalves.hexagonalarchitecture.application.core.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;
        var problemType = ProblemType.RESOURCE_NOT_FOUND;
        var detail = ex.getMessage();
        var problem = this.createProblem(status, problemType, detail);
        problem.setUserMessage(detail);
        return super.handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    private Problem createProblem(HttpStatus status, ProblemType problemType, String detail) {
        var problem = new Problem();
        problem.setTimestamp(LocalDateTime.now());
        problem.setStatus(status.value());
        problem.setType(problemType.getTitle());
        problem.setDetail(detail);
        return problem;
    }
}
