package org.zafu.profileservice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.zafu.profileservice.dto.ApiResponse;
import org.zafu.profileservice.dto.request.UserProfileRequest;
import org.zafu.profileservice.dto.response.UserProfileResponse;
import org.zafu.profileservice.service.UserProfileService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternalUserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/internal/users")
    public ApiResponse<UserProfileResponse> createProfile(@RequestBody UserProfileRequest request){
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.createProfile(request))
                .build();
    }

    @GetMapping("/internal/users/{userId}")
    public ApiResponse<UserProfileResponse> getProfile(@PathVariable Long userId){
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.getUserProfileByUserId(userId))
                .build();
    }
}
