package com.brs.service;

import java.util.List;

import com.brs.entity.Bus;
import com.brs.entity.Route;

public interface IRouteService {
	
	public Route addRoute(Route route) throws Exception;
	public Route updateRoute(Route route) throws Exception;
	public Route deleteRoute(int routeId)throws Exception;
	public Route viewRoute(int routeId) throws Exception;
	public List<Route> viewAllRoutes()throws Exception;

}
