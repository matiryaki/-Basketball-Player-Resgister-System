package com.producter.resolver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.producter.dto.PlayerDto;
import com.producter.model.Player;
import com.producter.service.PlayerService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
@Validated
public class Mutation implements GraphQLMutationResolver{

	@Autowired
	private  PlayerService playerService;
	
	public Player addPlayer(PlayerDto playerDto) {
		
		return playerService.savePlayer(playerDto);
	}
	
	public Player deletePlayer(Long id) {
		
		return playerService.deletePlayer(id);
	}
	
	
}
