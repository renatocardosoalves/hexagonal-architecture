package com.github.renatocardosoalves.hexagonalarchitecture.application.ports.in;

import java.util.UUID;

public interface DeleteUserServicePort {

    void execute(UUID id);
}
