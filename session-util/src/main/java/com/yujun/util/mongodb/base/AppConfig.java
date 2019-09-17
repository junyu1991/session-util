package com.yujun.util.mongodb.base;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.jndi.MongoClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.Collections;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/17 10:20
 * @description TODO
 **/
@Configuration
public class AppConfig {

    public @Bean MongoClient mongoClient(){
        MongoClient client = new MongoClient("127.0.0.1", 27017);
        return client;
    }

    /**
     * 使用MongoClientFactoryBean初始化mongoclient工厂，利用此方法可设置更多MongoClient连接参数
     * @author: yujun
     * @date: 2019/9/17
     * @description: TODO
     * @param
     * @return: {@link MongoClientFactoryBean}
     * @exception:
    */
    @Bean
    public MongoClientFactoryBean mongo(){
        MongoClientFactoryBean mongoClientFactoryBean = new MongoClientFactoryBean();
        mongoClientFactoryBean.setHost("127.0.0.1");
        mongoClientFactoryBean.setPort(27017);

        //设置连接mongodb server所需要的username和password，同时设置数据库名
        mongoClientFactoryBean.setCredentials(new MongoCredential[]{MongoCredential.createCredential("username", "database", "pwd".toCharArray())});

        mongoClientFactoryBean.setMongoClientOptions(null);
        return mongoClientFactoryBean;
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(new MongoClient("127.0.0.1", 27017), "sessiondatabase");
    }

    /** 
     * 当mongdodb设置了用户名密码验证时，使用MongoCredential设置用户安全认证相关信息
     * @author: yujun
     * @date: 2019/9/17
     * @description: TODO 
     * @param 
     * @return: {@link MongoClient}
     * @exception: 
    */
    public @Bean MongoClient mongoClientCre(){
        return new MongoClient(Collections.singletonList(new ServerAddress("127.0.0.1", 27017)),
                MongoCredential.createCredential("name", "db", "pwd".toCharArray()),
                null);
    }

    public @Bean MongoTemplate mongoTemplate(){
        MongoTemplate template = new MongoTemplate(mongoClient(), "sessiondatabase");
        return template;
    }

}
