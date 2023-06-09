package cds.carrot.org.carrotServer.exception;

import cds.carrot.org.carrotServer.common.dto.ErrorType;

public class ApiException extends RuntimeException {
    private final ErrorType error;

    public ApiException(ErrorType error, String message) {
        super(message);
        this.error = error;
    }

    public int getHttpStatus() {
        return this.error.getHttpStatusCode();
    }

    public ErrorType getError() {
        return this.error;
    }
}
