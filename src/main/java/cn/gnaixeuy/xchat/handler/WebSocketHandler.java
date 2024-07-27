package cn.gnaixeuy.xchat.handler;

import cn.gnaixeuy.xchat.dto.request.Command;
import cn.gnaixeuy.xchat.enums.CommandType;
import cn.gnaixeuy.xchat.vo.response.ResponseResult;
import com.alibaba.fastjson2.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * x-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame frame) throws Exception {
        System.out.println(frame.text());

        try {
            Command command = JSON.parseObject(frame.text(), Command.class);
            switch (CommandType.match(command.getCode())) {
                case CONNECTION -> ConnectionHandler.execute(command, ctx);
                case CHAT -> ChatHandler.execute(ctx, frame);
                default -> ctx.channel().writeAndFlush(ResponseResult.error("不支持的CODE"));
            }
        } catch (Exception e) {
            ctx.channel().writeAndFlush(ResponseResult.error(e.getMessage()));
        }

    }
}