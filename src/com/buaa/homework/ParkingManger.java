package com.buaa.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingManger extends ParkingBoy{
	ArrayList<ParkingPlace> places;
	public ArrayList<ParkingPlace> getPlaces() {
		return places;
	}
	ParkingBoy boy;
	Map<ParkingBoy,ArrayList<ParkingPlace>> manger=new HashMap<ParkingBoy, ArrayList<ParkingPlace>>();
	public Map<ParkingBoy, ArrayList<ParkingPlace>> getManger() {
		return manger;
	}
	public void init(ParkingBoy boy,ParkingPlace place){
		places=manger.get(boy);
		if(places==null){
			places=new ArrayList<ParkingPlace>();
			boy.add(place);
			places.add(place);
			manger.put(boy, places);
		}else{
			places.add(place);
			boy.add(place);
			manger.put(boy, places);
		}
	}
	
}
