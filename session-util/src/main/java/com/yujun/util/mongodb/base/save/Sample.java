package com.yujun.util.mongodb.base.save;

import org.springframework.core.annotation.AliasFor;
import org.springframework.data.annotation.TypeAlias;

/**
 * spring-mongodb框架在执行存储时会默认插入_class字段，字段值为存储的类的类名，使用{@link org.springframework.data.annotation.TypeAlias}设置该字段值。
 * 若不想使用该功能，则需自己手动设置DefaultMongoTypeMapper，详情见{@link com.yujun.util.mongodb.base.SampleMongoConfiguration}中的customTypeMapper()方法。
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/18 9:31
 * @description TODO
 **/
@TypeAlias("Sample")
public class Sample {
    Contact contact;
}
