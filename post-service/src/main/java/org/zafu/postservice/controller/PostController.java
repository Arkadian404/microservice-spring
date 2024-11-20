package org.zafu.postservice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zafu.postservice.dto.ApiResponse;
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
    public ApiResponse<List<PostResponse>> getMyPosts(){
        return ApiResponse.<List<PostResponse>>builder()
                .result(postService.getMyPost())
                .build();
    }
    
}
