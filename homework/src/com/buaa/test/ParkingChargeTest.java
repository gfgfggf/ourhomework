package com.buaa.test;

import org.junit.Before;
import org.junit.Test;

import com.buaa.homework.ParkingBoy;
import com.buaa.homework.ParkingCharge;
import com.buaa.homework.ParkingManger;
import com.buaa.homework.ParkingPlace;

public class ParkingChargeTest {
	ParkingCharge charge=null;
	ParkingManger manger=null;
	@Before
	public void init(){
		charge=new ParkingCharge();
		manger=new ParkingManger();
		manger.add(new ParkingPlace(10));
		manger.add(new ParkingPlace(20));
		ParkingBoy boy=new ParkingBoy();
		manger.init(boy, new ParkingPlace(10));
		manger.init(boy, new ParkingPlace(20));
		manger.init(new ParkingBoy(), new ParkingPlace(10));
	}
	@Test
	public void showTest(){
		charge.show(manger);
	}
}
