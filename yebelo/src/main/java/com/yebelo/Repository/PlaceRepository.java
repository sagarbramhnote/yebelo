package com.yebelo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yebelo.entity.Place;


@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
	
	Place findById(long place);

}
