package org.zafu.notificationservice.controller;

import event.dto.NotificationEvent;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.zafu.notificationservice.dto.request.Recipient;
import org.zafu.notificationservice.dto.request.SendEmailRequest;
import org.zafu.notificationservice.service.EmailService;

@Component
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class NotificationController {
    EmailService emailService;


    @KafkaListener(topics = "notification-delivery")
    public void listenNotificationDelivery(NotificationEvent event){
        log.info("Message received {}", event);
        emailService.sendEmail(SendEmailRequest.builder()
                        .to(Recipient.builder()
                                .email(event.getRecipient())
                                .name(event.getBody().replace("Hello, ", ""))
                                .build())
                        .subject(event.getSubject())
                        .htmlContent(event.getBody())
                .build());
    }
}
