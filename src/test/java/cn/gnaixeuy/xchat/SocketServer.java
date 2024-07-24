package cn.gnaixeuy.xchat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * x-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * 2024/7/19
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
public class SocketServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(10086);
            System.out.println("服务已启动，等待客户端链接");
            Socket socket = server.accept();
            System.out.println("客户端已连接");
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("有客户端链接ip：" + inetAddress.getHostAddress() + "端口为：" + socket.getPort());

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String msg = bufferedReader.readLine();
            System.out.println("接收到客户端信息->" + msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}