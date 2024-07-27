package cn.gnaixeuy.xchat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * x-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
@Getter
@AllArgsConstructor
public enum CommandType {

    /**
     * 建立链接
     */
    CONNECTION(10001),
    CHAT(10002),
    ERROR(-1),
    ;

    private final Integer code;

    public static CommandType match(Integer code) {
        for (CommandType value : CommandType.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return ERROR;
    }

}