package com.mongotelusko.joblisting.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongotelusko.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post,String>{

	@Query(value="{techs:'?0'}")
    List<Post> findByTech(String tech);
}
