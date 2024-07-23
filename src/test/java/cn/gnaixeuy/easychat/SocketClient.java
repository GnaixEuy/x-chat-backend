package cn.gnaixeuy.easychat;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * easy-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * 2024/7/19
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
public class SocketClient {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            Socket socket = new Socket("localhost", 10086);

            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            System.out.println("请输入内容");
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.nextLine();
            printStream.println(msg);
            printStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}