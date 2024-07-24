package cn.gnaixeuy.xchat.service.impl;

import cn.gnaixeuy.xchat.entity.User;
import cn.gnaixeuy.xchat.repository.UserRepository;
import cn.gnaixeuy.xchat.service.AuthService;
import cn.gnaixeuy.xchat.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return super.loadUserByUsername(username);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}