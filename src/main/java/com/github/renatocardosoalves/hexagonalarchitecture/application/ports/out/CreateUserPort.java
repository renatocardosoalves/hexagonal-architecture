package com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out;

import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;

public interface CreateUserPort {

    User execute(User user);
}
