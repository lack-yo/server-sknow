import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Feng.Lou on 2016/12/10.
 * IO流相关常用方法
 */
public class IOTest {
    @Test
    public void testFile() throws IOException {
        File f = new File("bb" + File.separator + "cc" + File.separator + "a.txt");
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        if (!f.exists()) {
            f.createNewFile();
        }
    }

    /**
     * 字节流文件读取
     *
     * @throws IOException
     */
    @Test
    public void testInput() throws IOException {
        File f = new File("bb/cc/" + File.separator + "a.txt");
        FileInputStream fis = new FileInputStream(f);
        byte[] br = new byte[255];
        int x = 0;
        while (x != -1) {
            x = fis.read(br);
        }
        fis.close();
        String s = new String(br);
        System.out.println(s);
    }

    @Test
    public void testOutput() throws IOException {
        File f = new File("bb/cc/" + File.separator + "a.txt");
        FileOutputStream fos = new FileOutputStream(f, true);
        String str = "\r\nsdfsmklfaeklj";
        fos.write(str.getBytes());
        fos.close();
    }

}
