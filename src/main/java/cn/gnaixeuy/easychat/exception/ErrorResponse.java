package cn.gnaixeuy.easychat.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * easy-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
@Data
public class ErrorResponse {

    private Integer code;
    private String msg;
    private Object trace;

}