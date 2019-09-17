package com.yujun.util.mongodb.base.mongotemplate;

import com.mongodb.MongoClient;
import com.yujun.util.mongodb.base.Const;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/17 15:58
 * @description TODO
 **/
@Configuration
public class TemplateMongoConfiguration extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(Const.HOST, Const.PORT);
    }

    @Override
    protected String getDatabaseName() {
        return Const.DATABASENAME;
    }

    /** 
     * MongoTemplate的三种初始化方法
     * @author: yujun
     * @date: 2019/9/17
     * @description: TODO 
     * @param 
     * @return: {@link MongoTemplate}
     * @exception: 
    */
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate template = null;
        //
        template = new MongoTemplate(mongoClient(), getDatabaseName());
        //
        template = new MongoTemplate(mongoDbFactory());

        //可设置MappingMongoConverter
        template = new MongoTemplate(mongoDbFactory(), mappingMongoConverter());
        return template;
    }

    public MappingMongoConverter mappingMongoConverter() throws Exception {
        MappingMongoConverter mappingMongoConverter = super.mappingMongoConverter();
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return mappingMongoConverter;
    }

}
