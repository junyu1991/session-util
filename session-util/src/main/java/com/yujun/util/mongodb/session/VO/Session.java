package com.yujun.util.mongodb.session.VO;

import lombok.*;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/16 10:37
 * @description TODO
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    private String sessionID;
    private String userName;
}
