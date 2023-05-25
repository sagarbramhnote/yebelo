package com.yebelo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yebelo.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
}
