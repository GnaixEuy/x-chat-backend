package cn.gnaixeuy.xchat.dto.command;

import cn.gnaixeuy.xchat.dto.request.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * x-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage extends Command {

    /**
     * 操作类型
     */
    private Integer chatType;

    /**
     * 目标对象
     */
    private String target;

    /**
     * 内容
     */
    private String content;

}