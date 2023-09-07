package com.cg.dca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.brs.entity.Bus;
import com.brs.entity.Route;


@SpringBootTest
class BusReservationSystemApplicationTests extends AbstractTest{

	@Test
	void contextLoads() {
	}

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getBusById() throws Exception {
		String uri = "/brs-bus/viewBus/1";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Bus bus = super.mapFromJson(content, Bus.class);
		assertEquals(1, bus.getBusId());
		assertEquals("Indira", bus.getBusName());

	}

	@Test
	public void getBuses() throws Exception {
		String uri = "/brs-bus/viewAllBus";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();

		Bus buses[] = super.mapFromJson(content, Bus[].class);
		assertEquals(1, buses[0].getBusId());

	}

	@Test
	public void postFlat() throws Exception {
		String uri = "/mydoctorapp-appointment/createappointment";
		Bus bus = new Bus();
		
		bus.setArrivalTime(LocalDateTime.of(2023, 1, 4, 5, 12));
		bus.setAvaiableSeats(34);
		bus.setBusName("Morning star");
		bus.setBusType("Volvo multi axel");
		bus.setDepartureTime(LocalDateTime.of(2023, 1, 4, 12, 12));
		bus.setDriverName("Rahul");
		bus.setRouteFrom("Mumbai");
		bus.setRouteTo("Pune");
		bus.setSeats(60);
		
		Route route  = new Route();
		
		route.setDistance(220);
		route.setRouteFrom("Mumbai");
		route.setRouteTo("Pune");
		
		bus.setRoute(route);
		

		String inputJson = super.mapToJson(bus);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Bus buses[] = super.mapFromJson(content, Bus[].class);

		assertEquals(1, buses[buses.length - 1].getBusId());

	}

}
