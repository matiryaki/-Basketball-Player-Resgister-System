package com.producter.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.producter.enums.Position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDto {

	@NotBlank
	private String name;
	@NotBlank
	private String surname;
	@NotNull
	private Position position;
	
	
}
