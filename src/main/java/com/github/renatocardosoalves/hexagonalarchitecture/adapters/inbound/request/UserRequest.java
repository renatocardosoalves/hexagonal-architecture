package com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.request;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.UUID;

public class UserRequest {

    @JsonView(Views.Put.class)
    private UUID id;
    @JsonView({Views.Put.class, Views.Post.class})
    private String name;
    @JsonView({Views.Put.class, Views.Post.class})
    private String linkedIn;
    @JsonView({Views.Put.class, Views.Post.class})
    private String github;
    @JsonView({Views.Put.class, Views.Post.class})
    private String zipCode;

    public class Views {
        public static class Post {}
        public static class Put {}
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
