package com.yujun.util.mongodb;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/16 10:53
 * @description TODO
 **/
@EnableMongoRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE)
public interface Config {
}
