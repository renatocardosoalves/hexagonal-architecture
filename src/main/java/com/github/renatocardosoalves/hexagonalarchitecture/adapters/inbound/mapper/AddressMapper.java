package com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.mapper;

import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.entity.AddressEntity;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound.response.AddressResponse;
import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressEntity toEntity(Address domain) {
        var entity = new AddressEntity();
        BeanUtils.copyProperties(domain, entity);
        return entity;
    }

    public Address toDomain(AddressEntity entity) {
        var domain = new Address();
        BeanUtils.copyProperties(entity, domain);
        return domain;
    }

    public Address toDomain(AddressResponse response) {
        var domain = new Address();
        BeanUtils.copyProperties(response, domain);
        return domain;
    }
}
