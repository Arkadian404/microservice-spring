package org.zafu.postservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.zafu.postservice.entity.Post;

import java.util.List;

public interface PostRepo extends MongoRepository<Post, String > {

    List<Post> findAllByUserId(Long id);
}
