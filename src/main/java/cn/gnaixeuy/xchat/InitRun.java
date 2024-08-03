package cn.gnaixeuy.xchat;

import cn.gnaixeuy.xchat.websocket.netty.NettyWebSocketStarter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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
public class InitRun implements ApplicationRunner {

    private NettyWebSocketStarter nettyWebSocketStarter;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.nettyWebSocketStarter.start(9090);
    }

    @Autowired
    public void setNettyWebSocketStarter(NettyWebSocketStarter nettyWebSocketStarter) {
        this.nettyWebSocketStarter = nettyWebSocketStarter;
    }
    
}