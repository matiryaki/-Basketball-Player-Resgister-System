package com.producter.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.producter.model.Player;
import com.producter.service.PlayerService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver{

	@Autowired
	private  PlayerService playerService;
	
	public List<Player> getAllPlayers(){
		return playerService.findAllPlayers();
	}
}
