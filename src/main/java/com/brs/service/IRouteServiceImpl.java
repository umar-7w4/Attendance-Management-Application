package com.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.entity.Bus;
import com.brs.entity.Reservation;
import com.brs.entity.Route;
import com.brs.repository.IRouteRepository;

@Service("IRouteService")
public class IRouteServiceImpl implements IRouteService {
	
	@Autowired
	IRouteRepository iRouteRepository;

	@Override
	public Route addRoute(Route route) throws Exception {
		iRouteRepository.saveAndFlush(route);
		return route;
	}

	@Override
	public Route updateRoute(Route route) throws Exception {
		Route  bean = null;
		try {
			bean = iRouteRepository.findById(route.getRouteId()).get();
		}
		catch(Exception e) {
			throw new Exception("Route details not found!");
		}
		iRouteRepository.saveAndFlush(route);
		return bean;
	}

	@Override
	public Route deleteRoute(int routeId) throws Exception {
		Route  bean = null;
		try {
			bean = iRouteRepository.findById(routeId).get();
		}
		catch(Exception e) {
			throw new Exception("Route details not found!");
		}
		iRouteRepository.deleteById(routeId);
		return bean;
	}

	@Override
	public Route viewRoute(int routeId) throws Exception {
		Route  bean = null;
		try {
			bean = iRouteRepository.findById(routeId).get();
		}
		catch(Exception e) {
			throw new Exception("Route details not found!");
		}
		return bean;
	}

	@Override
	public List<Route> viewAllRoutes() throws Exception {
		return iRouteRepository.findAll();
	}
	
	

}
