package com.yujun.util.mongodb.base;

import com.mongodb.MongoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author hunter
 * @version 1.0.0
 * @date 9/16/19 10:28 PM
 * @description TODO
 **/
@Slf4j
public class MongdoApp {

    public static void main(String[] args) {

        MongoClient client = new MongoClient("192.168.0.102", 27017);

        MongoOperations mongoOperations = new MongoTemplate(client, "test");
        //mongoOperations.insert(new Person("Joe", 34));
        log.info(String.valueOf(mongoOperations.findOne(new Query(where("name").is("Joe")), Person.class)));
        //mongoOperations.dropCollection("person");
    }
}
