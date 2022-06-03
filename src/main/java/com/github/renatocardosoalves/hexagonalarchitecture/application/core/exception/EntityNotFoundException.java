package com.github.renatocardosoalves.hexagonalarchitecture.application.core.exception;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
