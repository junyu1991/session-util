package com.yujun.util.mongodb.base;

import lombok.*;

/**
 * @author hunter
 * @version 1.0.0
 * @date 9/16/19 10:26 PM
 * @description TODO
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String toString() {
        return "Person [id=" + id + ", name=" + name
                + ", age=" + age + "]";
    }
}
