package core.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Permition.WRITE,Permition.READ)),
    USER(Set.of(Permition.READ));
    private final Set<Permition> permitions;

    Role(Set<Permition> permitions) {
        this.permitions = permitions;
    }

    public Set<Permition> getPermitions() {
        return permitions;
    }
    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermitions().stream().map(permition -> new SimpleGrantedAuthority(permition.getPermission()))
                .collect(Collectors.toSet());
    }
}
