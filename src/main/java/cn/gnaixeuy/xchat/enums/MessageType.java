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
public enum MessageType {

    /**
     * 私聊
     */
    PRIVATE(1),
    /**
     * 群聊
     */
    GROUP(2),
    ERROR(-1);

    private final Integer code;

    public static MessageType match(Integer code) {
        for (MessageType value : MessageType.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return ERROR;
    }

}