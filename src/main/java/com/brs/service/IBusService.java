package com.brs.service;

import java.util.List;

import com.brs.entity.Bus;

public interface IBusService {
	
	public Bus addBus(Bus bus) throws Exception;
	public Bus updateBus(Bus bus) throws Exception;
	public Bus deleteBus(int busId)throws Exception;
	public Bus viewBus(int busId) throws Exception;
	public List<Bus> viewBusByType(String busType)throws Exception;
	public List<Bus> viewAllBus()throws Exception;
	

}
