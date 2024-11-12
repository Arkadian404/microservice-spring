package org.zafu.profileservice.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zafu.profileservice.dto.request.UserProfileRequest;
import org.zafu.profileservice.dto.response.UserProfileResponse;
import org.zafu.profileservice.entity.UserProfile;
import org.zafu.profileservice.mapper.UserProfileMapper;
import org.zafu.profileservice.repo.UserProfileRepo;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RequiredArgsConstructor
public class UserProfileService {
    UserProfileRepo userProfileRepo;
    UserProfileMapper mapper;

    public UserProfileResponse createProfile(UserProfileRequest request){
        UserProfile userProfile = mapper.toUserProfile(request);
        userProfile = userProfileRepo.save(userProfile);
        return mapper.toUserProfilerResponse(userProfile);
    }

    public UserProfileResponse getProfile(String id){
        UserProfile userProfile = userProfileRepo.findById(id).orElseThrow(()-> new RuntimeException("Profile not found!"));
        return mapper.toUserProfilerResponse(userProfile);
    }

    public List<UserProfileResponse> getAllProfiles(){
        return userProfileRepo.findAll()
                .stream()
                .map(mapper::toUserProfilerResponse)
                .toList();
    }
}
