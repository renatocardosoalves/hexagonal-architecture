package com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound.rest;

import com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "findAddress", url = "https://viacep.com.br")
public interface FindAddressRest {

    @GetMapping("/ws/{zipCode}/json")
    AddressResponse execute(@PathVariable String zipCode);
}
