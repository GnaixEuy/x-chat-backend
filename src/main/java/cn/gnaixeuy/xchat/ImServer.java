package cn.gnaixeuy.xchat;

import cn.gnaixeuy.xchat.handler.WebSocketHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * x-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
public class ImServer {

    public static final Map<String, Channel> USER_CHANNELS = new HashMap<>(1024);

    public static void start() {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        // 绑定端口
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // 责任链的方式
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        // 添加http编码解码器
                        pipeline
                                .addLast(new HttpServerCodec())
                                // 支持大数据
                                .addLast(new ChunkedWriteHandler())
                                // 对http 消息做聚合操作  FullHttpRequest、 FullHttpResponse
                                .addLast(new HttpObjectAggregator(1024 * 64))
                                // websocket
                                .addLast(new WebSocketServerProtocolHandler("/"))
                                // 消息读取
                                .addLast(new WebSocketHandler());

                    }
                });

        ChannelFuture future = serverBootstrap.bind(9090);
    }

}