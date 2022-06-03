package com.github.renatocardosoalves.hexagonalarchitecture.application.core.exception;

import java.util.UUID;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(UUID userId) {
        this(String.format("Não existe um cadastro de usuário com id %s", userId));
    }
}
