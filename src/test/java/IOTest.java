import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Feng.Lou on 2016/12/10.
 * IO流相关常用方法
 */
public class IOTest {
    @Test
    public void testFile() throws IOException {
        File f = new File("bb/cc/" + File.separator + "a.txt");
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        if (!f.exists()) {
            f.createNewFile();
        }
    }

    @Test
    public void testInput() throws IOException {
        File f = new File("bb/cc/" + File.separator + "a.txt");
        FileInputStream fis = new FileInputStream(f);
        byte[] br = new byte[255];
        int x = 0;
        while (x != -1) {
            x = fis.read(br);
        }
        String s = new String(br);
        System.out.println(s);
    }

}
