package com.twiliosms.twiliosms.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsRequest {
	@NotBlank
	private String phoneNumber;
	@NotBlank
	private String message;

}
