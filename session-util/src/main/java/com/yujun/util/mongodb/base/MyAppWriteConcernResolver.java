package com.yujun.util.mongodb.base;

import com.mongodb.WriteConcern;
import org.springframework.data.mongodb.core.MongoAction;
import org.springframework.data.mongodb.core.WriteConcernResolver;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/17 17:20
 * @description TODO
 **/
public class MyAppWriteConcernResolver implements WriteConcernResolver {
    @Override
    public WriteConcern resolve(MongoAction action) {
        return null;
    }
}
