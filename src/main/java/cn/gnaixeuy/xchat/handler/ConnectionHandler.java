package cn.gnaixeuy.xchat.handler;

import cn.gnaixeuy.xchat.ImServer;
import cn.gnaixeuy.xchat.dto.request.Command;
import cn.gnaixeuy.xchat.vo.response.ResponseResult;
import io.netty.channel.ChannelHandlerContext;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * x-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
public class ConnectionHandler {

    public static void execute(Command command, ChannelHandlerContext ctx) {

        if (ImServer.USER_CHANNELS.containsKey(command.getNickname())) {
            ctx.channel().writeAndFlush(ResponseResult.error("该用户已经在线，请更换账户后重新连接"));
            ctx.disconnect();
            return;
        }

        ImServer.USER_CHANNELS.put(command.getNickname(), ctx.channel());

        ctx.channel().writeAndFlush(ResponseResult.ok("连接成功"));

    }

}