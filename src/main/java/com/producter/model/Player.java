package com.producter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.producter.enums.Position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 100, name = "name")
    private String name;
	@Column(length = 100, name = "surname")
    private String surname;
	@Enumerated(EnumType.STRING)
	@Column(name = "position")
	private Position position;
}