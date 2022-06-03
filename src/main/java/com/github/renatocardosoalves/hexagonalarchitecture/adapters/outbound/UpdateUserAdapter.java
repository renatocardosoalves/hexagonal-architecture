package com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound;

import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.mapper.UserMapper;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound.repository.UserRepository;
import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;
import com.github.renatocardosoalves.hexagonalarchitecture.application.core.exception.UserNotFoundException;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.UpdateUserPort;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateUserAdapter implements UpdateUserPort {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UpdateUserAdapter(UserMapper userMapper,
                             UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public User execute(User user) {
        var actualUser = this.userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException(user.getId()));
        BeanUtils.copyProperties(user, actualUser, "id");
        var actualAddress = actualUser.getAddress();
        BeanUtils.copyProperties(user.getAddress(), actualAddress, "id");
        return this.userMapper.toDomain(actualUser);
    }
}
