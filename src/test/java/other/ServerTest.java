package other;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 29.04.13
 * Time: 13:04
 * To change this template use File | Settings | File Templates.
 */
public class ServerTest {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(15000);
        System.out.println("Listening to 15000 port...");
        Socket socket = server.accept();
        System.out.println("Accepted socket: " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        System.out.println("Received number: " + in.readInt());
        in.close();
    }
}
