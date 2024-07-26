package cn.gnaixeuy.xchat.controller;

import cn.gnaixeuy.xchat.dto.request.TokenCreateRequest;
import cn.gnaixeuy.xchat.dto.request.UserCreateRequest;
import cn.gnaixeuy.xchat.mapper.UserMapper;
import cn.gnaixeuy.xchat.service.AuthService;
import cn.gnaixeuy.xchat.vo.UserVo;
import cn.gnaixeuy.xchat.vo.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * easy-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
@RestController
@RequestMapping(value = {"/auth"})
public class AuthController {

    private AuthService authService;
    private UserMapper userMapper;

    @PostMapping(value = {"/tokens"})
    public ResponseResult<String> create(@RequestBody TokenCreateRequest tokenCreateRequest) {
        return ResponseResult.ok(this.authService.createToken(tokenCreateRequest));
    }

    @PostMapping(value = {"/register"})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    UserVo register(@Validated @RequestBody UserCreateRequest userCreateRequest) {
        return this.userMapper.toVo(this.authService.register(userCreateRequest));
    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

}