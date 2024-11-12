package org.zafu.profileservice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.zafu.profileservice.dto.request.UserProfileRequest;
import org.zafu.profileservice.dto.response.UserProfileResponse;
import org.zafu.profileservice.service.UserProfileService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/users")
    public UserProfileResponse createProfile(@RequestBody UserProfileRequest request){
        return userProfileService.createProfile(request);
    }

    @GetMapping("/users/{id}")
    public UserProfileResponse getProfile(@PathVariable String id){
        return userProfileService.getProfile(id);
    }
}
