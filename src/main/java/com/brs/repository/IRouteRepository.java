package com.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brs.entity.Bus;
import com.brs.entity.Route;

@Repository
public interface IRouteRepository extends JpaRepository<Route,Integer>{

}
