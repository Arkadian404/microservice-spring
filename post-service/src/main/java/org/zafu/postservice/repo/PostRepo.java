package org.zafu.postservice.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.zafu.postservice.entity.Post;


public interface PostRepo extends MongoRepository<Post, String > {

    Page<Post> findAllByUserId(Long id, Pageable pageable);
}
