package rpc;

import rpc.service.TestService;

/**
 * Created by Administrator on 2017/1/18.
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        TestService service = RpcFrameWork.refer(TestService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            service.hello("World" + i);
            Thread.sleep(1000);
        }
    }
}
