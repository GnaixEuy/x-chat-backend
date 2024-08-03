package cn.gnaixeuy.xchat.websocket.netty;

import cn.hutool.core.util.StrUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * x-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
@Slf4j
@Component
public class HandlerWebSocket extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame frame) throws Exception {
        Channel channel = ctx.channel();
        log.info("收到消息:{}", frame.text());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            String url = ((WebSocketServerProtocolHandler.HandshakeComplete) evt).requestUri();
            String token = getToken(url);
            log.info("token:{}", token);
            if (token != null) {
                ctx.channel().close();
                return;
            }
            log.info("url:{}", url);

            //todo 校验token是否有效， 改造security机制，引入redis
        }

    }

    private String getToken(String url) {
        if (StrUtil.isBlank(url)) {
            return null;
        }
        String[] queryParams = url.split("\\?");
        if (queryParams.length != 2) {
            return null;
        }
        String[] params = queryParams[1].split("=");
        if (params.length != 2) {
            return null;
        }
        return params[1];
    }

    /**
     * 通道就绪后 调用
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        log.info("有新的链接加入...");

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        log.info("有链接断开...");

    }
}