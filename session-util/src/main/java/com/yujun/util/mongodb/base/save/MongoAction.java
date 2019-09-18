package com.yujun.util.mongodb.base.save;

import com.yujun.util.mongodb.base.Person;
import com.yujun.util.mongodb.base.SampleMongoConfiguration;
import com.yujun.util.mongodb.base.collection.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/18 10:01
 * @description TODO
 **/
@Slf4j
public class MongoAction {

    private static SampleMongoConfiguration sampleMongoConfiguration = new SampleMongoConfiguration();
    private static MongoOperations mongoOperations;

    static {
        try {
            mongoOperations = sampleMongoConfiguration.mongoTemplate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testSave() throws Exception {

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
