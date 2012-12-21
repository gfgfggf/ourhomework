package com.buaa.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.buaa.exception.NoExistsException;
import com.buaa.exception.NoMuchSizeException;
import com.buaa.exception.ParkFullException;
import com.buaa.homework.Car;
import com.buaa.homework.ParkingBoy;
import com.buaa.homework.ParkingPlace;
import com.buaa.homework.Ticket;

public class ParkingBoyTest {
	ParkingBoy boy=null;
	ParkingPlace place=null;
	ParkingPlace place2=null;
	@Before
	public void init(){
		 boy=new ParkingBoy();
		 place=new ParkingPlace(1);
		 place2=new ParkingPlace(1);
		boy.add(place);
		boy.add(place2);
	}
	
	@Test
	public void should_save_one_car_when_there_has_two_parkingplace_then_free_place_is_1(){
		boy.save(new Car());
		Assert.assertEquals(1, boy.getTotalFree());
	}
	@Test
	public void should_get_one_car_whene_there_has_two_parkingplace_then_free_place_is_2(){
		Ticket ticket=boy.save(new Car());
		boy.get(ticket);
		Assert.assertEquals(2, boy.getTotalFree());
	}
	@Test(expected=ParkFullException.class)
	public void should_save_cars_whene_full_then_exception(){
		boy.save(new Car());
		boy.save(new Car());
		boy.save(new Car());
	}
	@Test(expected=NoExistsException.class)
	public void should_get_cars_when_empty_then_exception(){
		Ticket one=boy.save(new Car());
		Ticket two=boy.save(new Car());
		boy.get(one);
		boy.get(two);
		boy.get(one);
	}
	@Test(expected=NoMuchSizeException.class)
	public void should_has_one_parkingplace_when_get_much_car_then_exception(){
		boy=new ParkingBoy();
		boy.add(new ParkingPlace(1));
		Ticket ticket=boy.save(new Car());
		boy.get(ticket);
		boy.get(new Ticket());
	}
}
