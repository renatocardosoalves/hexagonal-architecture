package com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.mapper.UserMapper;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.request.UserRequest;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.request.UserRequest.Views.Post;
import com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.request.UserRequest.Views.Put;
import com.github.renatocardosoalves.hexagonalarchitecture.application.core.domain.User;
import com.github.renatocardosoalves.hexagonalarchitecture.application.ports.in.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserServicePort createUserService;
    private final FindByIdUserServicePort findByIdUserService;
    private final FindAllUsersServicePort findAllUserService;
    private final DeleteUserServicePort deleteUserService;
    private final UpdateUserServicePort updateUserService;
    private final UserMapper userMapper;

    public UserController(CreateUserServicePort createUserService,
                          FindByIdUserServicePort findByIdUserService,
                          FindAllUsersServicePort findAllUserService,
                          DeleteUserServicePort deleteUserService,
                          UpdateUserServicePort updateUserService,
                          UserMapper userMapper) {
        this.createUserService = createUserService;
        this.findByIdUserService = findByIdUserService;
        this.findAllUserService = findAllUserService;
        this.deleteUserService = deleteUserService;
        this.updateUserService = updateUserService;
        this.userMapper = userMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Valid @JsonView(Post.class) UserRequest request) {
        var user = this.userMapper.toDomain(request);
        return this.createUserService.execute(user, request.getZipCode());
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable UUID id) {
        return this.findByIdUserService.execute(id);
    }

    @GetMapping
    public List<User> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                              @RequestParam(required = false, defaultValue = "10") Integer size) {
        return this.findAllUserService.execute(page, size);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        this.deleteUserService.execute(id);
    }

    @PutMapping
    public User update(@RequestBody @Valid @JsonView(Put.class) UserRequest request) {
        var user = this.userMapper.toDomain(request);
        return this.updateUserService.execute(user, request.getZipCode());
    }
}
