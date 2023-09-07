package com.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brs.entity.Bus;

@Repository
public interface IBusRepository extends JpaRepository<Bus,Integer>{

}
