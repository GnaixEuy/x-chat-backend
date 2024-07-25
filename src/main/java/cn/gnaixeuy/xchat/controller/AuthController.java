package cn.gnaixeuy.xchat.controller;

import cn.gnaixeuy.xchat.dto.request.LoginInfoReq;
import cn.gnaixeuy.xchat.dto.request.RegisterInfoReq;
import cn.gnaixeuy.xchat.service.AuthService;
import cn.gnaixeuy.xchat.vo.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = {"/login"})
    public ResponseResult<String> login(@RequestBody LoginInfoReq loginInfoReq) {

        return null;
    }

    @PostMapping(value = {"/register"})
    public ResponseResult<String> register(@RequestBody RegisterInfoReq registerInfoReq) {

        return null;

    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

}