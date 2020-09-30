package com.mina.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mina.demo.entity.SensorSismo;

@Repository
public interface ISensorSismoRepository extends JpaRepository<SensorSismo, Long> {
	
	List<SensorSismo> findFirst2ByOrderByDataDesc();
}
