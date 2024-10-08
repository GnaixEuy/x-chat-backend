package cn.gnaixeuy.xchat.service;

import cn.gnaixeuy.xchat.dto.UserDto;
import cn.gnaixeuy.xchat.dto.request.TokenCreateRequest;
import cn.gnaixeuy.xchat.dto.request.UserCreateRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * easy-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
public interface AuthService extends UserDetailsService {

    UserDto register(UserCreateRequest userCreateRequest);

    String createToken(TokenCreateRequest tokenCreateRequest);

}