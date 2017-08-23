package org.flips.describe.controlleradvice;

import org.flips.exception.FeatureNotEnabledException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class FeatureDisabledExceptionControllerAdvice {

    @ExceptionHandler(FeatureNotEnabledException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public @ResponseBody
    ErrorResponse handleUserNotFoundException(FeatureNotEnabledException ex) {
        String message = "Feature not implemented";
        ErrorResponse errorResponse= new ErrorResponse(ex, message);
        return errorResponse;
    }
}