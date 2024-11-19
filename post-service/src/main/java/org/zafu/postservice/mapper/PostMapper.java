package org.zafu.postservice.mapper;

import org.mapstruct.Mapper;
import org.zafu.postservice.dto.response.PostResponse;
import org.zafu.postservice.entity.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostResponse toPostResponse(Post post);

}
