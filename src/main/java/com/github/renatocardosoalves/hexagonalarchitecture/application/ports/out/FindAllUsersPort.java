package com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out;

import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;

import java.util.List;

public interface FindAllUsersPort {

    List<User> execute(Integer page, Integer size);
}
