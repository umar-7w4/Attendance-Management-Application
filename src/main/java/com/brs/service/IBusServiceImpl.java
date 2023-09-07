package com.brs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.entity.Bus;
import com.brs.repository.IBusRepository;



@Service("IBusService")
public class IBusServiceImpl implements IBusService{
	
	@Autowired
	IBusRepository iBusRepository;

	@Override
	public Bus addBus(Bus bus) throws Exception{
		iBusRepository.saveAndFlush(bus);
		return bus;
	}

	@Override
	public Bus updateBus(Bus bus) throws Exception {
		Bus  bean = null;
		try {
			bean = iBusRepository.findById(bus.getBusId()).get();
		}
		catch(Exception e) {
			throw new Exception("Bus details not found!");
		}
		iBusRepository.saveAndFlush(bus);
		return bean;
	}

	@Override
	public Bus deleteBus(int busId)throws Exception {
		Bus  bean = null;
		try {
			bean = iBusRepository.findById(busId).get();
		}
		catch(Exception e) {
			throw new Exception("Bus details not found!");
		}
		iBusRepository.deleteById(busId);
		return bean;
	}

	@Override
	public Bus viewBus(int busId) throws Exception{
		Bus  bean = null;
		try {
			bean = iBusRepository.findById(busId).get();
		}
		catch(Exception e) {
			throw new Exception("Bus details not found!");
		}
		return bean;
	}

	@Override
	public List<Bus> viewBusByType(String busType)throws Exception {
		List<Bus> ans = new ArrayList<Bus>();
		try {
			for(Bus i: iBusRepository.findAll()) {
				if(i.getBusType().equals(busType)) {
					ans.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Bus details not found!");
		}
		return ans;
	}

	@Override
	public List<Bus> viewAllBus()throws Exception {
		return iBusRepository.findAll();
	}

}
