package com.yebelo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int cash;
    @OneToOne
    private Place newPlace;

	public Player(Long id, String name, int cash, Place newPlace) {
		super();
		this.id = id;
		this.name = name;
		this.cash = cash;
		this.newPlace = newPlace;
	}

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public Place getNewPlace() {
		return newPlace;
	}

	public void setNewPlace(Place newPlace) {
		this.newPlace = newPlace;
	}

}
