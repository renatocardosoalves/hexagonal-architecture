package com.github.renatocardosoalves.hexagonalarchitecture.application.core.service;

import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.in.FindByIdUserServicePort;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.FindByIdUserPort;

import java.util.UUID;

public class FindByIdUserService implements FindByIdUserServicePort {

    private final FindByIdUserPort findByIdUser;

    public FindByIdUserService(FindByIdUserPort findByIdUser) {
        this.findByIdUser = findByIdUser;
    }

    @Override
    public User execute(UUID id) {
        return this.findByIdUser.execute(id);
    }
}
