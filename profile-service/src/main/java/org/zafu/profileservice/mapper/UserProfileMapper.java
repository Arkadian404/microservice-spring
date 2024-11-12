package org.zafu.profileservice.mapper;

import org.mapstruct.Mapper;
import org.zafu.profileservice.dto.request.UserProfileRequest;
import org.zafu.profileservice.dto.response.UserProfileResponse;
import org.zafu.profileservice.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(UserProfileRequest request);
    UserProfileResponse toUserProfilerResponse(UserProfile profile);
}
