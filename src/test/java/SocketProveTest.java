import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;

/**
 * @author loufeng
 * @date 2017/5/4 下午4:02.
 */
public class SocketProveTest {
    @Test
    public void testClient() {
        Socket socket = null;
        InputStream in = null;
        FileOutputStream fos = null;

        try {
            String url = "http://www-net.cs.umass.edu/wireshark-labs/Wireshark_Intro_v7.0.pdf";
            String filePath = "/wireshark-labs/Wireshark_Intro_v7.0.pdf";
            String fileName = "Wireshark_Intro_v7.0.pdf";
            URL urlCon = new URL(url);
            String host = urlCon.getHost();
            socket = new Socket();
            SocketAddress address = new InetSocketAddress(host, 80);
            socket.connect(address);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);
            writer.write("GET " + filePath + " HTTP/1.1\r\n");
            writer.write("HOST: " + host + "\r\n");
            writer.write("Connection: close\r\n");
            writer.write("\r\n");
            writer.flush();


            in = socket.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            fos = new FileOutputStream(new File(fileName));
            String line = null;
            boolean flag = false;
            while ((line = read.readLine()) != null) {
                if (!flag) {
                    System.out.println(line);
                    if (line.length() == 0) {
                        flag = true;
                    }
                } else{
                    fos.write(line.getBytes());
                    fos.write("\r\n".getBytes());

                }
            }
            fos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
                if (in != null)
                    in.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
