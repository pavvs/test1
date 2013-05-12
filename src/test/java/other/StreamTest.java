package other;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 29.04.13
 * Time: 12:27
 * To change this template use File | Settings | File Templates.
 */
public class StreamTest {

    public static final String FILE_NAME = "c:/streamtest.txt";
    private static ByteArrayOutputStream memory;

    public static void main(String[] args) throws IOException {
//        InputStream
//        OutputStream
//        Reader
//        Writer
//        InputStreamReader
//        OutputStreamWriter

//        Writer out = new FileWriter("c:/streamtest.txt");
//        out.write("Hello world!");
//        out.close();

        OutputStream out1 = getOutputStream();
        DataOutputStream dos = new DataOutputStream(out1);
        dos.writeDouble(3.5);
        dos.writeBoolean(true);
        dos.writeUTF("Hello.");
        out1.close();

        InputStream in1 = getInputStream();
        DataInputStream dis = new DataInputStream(in1);
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readUTF());
        in1.close();
    }

    private static OutputStream getOutputStream() throws FileNotFoundException {
        StreamTest.memory = new ByteArrayOutputStream();
        return StreamTest.memory;
    }

    private static InputStream getInputStream() throws FileNotFoundException {
//        return new FileInputStream(FILE_NAME);
        return new ByteArrayInputStream(StreamTest.memory.toByteArray());
    }
}
