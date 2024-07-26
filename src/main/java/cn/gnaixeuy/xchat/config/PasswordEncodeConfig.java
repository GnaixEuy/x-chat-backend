package cn.gnaixeuy.xchat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * x-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
@Configuration
public class PasswordEncodeConfig {

    /**
     * 密码明文加密方式配置
     *
     * @return BCryptPasswordEncoder密码加密编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}