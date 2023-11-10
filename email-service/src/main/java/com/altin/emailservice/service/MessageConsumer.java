package com.altin.emailservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private final EmailService emailService;

    public MessageConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "message-topic",groupId = "altin")
    public void listener(String data){
        System.out.println(data);
        emailService.sendMessage("altin.hysa@student.cacttus.education","TaxiQera: Request for a trip", data);
    }
}
