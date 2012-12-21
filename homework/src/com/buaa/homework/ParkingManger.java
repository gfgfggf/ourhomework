package com.buaa.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingManger extends ParkingBoy{
	ArrayList<ParkingPlace> places;
	ParkingBoy boy;
	Map<ParkingBoy,ArrayList<ParkingPlace>> manger=new HashMap<ParkingBoy, ArrayList<ParkingPlace>>();
	public void init(ParkingBoy boy,ParkingPlace place){
		places=manger.get(boy);
		if(places==null){
			places=new ArrayList<ParkingPlace>();
			boy.add(place);
			places.add(place);
			manger.put(boy, places);
		}else{
			places.add(place);
			manger.put(boy, places);
		}
	}
	
}
