package cn.gnaixeuy.easychat.exception;

import cn.gnaixeuy.easychat.enums.ExceptionType;
import lombok.Getter;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * easy-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * 2024/7/23
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
@Getter
public class BizException extends RuntimeException {

    private final Integer code;

    public BizException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }

}