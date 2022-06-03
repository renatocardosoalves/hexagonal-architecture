package com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound;

import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.mapper.AddressMapper;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.mapper.UserMapper;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound.repository.UserRepository;
import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.CreateUserPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateUserAdapter implements CreateUserPort {

    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;

    public CreateUserAdapter(UserMapper userMapper, AddressMapper addressMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public User execute(User user) {
        var userEntity = this.userMapper.toEntity(user);
        var addressEntity = this.addressMapper.toEntity(user.getAddress());
        userEntity.setAddress(addressEntity);
        this.userRepository.save(userEntity);
        return this.userMapper.toDomain(userEntity);
    }
}
