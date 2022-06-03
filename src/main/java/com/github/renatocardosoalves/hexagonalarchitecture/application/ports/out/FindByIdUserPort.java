package com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out;

import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;

import java.util.UUID;

public interface FindByIdUserPort {

    User execute(UUID id);
}
