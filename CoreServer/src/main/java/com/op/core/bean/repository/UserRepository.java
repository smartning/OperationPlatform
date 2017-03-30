package com.op.core.bean.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.op.core.bean.entity.User;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/23.
 ****************************************/
public interface UserRepository extends MongoRepository<User, String> {

}