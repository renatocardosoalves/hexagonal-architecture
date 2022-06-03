package com.github.renatocardosoalves.hexagonalarchitecture.application.core.service;

import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.in.UpdateUserServicePort;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.FindAddressPort;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.UpdateUserPort;

public class UpdateUserService implements UpdateUserServicePort {

    private final UpdateUserPort updateUser;
    private final FindAddressPort findAddress;

    public UpdateUserService(UpdateUserPort updateUser, FindAddressPort findAddress) {
        this.updateUser = updateUser;
        this.findAddress = findAddress;
    }

    @Override
    public User execute(User user, String zipCode) {
        var address = this.findAddress.execute(zipCode);
        user.setAddress(address);
        return this.updateUser.execute(user);
    }
}
