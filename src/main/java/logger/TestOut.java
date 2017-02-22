package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/2/12.
 */
public class TestOut {
    private static Logger logger = LoggerFactory.getLogger(TestOut.class);

    public static void main(String[] args) {
        logger.info("111111111");
    }
}
