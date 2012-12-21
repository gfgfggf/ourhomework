package com.buaa.homework;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ParkingCharge {
	public void show(ParkingManger manger){
		Map<ParkingBoy,ArrayList<ParkingPlace>> map=manger.getManger();
		Set<ParkingBoy> boySet=map.keySet();
		
		for(Iterator<ParkingBoy> iter=boySet.iterator();iter.hasNext();){
			ParkingBoy boy=iter.next();
			System.out.println("停车仔编号："+boy);
			ArrayList<ParkingPlace> parkingPlaces=map.get(boy);
			for(ParkingPlace p:parkingPlaces){
			System.out.println("           停车场编号："+p);
			System.out.println("           总车位数："+p.getMaxSize());
			System.out.println("           空位数："+p.FreeSpace());
			}
			System.out.println("此停车仔的TOTAL车位数："+boy.getTotalCars());
			System.out.println("此停车仔的TOTAL空位数："+boy.getTotalFree());
		}
		System.out.println("经理编号："+manger);
		System.out.println("         车位数："+manger.getTotalCars());
		System.out.println("         空位数："+manger.getTotalFree());
=======
public class ParkingCharge {
	public void show(){
		
		
>>>>>>> ddca9f09141d60695fe0657c57d3f9d8eec7470f
	}
}
