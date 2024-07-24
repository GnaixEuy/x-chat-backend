package cn.gnaixeuy.xchat.service;

import cn.gnaixeuy.xchat.entity.User;
import cn.gnaixeuy.xchat.exception.BizException;
import cn.gnaixeuy.xchat.exception.ExceptionType;
import cn.gnaixeuy.xchat.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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
public abstract class BaseService {

    private UserRepository userRepository;

    protected User getCurrentUserEntity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(String.valueOf(authentication));
        return this.loadUserByUsername(authentication.getName());
    }

    protected User loadUserByUsername(String username) {

        Optional<User> userEntityOptional = this.userRepository.findByUsername(username);
        if (userEntityOptional.isEmpty()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        User user = userEntityOptional.get();
        if (user.getLocked()) {
            throw new BizException(ExceptionType.USER_LOCKED);
        }
        if (!user.getEnabled()) {
            throw new BizException(ExceptionType.USER_NOT_ENABLED);
        }
        return user;

    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}