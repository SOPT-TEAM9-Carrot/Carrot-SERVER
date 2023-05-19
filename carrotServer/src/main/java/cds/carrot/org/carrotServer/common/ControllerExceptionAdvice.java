package cds.carrot.org.carrotServer.common;

import cds.carrot.org.carrotServer.common.dto.ErrorType;
import cds.carrot.org.carrotServer.common.dto.JsonResponse;
import cds.carrot.org.carrotServer.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 400 BAD_REQUEST
     */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected JsonResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        FieldError fieldError = Objects.requireNonNull(e.getFieldError());
        return JsonResponse.error(ErrorType.REQUEST_HEADER_TOKEN_EXCEPTION, String.format("%s. (%s)", fieldError.getDefaultMessage(), fieldError.getField()));
    }

    /**
     * 500 Internal Server
     */

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    protected JsonResponse<Object> handleException(final Exception e) {
        return JsonResponse.error(ErrorType.INTERNAL_SERVER_ERROR);
    }

    /**
     * api custom error
     */

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<JsonResponse> handleCustomException(ApiException e) {
        return ResponseEntity.status(e.getHttpStatus())
                .body(JsonResponse.error(e.getError(), e.getMessage()));
    }
}
