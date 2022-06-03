package com.github.renatocardosoalves.hexagonalarchitecture.adapters.outbound.repository;

import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, UUID> {
}
