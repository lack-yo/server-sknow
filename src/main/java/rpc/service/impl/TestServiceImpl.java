package rpc.service.impl;

import rpc.service.TestService;

/**
 * Created by Administrator on 2017/1/18.
 */
public class TestServiceImpl implements TestService {
    @Override
    public void hello(String xx) {
        System.out.println("Hello " + xx);
    }
}
