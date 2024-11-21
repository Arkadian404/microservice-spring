package org.zafu.postservice.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponse {
    String id;
    String userId;
    String username;
    String content;
    String created;
    Instant createdDate;
    Instant modifiedDate;
}
