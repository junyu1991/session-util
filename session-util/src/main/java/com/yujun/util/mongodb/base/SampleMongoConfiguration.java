package com.yujun.util.mongodb.base;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoTypeMapper;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/17 11:31
 * @description TODO
 **/
@Configuration
public class SampleMongoConfiguration extends AbstractMongoConfiguration {

    private final String DATABASE = "testsession";

    @Override
    @Bean
    public MongoClient mongoClient() {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return DATABASE;
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(mongoClient(), DATABASE);
    }

    /**
     * 使用默认DefaultMongoTypeMapper的MongoTemplate
     * @author: yujun
     * @date: 2019/9/18
     * @description: TODO
     * @param
     * @return: {@link MongoTemplate}
     * @exception:
    */
    @Bean
    public MongoTemplate defaultMongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

    /** 
     * 使用定制的DefaultMongoTypeMapper，使的插入mongodb中的数据没有_class字段，默认会插入_class字段
     * @author: yujun
     * @date: 2019/9/17
     * @description: TODO 
     * @param 
     * @return: {@link MongoTemplate}
     * @exception: 
    */
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MappingMongoConverter mappingMongoConverter = mappingMongoConverter();
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), mappingMongoConverter);
        return mongoTemplate;
    }

    @Bean
    public MappingMongoConverter mappingMongoConverter() throws Exception {
        MappingMongoConverter mappingMongoConverter = super.mappingMongoConverter();
        mappingMongoConverter.setTypeMapper(customTypeMapper());
        return mappingMongoConverter;
    }

    @Bean
    public MongoTypeMapper customTypeMapper() {
        //使用null初始化DefaultMongoTypeMapper，不插入_class字段。
        return new DefaultMongoTypeMapper(null);
    }
}
