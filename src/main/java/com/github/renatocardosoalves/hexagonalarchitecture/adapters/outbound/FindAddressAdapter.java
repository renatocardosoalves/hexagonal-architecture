package com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound;

import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.mapper.AddressMapper;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound.rest.FindAddressRest;
import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.Address;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.out.FindAddressPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressAdapter implements FindAddressPort {

    private final FindAddressRest findAddress;
    private final AddressMapper addressMapper;

    public FindAddressAdapter(FindAddressRest findAddress, AddressMapper addressMapper) {
        this.findAddress = findAddress;
        this.addressMapper = addressMapper;
    }

    @Override
    public Address execute(String zipCode) {
        var response = this.findAddress.execute(zipCode);
        return this.addressMapper.toDomain(response);
    }
}
