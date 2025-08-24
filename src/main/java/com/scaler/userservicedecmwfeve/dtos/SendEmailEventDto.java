package com.scaler.userservicedecmwfeve.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SendEmailEventDto {
    private String to;
    private String from;
    private String subject;
    private String body;
}
