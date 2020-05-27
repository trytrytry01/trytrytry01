package com.emart.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="bad request")
public class validateException extends RuntimeException{

	private static final long serialVersionUID = 1L;

    public validateException(String message) {
        super(message);
    }

    public validateException(String message, Throwable cause) {
        super(message, cause);
    }
}
