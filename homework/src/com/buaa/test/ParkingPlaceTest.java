package com.buaa.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.buaa.exception.ExistsException;
import com.buaa.exception.NoExistsException;
import com.buaa.exception.ParkFullException;
import com.buaa.homework.Car;
import com.buaa.homework.ParkingPlace;
import com.buaa.homework.Ticket;

public class ParkingPlaceTest {
	ParkingPlace place=null;
	@Before
	public void init(){
		place=new ParkingPlace(2);
	}
	@Test
	public void should_save_car_then_capacity_increase(){
		Car car=new Car();
		place.save(car);
		int i=place.getCapacity();
		Assert.assertEquals(1, i);
	}
	@Test
	public void should_get_car_then_capacity_decrease(){
		Car car=new Car();
		Ticket ticket=place.save(car);
		place.get(ticket);
		int i=place.getCapacity();
		Assert.assertEquals(0, i);
	}
	@Test(expected=ExistsException.class)
	public void should_save_car_when_the_car_has_been_exist_then_exception(){
		Car car=new Car();
		Ticket ticket=place.save(car);
		place.save(car);
		
	}
	@Test
	public void should_save_car_when_the_place_is_not_full_then_save(){
		Car car=new Car();
		Ticket ticket=place.save(car);
	}
	@Test(expected=ParkFullException.class)
	public void should_save_car_when_the_place_is_full_then_exception(){
		Car car=new Car();
		Ticket ticket=place.save(car);
		Car car2=new Car();
		Ticket ticket2=place.save(car2);
		Car car3=new Car();
		Ticket ticket3=place.save(car3);
	}
	@Test
	public void should_get_car_when_the_car_is_exist_then_get(){
		Car car=new Car();
		Ticket ticket=place.save(car);
		Car car2=place.get(ticket);
		Assert.assertEquals(car, car2);
	}
	@Test(expected=NoExistsException.class)
	public void shoulde_get_car_when_the_car_has_been_got_then_exception(){
		Car car=new Car();
		Ticket ticket=place.save(car);;
		car=place.get(ticket);
		car=place.get(ticket);
	}
}
