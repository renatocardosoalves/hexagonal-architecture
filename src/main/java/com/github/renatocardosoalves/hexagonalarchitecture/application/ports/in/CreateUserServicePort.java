package com.github.renatocardosoalves.hexagonalarchitecture.application.ports.in;

import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;

public interface CreateUserServicePort {

    User execute(User user, String zipCode);
}
