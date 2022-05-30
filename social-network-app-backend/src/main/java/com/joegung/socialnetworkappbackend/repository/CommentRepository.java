package com.joegung.socialnetworkappbackend.repository;


import com.joegung.socialnetworkappbackend.entity.CommentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<CommentEntity, String> {
    
}