package rpc;

import rpc.service.TestService;
import rpc.service.impl.TestServiceImpl;

/**
 * Created by Administrator on 2017/1/18.
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        TestService service = new TestServiceImpl();
        RpcFrameWork.export(service, 1234);
    }
}
