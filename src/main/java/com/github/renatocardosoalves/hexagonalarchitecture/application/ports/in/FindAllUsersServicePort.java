package com.github.renatocardosoalves.hexagonalarchitecture.application.ports.in;

import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;

import java.util.List;

public interface FindAllUsersServicePort {

    List<User> execute(Integer page, Integer size);
}
