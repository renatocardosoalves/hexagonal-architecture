package com.github.renatocardosoalves.hexagonalarchitecture.adapters.inbound.handler;

public enum ProblemType {

    RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found");

    private final String title;
    private final String uri;

    ProblemType(String path, String title) {
        this.uri = "https://github.com/renatocardosoalves" + path;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }
}
