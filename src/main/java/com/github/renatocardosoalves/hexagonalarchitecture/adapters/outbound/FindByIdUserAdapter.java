package com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound;

import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.mapper.UserMapper;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound.repository.UserRepository;
import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;
import com.github.renatocardosoalves.hexagonalarchitecture.application.core.exception.UserNotFoundException;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.FindByIdUserPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FindByIdUserAdapter implements FindByIdUserPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public FindByIdUserAdapter(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User execute(UUID id) {
        return this.userRepository.findById(id)
                .map(this.userMapper::toDomain)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
