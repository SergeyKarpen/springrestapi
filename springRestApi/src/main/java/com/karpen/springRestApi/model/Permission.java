package com.karpen.springRestApi.model;

public enum Permission {
    DEVELOPERS_WRITE("developer:write"),
    DEVELOPERS_READ("developer:read")
    ;

    private final String permission;


    public String getPermission() {
        return permission;
    }

    Permission(String permission) {
        this.permission = permission;


    }
}
