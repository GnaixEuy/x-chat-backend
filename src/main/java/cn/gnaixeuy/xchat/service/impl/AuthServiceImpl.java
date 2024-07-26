package cn.gnaixeuy.xchat.service.impl;

import cn.gnaixeuy.xchat.config.SecurityConfig;
import cn.gnaixeuy.xchat.dto.UserDto;
import cn.gnaixeuy.xchat.dto.request.TokenCreateRequest;
import cn.gnaixeuy.xchat.dto.request.UserCreateRequest;
import cn.gnaixeuy.xchat.entity.User;
import cn.gnaixeuy.xchat.exception.BizException;
import cn.gnaixeuy.xchat.exception.ExceptionType;
import cn.gnaixeuy.xchat.mapper.UserMapper;
import cn.gnaixeuy.xchat.repository.UserRepository;
import cn.gnaixeuy.xchat.service.AuthService;
import cn.gnaixeuy.xchat.service.BaseService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * easy-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
@Slf4j
@Service
public class AuthServiceImpl extends BaseService implements AuthService {

    UserMapper userMapper;
    UserRepository userInfoRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public UserDto register(UserCreateRequest userCreateRequest) {
        this.checkUserName(userCreateRequest.getUsername());
        User user = this.userMapper.createEntity(userCreateRequest);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return this.userMapper.toDto(userInfoRepository.save(user));
    }

    private void checkUserName(String username) {
        Optional<User> user = userInfoRepository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }

    @Override
    public String createToken(TokenCreateRequest tokenCreateRequest) {
        User user = loadUserByUsername(tokenCreateRequest.getUsername());
        if (!this.passwordEncoder.matches(tokenCreateRequest.getPassword(), user.getPassword())) {
            throw new BizException(ExceptionType.USER_PASSWORD_NOT_MATCH);
        }
        if (!user.isEnabled()) {
            throw new BizException(ExceptionType.USER_NOT_ENABLED);
        }

        if (!user.isAccountNonLocked()) {
            throw new BizException(ExceptionType.USER_LOCKED);
        }

        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()));
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return super.loadUserByUsername(username);
    }

    @Autowired
    public void setUserInfoRepository(UserRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

}