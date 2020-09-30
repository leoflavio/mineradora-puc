package com.mina.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mina.demo.entity.Regra;

@Repository
public interface IRegraRepository extends JpaRepository<Regra, Long> {

}
