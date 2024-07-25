package cn.gnaixeuy.xchat.service.impl;

import cn.gnaixeuy.xchat.dto.UserDto;
import cn.gnaixeuy.xchat.dto.request.UserUpdateRequest;
import cn.gnaixeuy.xchat.entity.User;
import cn.gnaixeuy.xchat.exception.BizException;
import cn.gnaixeuy.xchat.exception.ExceptionType;
import cn.gnaixeuy.xchat.mapper.UserMapper;
import cn.gnaixeuy.xchat.repository.UserRepository;
import cn.gnaixeuy.xchat.service.BaseService;
import cn.gnaixeuy.xchat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
public class UserServiceImpl extends BaseService implements UserService {

    private UserRepository repository;

    private UserMapper mapper;

    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto get(String id) {
        return this.mapper.toDto(this.getById(id));
    }

    @Override
    public UserDto update(String id, UserUpdateRequest userUpdateRequest) {
        return this.mapper.toDto(
                this.repository.save(
                        this.mapper.updateEntity(this.getById(id), userUpdateRequest)
                )
        );
    }

    private User getById(String id) {
        Optional<User> user = this.repository.findById(id);
        if (user.isEmpty()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }

    @Override
    public void delete(String id) {
        this.repository.delete(this.getById(id));
    }

    @Override
    public Page<UserDto> search(Pageable pageable) {
        return this.repository.findAll(pageable).map(this.mapper::toDto);
    }

    @Override
    public User loadUserByUsername(String username) {
        return super.loadUserByUsername(username);
    }

    @Override
    public UserDto getCurrentUser() {
        return mapper.toDto(super.getCurrentUserEntity());
    }

    @Autowired
    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    private void setRepository(UserRepository repository) {
        this.repository = repository;
    }

}