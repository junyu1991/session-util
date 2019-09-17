package com.yujun.util.mongodb.base.collection;

import com.yujun.util.mongodb.base.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/17 11:06
 * @description TODO
 **/
@Getter
@Setter
@NoArgsConstructor
public class Session {
    @Id
    private String sessionID;

    private Person person;

    public String toString(){
        return "session [" + sessionID + "] ," + person.toString();
    }

}
