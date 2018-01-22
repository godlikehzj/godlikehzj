package com.godlikehzj.dubbo.provider;

import com.godlikehzj.api.DemoService;

public class DemoServiceImpl implements DemoService {
    private static int i = 0;
    public int dubboTest() {
        System.out.println("this is dubbo test");
        return ++i;
    }
}
