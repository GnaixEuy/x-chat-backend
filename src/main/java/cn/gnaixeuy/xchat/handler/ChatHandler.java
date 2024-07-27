package cn.gnaixeuy.xchat.handler;

import cn.gnaixeuy.xchat.ImServer;
import cn.gnaixeuy.xchat.dto.command.ChatMessage;
import cn.gnaixeuy.xchat.enums.MessageType;
import cn.gnaixeuy.xchat.vo.response.ResponseResult;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * x-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
public class ChatHandler {

    public static void execute(ChannelHandlerContext ctx, TextWebSocketFrame frame) {
        try {
            ChatMessage chatMessage = JSON.parseObject(frame.text(), ChatMessage.class);
            switch (MessageType.match(chatMessage.getChatType())) {
                case PRIVATE -> {
                    if (StrUtil.isNullOrUndefined(chatMessage.getTarget())) {
                        ctx.channel().writeAndFlush(ResponseResult.error("消息发送失败，私聊对象不能为空"));
                        return;
                    }
                    Channel channel = ImServer.USER_CHANNELS.get(chatMessage.getTarget());
                    if (channel == null || !channel.isActive()) {
                        ctx.channel().writeAndFlush(ResponseResult.error("消息发送失败，对方" + chatMessage.getTarget() + "不在线"));
                    } else {
                        channel.writeAndFlush(ResponseResult.ok("私聊消息(" + chatMessage.getNickname() + ")" + chatMessage.getContent()));
                    }
                }
            }
        } catch (Exception e) {
            ctx.channel().writeAndFlush(ResponseResult.error("发送消息格式错误，请确认后再试"));
        }
    }

}