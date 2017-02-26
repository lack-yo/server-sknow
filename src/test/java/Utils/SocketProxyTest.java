package Utils;

import org.junit.Test;

/**
 * Created by Administrator on 2017/2/26.
 */
public class SocketProxyTest {

    @Test
    public void connect1() throws Exception {
        SocketProxy client1 = new SocketProxy();
        client1.connect();

    }

    @Test
    public void connect2() throws Exception {
        SocketProxy client2 = new SocketProxy();
        client2.connect();

    }

    @Test
    public void accept() throws Exception {
        SocketProxy server = new SocketProxy();
        server.accept();
    }
}