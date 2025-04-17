package com.sl.repositry;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sl.entity.UserProfile;


public interface UserProfileRepositry extends MongoRepository<UserProfile, String >{

}
