package com.github.renatocardosoalves.hexagonalarchitecture.application.core.service;

import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.in.FindAllUsersServicePort;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.FindAllUsersPort;

import java.util.List;

public class FindAllUsersService implements FindAllUsersServicePort {

    private final FindAllUsersPort findAllUsers;

    public FindAllUsersService(FindAllUsersPort findAllUsers) {
        this.findAllUsers = findAllUsers;
    }

    @Override
    public List<User> execute(Integer page, Integer size) {
        return this.findAllUsers.execute(page, size);
    }
}
