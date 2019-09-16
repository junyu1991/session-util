package com.yujun.util.mongodb.session;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/16 10:58
 * @description TODO
 **/
public class Test {

    private final SessionRepository repository;

    public Test(SessionRepository repository) {
        this.repository = repository;
    }

    void testFind(String id) {
        System.out.println(this.repository.findById(id));
    }
}
