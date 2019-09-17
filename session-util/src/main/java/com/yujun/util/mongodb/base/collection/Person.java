package com.yujun.util.mongodb.base.collection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/17 15:34
 * @description TODO
 **/
@Getter
@Setter
@NoArgsConstructor
public class Person {
    private String id;
    private String name;
    private int age;
    private String gender;

    public String toString(){
        return "Person [ id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender;
    }
}
