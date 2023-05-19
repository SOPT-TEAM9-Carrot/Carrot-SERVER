package cds.carrot.org.carrotServer.exception;

import cds.carrot.org.carrotServer.common.dto.ErrorType;

public class BadRequestException extends ApiException {

    public BadRequestException(ErrorType error) {
        super(error, error.getMessage());
    }
}
