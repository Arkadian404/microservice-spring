package org.zafu.postservice.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.zafu.postservice.dto.PageResponse;
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

    public PageResponse<PostResponse> getMyPost(int page, int size){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = Long.valueOf(authentication.getName());
        Sort sort = Sort.by("createdDate").descending();
        Pageable pageable = PageRequest.of(page-1, size, sort);
        var pageData = postRepo.findAllByUserId(userId, pageable);
        return PageResponse.<PostResponse>builder()
                .currentPage(page)
                .pageSize(pageData.getSize())
                .totalPages(pageData.getTotalPages())
                .totalElements(pageData.getTotalElements())
                .data(pageData.getContent()
                        .stream().map(mapper::toPostResponse).toList())
                .build();

    }
}
