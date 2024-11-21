package org.zafu.profileservice.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.zafu.profileservice.entity.UserProfile;

import java.util.Optional;

public interface UserProfileRepo extends Neo4jRepository<UserProfile, String> {
    Optional<UserProfile> findByUserId(Long userId);
}
