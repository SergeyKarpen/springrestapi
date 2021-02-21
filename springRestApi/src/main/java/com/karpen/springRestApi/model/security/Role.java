package com.karpen.springRestApi.model.security;

import com.karpen.springRestApi.model.security.Permission;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Permission.WHEN_YOU_ADMIN)),
    USER(Set.of(Permission.WHEN_YOU_USER)),
    MODERATOR(Set.of(Permission.WHEN_YOU_MODERATOR));

    private final Set<Permission> permissionSet;

    Role(Set<Permission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<Permission> getPermissions() {
        return permissionSet;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
