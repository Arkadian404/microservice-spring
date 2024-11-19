package org.zafu.postservice.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.zafu.postservice.dto.request.PostRequest;
import org.zafu.postservice.dto.response.PostResponse;
import org.zafu.postservice.entity.Post;
import org.zafu.postservice.mapper.PostMapper;
import org.zafu.postservice.repo.PostRepo;


import java.time.Instant;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostService {
    PostRepo postRepo;
    PostMapper mapper;

    public PostResponse createPost(PostRequest request){
        var auth = SecurityContextHolder.getContext().getAuthentication();

        Post post = Post.builder()
                .userId(Long.valueOf(auth.getName()))
                .content(request.getContent())
                .createdDate(Instant.now())
                .modifiedDate(Instant.now())
                .build();
        return mapper.toPostResponse(postRepo.save(post));
    }

    public List<PostResponse> getMyPost(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = Long.valueOf(authentication.getName());
        return postRepo.findAllByUserId(userId).stream().map(mapper::toPostResponse).toList();
    }
}
