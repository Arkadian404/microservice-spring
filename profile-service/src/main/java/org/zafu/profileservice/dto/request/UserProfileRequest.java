package org.zafu.profileservice.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileRequest {
    Long userId;
    String username;
    String firstname;
    String lastname;
    LocalDate dob;
    String city;
}
