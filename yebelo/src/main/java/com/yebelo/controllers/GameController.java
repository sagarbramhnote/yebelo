package com.yebelo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import com.yebelo.services.GameService;

@RestController
public class GameController {
	
	@Autowired
    private GameService gameService;	

	// create game controller
    @PostMapping("/create-game")
    public ResponseEntity<String> createGame() {
        this.gameService.createGame();
        return ResponseEntity.ok("Game Created Successfully");
    }

    // roll dice for p1
    @PostMapping("/roll-die/p1")
    public ResponseEntity<String> rollDieP1() {
    	long p1=1;
       String p= gameService.rollDie(p1);
        return ResponseEntity.ok(p);
    }
    
    // roll dice for p2
    @PostMapping("/roll-die/p2")
    public ResponseEntity<String> rollDieP2() {
    	long p2=2;
    	String p= gameService.rollDie(p2);
        return ResponseEntity.ok(p);
    }
    
}
