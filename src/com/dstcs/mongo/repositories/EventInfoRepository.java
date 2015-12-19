package com.dstcs.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dstcs.domain.EventInfo;

@Repository
public interface EventInfoRepository extends MongoRepository<EventInfo,String>{

}
