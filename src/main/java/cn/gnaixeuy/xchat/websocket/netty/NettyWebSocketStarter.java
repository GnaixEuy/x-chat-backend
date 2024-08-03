package cn.gnaixeuy.xchat.websocket.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

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
public class NettyWebSocketStarter {

    private static EventLoopGroup boosGroup = new NioEventLoopGroup();
    private static EventLoopGroup workerGroup = new NioEventLoopGroup();
    private HandlerWebSocket handlerWebSocket;

    @PreDestroy
    public void close() {
        boosGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    @Async
    public void start(int port) {

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boosGroup, workerGroup);
            serverBootstrap.channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(new ChannelInitializer<>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline
                                    // 对http 支持
                                    .addLast(new HttpServerCodec())
                                    .addLast(new HttpObjectAggregator(1024 * 64))
                                    .addLast(new IdleStateHandler(6, 0, 0, TimeUnit.SECONDS))
                                    .addLast(new HandlerHeartBeat())
                                    .addLast(new WebSocketServerProtocolHandler("/ws", null, true, 64 * 1024, true, true, 10000L))
                                    .addLast(handlerWebSocket);
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            log.info("netty 启动成功");
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("启动netty 失败", e);
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    @Autowired
    public void setHandlerWebSocket(HandlerWebSocket handlerWebSocket) {
        this.handlerWebSocket = handlerWebSocket;
    }

}