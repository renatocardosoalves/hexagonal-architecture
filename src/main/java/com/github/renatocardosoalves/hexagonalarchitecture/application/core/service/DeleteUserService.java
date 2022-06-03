package com.github.renatocardosoalves.hexagonalarchitecture.application.core.service;

import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.in.DeleteUserServicePort;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.in.FindByIdUserServicePort;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.DeleteUserPort;

import java.util.UUID;

public class DeleteUserService implements DeleteUserServicePort {

    private final FindByIdUserServicePort findByIdUserService;
    private final DeleteUserPort deleteUser;

    public DeleteUserService(FindByIdUserServicePort findByIdUserService, DeleteUserPort deleteUser) {
        this.findByIdUserService = findByIdUserService;
        this.deleteUser = deleteUser;
    }

    @Override
    public void execute(UUID id) {
        var user = this.findByIdUserService.execute(id);
        this.deleteUser.execute(user);
    }
}
