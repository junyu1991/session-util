package com.yujun.util.mongodb.session;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import com.yujun.util.mongodb.session.VO.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends MongoRepository<Session, String> {

    /**
     * 根据ID查询MongoDB中的session
     * @author: yujun
     * @date: 2019/9/16
     * @description: TODO
     * @param id
     * @return: {@link Optional< Session>}
     * @exception:
    */
    Optional<Session> findById(@NonNull String id);

    /**
     * 根据用户名查询用户session列表
     * @author: yujun
     * @date: 2019/9/16
     * @description: TODO
     * @param username
     * @return: {@link List< Session>}
     * @exception:
    */
    List<Session> findByUsername(@Nullable String username);

    /**
     * 根据用户id删除用户
     * @author: yujun
     * @date: 2019/9/16
     * @description: TODO
     * @param id
     * @return:
     * @exception:
    */
    void deleteById(String id);
}
