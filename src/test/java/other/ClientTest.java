package other;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 29.04.13
 * Time: 13:25
 * To change this template use File | Settings | File Templates.
 */
public class ClientTest {

    public static void main(String[] args) throws IOException {
        System.out.println("Making connect to the server...");
        Socket socket = new Socket(InetAddress.getLocalHost(), 15000);
        System.out.println("Connected, push number 500.");
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(500);
        System.out.println("Pushed, closing connection.");
        out.close();
        System.out.println("Done.");
    }
}
