package com.github.renatocardosoalves.hexagonalarchitecture.configuration;

import com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound.*;
import com.github.renatocardosoalves.hexagonalarchitecture.application.core.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public CreateUserService createUserService(CreateUserAdapter createUser, FindAddressAdapter findAddress) {
        return new CreateUserService(createUser, findAddress);
    }

    @Bean
    public FindByIdUserService findByIdUserService(FindByIdUserAdapter findByIdUser) {
        return new FindByIdUserService(findByIdUser);
    }

    @Bean
    public FindAllUsersService findAllUsersService(FindAllUsersAdapter findAllUsers) {
        return new FindAllUsersService(findAllUsers);
    }

    @Bean
    public DeleteUserService deleteUserService(FindByIdUserAdapter findByIdUser, DeleteUserAdapter deleteUser) {
        return new DeleteUserService(this.findByIdUserService(findByIdUser), deleteUser);
    }

    @Bean
    public UpdateUserService updateUserService(UpdateUserAdapter updateUser, FindAddressAdapter findAddress) {
        return new UpdateUserService(updateUser, findAddress);
    }
}
