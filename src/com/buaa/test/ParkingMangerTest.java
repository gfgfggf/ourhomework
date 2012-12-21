package com.buaa.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.buaa.homework.Car;
import com.buaa.homework.ParkingBoy;
import com.buaa.homework.ParkingManger;
import com.buaa.homework.ParkingPlace;
import com.buaa.homework.Ticket;


public class ParkingMangerTest {
	ParkingBoy boy=null;
	ParkingBoy boy2=null;
	ParkingManger manger=null;
	@Before
	public void init(){
		boy=new ParkingBoy();
		boy2=new ParkingBoy();
		boy.add(new ParkingPlace(1));
		boy2.add(new ParkingPlace(10));
		boy2.add(new ParkingPlace(1));
		manger=new ParkingManger();
		manger.add(new ParkingPlace(1));
	}
	@Test
	public void should_save_car_when_boy_has_a_parkingplace_then_totalFree_is_0(){
		boy.save(new Car());
		Assert.assertEquals(0, boy.getTotalFree());
	}
	@Test
	public void should_get_car_when_has_a_car(){
		Car car=new Car();
		Ticket ticket=boy.save(car);
		Assert.assertEquals(car, boy.get(ticket));
	}
	@Test
	public void should_save_car_when_manger_has_a_parkingplace_then_totalFree_is_0(){
		manger.save(new Car());
		Assert.assertEquals(0, manger.getTotalFree());
	}
	@Test
	public void should_get_car_when_manger_has_a_car(){
		Car car=new Car();
		Ticket ticket=manger.save(car);
		Assert.assertEquals(car, manger.get(ticket));
	}
}
