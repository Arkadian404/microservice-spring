package org.zafu.postservice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.zafu.postservice.dto.ApiResponse;
import org.zafu.postservice.dto.PageResponse;
import org.zafu.postservice.dto.request.PostRequest;
import org.zafu.postservice.dto.response.PostResponse;
import org.zafu.postservice.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostController {
    
    PostService postService;

    @GetMapping
    public ApiResponse<PostResponse> seePost(){
        return ApiResponse.<PostResponse>builder()
                .result(postService.createPost(null))
                .build();
    }

    @PostMapping("/create")
    public ApiResponse<PostResponse> createPost(@RequestBody PostRequest request){
        return ApiResponse.<PostResponse>builder()
                .result(postService.createPost(request))
                .build();
    }

    @GetMapping("/my-posts")
    public ApiResponse<PageResponse<PostResponse>> getMyPosts(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ){
        return ApiResponse.<PageResponse<PostResponse>>builder()
                .result(postService.getMyPost(page, size))
                .build();
    }
    
}
