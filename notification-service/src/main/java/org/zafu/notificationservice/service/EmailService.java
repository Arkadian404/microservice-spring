package org.zafu.notificationservice.service;

import feign.FeignException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zafu.notificationservice.dto.request.EmailRequest;
import org.zafu.notificationservice.dto.request.SendEmailRequest;
import org.zafu.notificationservice.dto.request.Sender;
import org.zafu.notificationservice.dto.response.EmailResponse;
import org.zafu.notificationservice.exception.AppException;
import org.zafu.notificationservice.exception.ErrorCode;
import org.zafu.notificationservice.repo.httpClient.EmailClient;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
    EmailClient emailClient;

    @Value("${notification.email.brev-apikey}")
    @NonFinal
    String apiKey;

    public EmailResponse sendEmail(SendEmailRequest request){
        EmailRequest emailRequest = EmailRequest.builder()
                .sender(Sender.builder()
                        .name("zafuog")
                        .email("phutv1990@gmail.com")
                        .build())
                .to(List.of(request.getTo()))
                .subject(request.getSubject())
                .htmlContent(request.getHtmlContent())
                .build();
        try {
            return emailClient.sendEmail(apiKey, emailRequest);
        }catch (FeignException ex){
            throw new AppException(ErrorCode.CANNOT_SEND_EMAIL);
        }
    }
}
