package com.yujun.util.mongodb.base;

import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;

/**
 * 自定义MongoTypeMapper类
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/17 11:27
 * @description TODO
 **/
public class CustomMongoTypeMapper extends DefaultMongoTypeMapper {
    public static final String DEFAULT_TYPE_KEY = null;
}
