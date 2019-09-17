package com.yujun.util.mongodb.base.collection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/17 15:37
 * @description TODO
 **/
@Getter
@Setter
@NoArgsConstructor
public class YellowPeople extends Person {
    private String color;

    public String toString() {
        return super.toString() + ", color= " + color;
    }
}
