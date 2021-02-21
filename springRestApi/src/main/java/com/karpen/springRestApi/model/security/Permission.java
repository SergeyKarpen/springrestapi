package com.karpen.springRestApi.model.security;

public enum Permission {
    WHEN_YOU_ADMIN("admin"),
    WHEN_YOU_USER("user"),
    WHEN_YOU_MODERATOR("moderator")
    ;

    private final String permission;


    public String getPermission() {
        return permission;
    }

    Permission(String permission) {
        this.permission = permission;


    }
}
