package cds.carrot.org.carrotServer.exception;

import cds.carrot.org.carrotServer.common.dto.ErrorType;

public class NotFoundException extends ApiException {

    public NotFoundException(ErrorType error) {
        super(error, error.getMessage());
    }
}
