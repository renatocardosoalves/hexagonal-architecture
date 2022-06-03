package com.github.renatocardosoalves.hexagonalarchitecture.application.core.service;

import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.in.CreateUserServicePort;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.CreateUserPort;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.FindAddressPort;

public class CreateUserService implements CreateUserServicePort {

    private final CreateUserPort createUser;
    private final FindAddressPort findAddress;

    public CreateUserService(CreateUserPort createUser, FindAddressPort findAddress) {
        this.createUser = createUser;
        this.findAddress = findAddress;
    }

    @Override
    public User execute(User user, String zipCode) {
        var address = this.findAddress.execute(zipCode);
        user.setAddress(address);
        return this.createUser.execute(user);
    }
}
