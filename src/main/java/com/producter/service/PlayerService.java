package com.producter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.producter.dto.PlayerDto;
import com.producter.exception.PlayerNotFoundException;
import com.producter.exception.OverMaximumPlayerCapacityException;
import com.producter.model.Player;
import com.producter.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService {

	private final PlayerRepository playerRepository;
	
	public static final int MAX_PLAYER_CAPACITY = 12;
	
	public Player savePlayer(PlayerDto playerDto) {
		
		if (findAllPlayers().size() < MAX_PLAYER_CAPACITY) {
			return playerRepository.save(dtoToEntity(playerDto));
			
		}else {
			throw new OverMaximumPlayerCapacityException("Over maximum player capacity!");
		}
		
	}
	
    public Player deletePlayer(Long id) {
		
		Player player = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player not found", id));
		playerRepository.delete(player);
		return player;
	}
	
	private Player dtoToEntity(PlayerDto playerDto) {
		Player player = new Player();
		player.setName(playerDto.getName());
		player.setSurname(playerDto.getSurname());
		player.setPosition(playerDto.getPosition());
		return player;
	}
	
	public List<Player> findAllPlayers(){
		return playerRepository.findAll();
	}
}
