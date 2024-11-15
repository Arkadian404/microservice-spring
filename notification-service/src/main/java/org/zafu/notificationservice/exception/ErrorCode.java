package org.zafu.notificationservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(999, "Uncategorized exception", HttpStatus.INTERNAL_SERVER_ERROR),
    KEY_INVALID(1, "Key message invalid", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(14, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(16, "You have no permission", HttpStatus.FORBIDDEN),
    CANNOT_SEND_EMAIL(17, "Can't send email", HttpStatus.BAD_REQUEST);
    private final int code;
    private final String message;
    private final HttpStatus httpStatus;
}
