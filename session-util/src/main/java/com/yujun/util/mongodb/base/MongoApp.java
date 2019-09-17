package com.yujun.util.mongodb.base;

import com.yujun.util.mongodb.base.collection.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author hunter
 * @version 1.0.0
 * @date 9/16/19 10:28 PM
 * @description TODO
 **/
@Slf4j
public class MongoApp {

    public static void main(String[] args) throws Exception {

        /*MongoClient client = new MongoClient("127.0.0.1", 27017);

        MongoOperations mongoOperations = new MongoTemplate(client, "test");
        //Person joe = mongoOperations.insert(new Person("Joe", 34));
        Person joe = new Person("Joe", 34);
        Session sessions = new Session();
        sessions.setPerson(joe);
        Session insert = mongoOperations.insert(sessions);
        //log.info(joe.toString());
        log.info(insert.toString());
//        log.info(String.valueOf(mongoOperations.findOne(new Query(where("name").is("Joe")), Person.class)));
        //mongoOperations.dropCollection("person");
        client.close();*/
        useCustomTypeMapper();
    }

    
    /** 
     * 使用定制MongoTypeMapper，使插入的字段中不包含_class字段，默认插入会包含_class字段
     * @author: yujun
     * @date: 2019/9/17
     * @description: TODO 
     * @param 
     * @return: 
     * @exception: 
    */
    public static void useCustomTypeMapper() throws Exception {
        SampleMongoConfiguration configuration = new SampleMongoConfiguration();
        //MongoClient client = configuration.mongoClient();
        MongoOperations mongoOperations = configuration.mongoTemplate();
        //Person joe = mongoOperations.insert(new Person("Joe", 34));
        Person joe = new Person("Joe", 34);
        Session sessions = new Session();
        sessions.setPerson(joe);
        //执行插入操作时不指定collection，spring会使用类名（驼峰命名，首字母小写）作为collection name
        Session insert = mongoOperations.insert(sessions);
        //执行插入操作时可指定collection name，建议使用此方法
        mongoOperations.insert(sessions, "utilsession");
        //log.info(joe.toString());
        log.info(insert.toString());

        com.yujun.util.mongodb.base.collection.Person yellowPeople = new com.yujun.util.mongodb.base.collection.Person();
//        yellowPeople.setColor("white");
        yellowPeople.setAge(24);
        yellowPeople.setGender("female");
        yellowPeople.setName("Liu");
        com.yujun.util.mongodb.base.collection.Person y = mongoOperations.insert(yellowPeople);
        log.info("Insert yellow: " + y.toString());
        //findOne也和insert方法类似，可指定查询的collection name，若不指定，则使用传入的class参数类名。
        Session one = mongoOperations.findOne(new Query(where("name").is("Joe")), Session.class);
        log.info(one != null ? one.toString() : "");
//        mongoOperations.dropCollection(Session.class);
//        log.info(String.valueOf(mongoOperations.findOne(new Query(where("name").is("Joe")), Person.class)));
        //mongoOperations.dropCollection("person");
    }
}
