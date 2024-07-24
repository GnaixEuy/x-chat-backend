package cn.gnaixeuy.xchat.entity;

import cn.gnaixeuy.xchat.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "x-chat")
public class User extends BaseEntity implements UserDetails {

    @Column(name = "username", length = 64)
    private String username;

    @Column(name = "nickname", length = 128)
    private String nickname;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "email", length = 32)
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "phone", length = 32)
    private String phone;

    @Column(name = "address", length = 256)
    private String address;

    @Column(name = "avatar_url", length = 1024)
    private String avatarUrl;

    @Column(name = "personal_signature", length = 1024)
    private String personalSignature;

    @Column(name = "website_url", length = 1024)
    private String websiteUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 12)
    private Gender gender;

    @Column(name = "locked", nullable = false)
    private Boolean locked = false;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = false;

    @Column(name = "last_login_ip", length = 64)
    private String lastLoginIp;

    @Column(name = "last_login_time")
    private Instant lastLoginTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_associate", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roleList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roleList.stream()
                .map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getName()))
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}