package com.services.emailservice.entities;

import java.time.LocalDateTime;

import com.services.emailservice.dtos.EmailDto;
import com.services.emailservice.enums.EmailStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "emails")
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mailFrom;
	private String mailTo;
	private String mailSubject;
	private String mailText;
	private LocalDateTime sendDateEmail;
	@Enumerated(EnumType.STRING)
	private EmailStatus status = EmailStatus.SENT;
	
	public Email(EmailDto emailDto) {
		this.mailFrom= emailDto.mailFrom();
		this.mailTo= emailDto.mailTo();
		this.mailSubject = emailDto.mailSubject();
		this.mailText = emailDto.mailText();
	}
}