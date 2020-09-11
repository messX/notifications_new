package core.lib.controller;

import core.lib.dto.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestApiControllerAdvice extends ResponseEntityExceptionHandler {

    private String formatAndGetResponse(List<Object> list, Exception ex){
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getMessage());
        builder.append("Request method is not supported the available methods are ");
        list.forEach(t -> builder.append(t.toString()));
        return builder.toString();
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Set<HttpMethod> supportedMethods = ex.getSupportedHttpMethods();
        return buildResponse(ApiError.builder()
                .status(status)
                .message(formatAndGetResponse(Arrays.asList(supportedMethods.toArray().clone()), ex))
                .timestamp(LocalDateTime.now()).build());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<MediaType> mediaTypes = ex.getSupportedMediaTypes();
        if (!CollectionUtils.isEmpty(mediaTypes)) {
            headers.setAccept(mediaTypes);
        }

        return buildResponse(ApiError.builder().status(status)
                .message(formatAndGetResponse(Collections.singletonList(mediaTypes), ex))
                .timestamp(LocalDateTime.now()).build());
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponse(ApiError.builder().status(status)
                .message(String.format("Missing parameters %s", ex.getMessage()))
                .timestamp(LocalDateTime.now()).build());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponse(ApiError.builder().status(status)
                .message(String.format("Missing parameters %s", ex.getMessage()))
                .timestamp(LocalDateTime.now()).build());
    }

    /**
     * Handles EntityNotFoundException. Created to encapsulate errors with more detail than javax.persistence.EntityNotFoundException.
     *
     * @param ex the EntityNotFoundException
     * @return the ApiError object
     */
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).build();
        apiError.setMessage(ex.getMessage());
        return buildResponse(apiError);
    }

    private ResponseEntity<Object> buildResponse(ApiError apiError){
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
