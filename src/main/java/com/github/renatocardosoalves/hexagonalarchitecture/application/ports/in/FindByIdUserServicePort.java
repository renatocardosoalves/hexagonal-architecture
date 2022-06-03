package com.github.renatocardosoalves.hexagonalarchitecture.application.ports.in;

import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;

import java.util.UUID;

public interface FindByIdUserServicePort {

    User execute(UUID id);
}
