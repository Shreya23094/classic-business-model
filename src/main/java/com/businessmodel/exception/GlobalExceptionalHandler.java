package com.businessmodel.exception;

import com.businessmodel.dto.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
@RestControllerAdvice
@NoArgsConstructor
public class GlobalExceptionalHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleException(final ResourceNotFoundException e, final HttpServletRequest request) {
        return new ErrorDto(e.getMessage(), HttpStatus.NOT_FOUND.value(),LocalDate.now(),request.getRequestURI());
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleException(final BusinessException e, final HttpServletRequest request) {
      return new ErrorDto(e.getMessage(), HttpStatus.BAD_REQUEST.value(),LocalDate.now(),request.getRequestURI());
    }

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleException(final BadRequestException e, final HttpServletRequest request) {
        return new ErrorDto(e.getMessage(), HttpStatus.BAD_REQUEST.value(),LocalDate.now(),request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleGeneral(final Exception e, final HttpServletRequest request) {
        return new ErrorDto("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR.value(),LocalDate.now(),request.getRequestURI());
    }

}
