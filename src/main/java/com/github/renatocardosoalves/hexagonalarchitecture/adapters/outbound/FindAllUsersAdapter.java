package com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound;

import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.mapper.UserMapper;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound.repository.UserRepository;
import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.FindAllUsersPort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllUsersAdapter implements FindAllUsersPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public FindAllUsersAdapter(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> execute(Integer page, Integer size) {
        return this.userRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(this.userMapper::toDomain)
                .collect(Collectors.toList());
    }
}
