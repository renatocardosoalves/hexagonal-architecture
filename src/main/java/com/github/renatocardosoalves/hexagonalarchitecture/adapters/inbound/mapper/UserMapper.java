package com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.mapper;

import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.entity.UserEntity;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.request.UserRequest;
import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final AddressMapper addressMapper;

    public UserMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public UserEntity toEntity(User domain) {
        var entity = new UserEntity();
        BeanUtils.copyProperties(domain, entity);
        entity.setAddress(this.addressMapper.toEntity(domain.getAddress()));
        return entity;
    }

    public User toDomain(UserEntity entity) {
        var domain = new User();
        BeanUtils.copyProperties(entity, domain);
        domain.setAddress(this.addressMapper.toDomain(entity.getAddress()));
        return domain;
    }

    public User toDomain(UserRequest request) {
        var domain = new User();
        BeanUtils.copyProperties(request, domain);
        return domain;
    }
}
