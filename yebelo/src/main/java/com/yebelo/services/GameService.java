package com.yebelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yebelo.Repository.PlaceRepository;
import com.yebelo.Repository.PlayerRepository;
import com.yebelo.entity.Place;
import com.yebelo.entity.Player;

@Service
public class GameService {
   
    @Autowired
	private PlayerRepository playerRepository;
    @Autowired
    private PlaceRepository placeRepository;

    //create game service
    public void createGame() {
        this.createPlace();
        this.createHost();
        this.createPlayer();
    }

    //create host player service
    public Player createHost() {
        Player player = new Player();
        player.setName("p1");
        player.setCash(1000);
        return playerRepository.save(player);
    }
    
    //create 2nd player service
    public Player createPlayer() {
        Player player = new Player();
        player.setName("p2");
        player.setCash(1000);
        return playerRepository.save(player);
    }

    //roll dice for both player service
    public String rollDie(Long playerId) {
        Player player = playerRepository.findById(playerId).orElse(null);

        if (player == null) {
            throw new IllegalArgumentException("Invalid player");
        }
        
        long dice1 = (int) (Math.random() * 6) + 1;
        long dice2 = (int) (Math.random() * 6) + 1;
        long dice=dice1+dice2;
        
        if(playerId!=null && player.getCash()>0) {
        	Place p =placeRepository.findById(dice);
        	player.setNewPlace(p);
        	int newPlayerCash;
        	newPlayerCash=player.getCash()-p.getBuyPrice();        	
        	player.setCash(newPlayerCash); 
        	playerRepository.save(player);
            return	"Die rolled successfully";
        }
        
        else if(playerId!=null && player.getCash()<=0) {
        	return "You Lose";
        }
        
		return null;
	
    }
    
    // create  places service
    public List<Place> createPlace() {
    	List<Place> placess = (List<Place>) placeRepository.findAll();
		if (placess == null || placess.isEmpty()) {   	
    	Place place = new Place();
    	place.setName("Old Kent Road");
        place.setBuyPrice(60);
        place.setRent(30);
        
       	Place place1 = new Place();
    	place1.setName("Whitechapel Road");
        place1.setBuyPrice(60);
        place1.setRent(30); 
        
      	Place place2 = new Place();
    	place2.setName("King's Cross station");
        place2.setBuyPrice(200);
        place2.setRent(100);
        
      	Place place3 = new Place();
    	place3.setName("The Angel Islington");
        place3.setBuyPrice(100);
        place3.setRent(50);
        
      	Place place4 = new Place();
    	place4.setName("Euston Road");
        place4.setBuyPrice(100);
        place4.setRent(50);
        
      	Place place5 = new Place();
    	place5.setName("Pentonville Road");
        place5.setBuyPrice(120);
        place5.setRent(60);
        
      	Place place6 = new Place();
    	place6.setName("Pall Mall");
        place6.setBuyPrice(140);
        place6.setRent(70);
        
      	Place place7 = new Place();
    	place7.setName("Whitehall");
        place7.setBuyPrice(140);
        place7.setRent(70);
        
     	Place place8 = new Place();
    	place8.setName("Northumberland Avenue");
        place8.setBuyPrice(160);
        place8.setRent(80);
        
     	Place place9 = new Place();
    	place9.setName("Marylebone station");
        place9.setBuyPrice(200);
        place9.setRent(100);
        
        Place place10 = new Place();
    	place10.setName("Marylebone stop");
        place10.setBuyPrice(150);
        place10.setRent(75);
        
        Place place11 = new Place();
    	place11.setName("Southhumberland Avenue");
        place11.setBuyPrice(160);
        place11.setRent(80);
        
        placess.add(place);
        placess.add(place1);
        placess.add(place2);
        placess.add(place3);
        placess.add(place4);
        placess.add(place5);
        placess.add(place6);
        placess.add(place7);
        placess.add(place8);
        placess.add(place9);
        placess.add(place10);
        placess.add(place11);
        
        return placeRepository.saveAll(placess);
		}
		else {
			return null;
		}
    }
}
