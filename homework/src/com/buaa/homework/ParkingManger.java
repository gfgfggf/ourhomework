package com.buaa.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingManger extends ParkingBoy{
	ArrayList<ParkingPlace> places;
<<<<<<< HEAD
	public ArrayList<ParkingPlace> getPlaces() {
		return places;
	}
	ParkingBoy boy;
	Map<ParkingBoy,ArrayList<ParkingPlace>> manger=new HashMap<ParkingBoy, ArrayList<ParkingPlace>>();
	public Map<ParkingBoy, ArrayList<ParkingPlace>> getManger() {
		return manger;
	}
=======
	ParkingBoy boy;
	Map<ParkingBoy,ArrayList<ParkingPlace>> manger=new HashMap<ParkingBoy, ArrayList<ParkingPlace>>();
>>>>>>> ddca9f09141d60695fe0657c57d3f9d8eec7470f
	public void init(ParkingBoy boy,ParkingPlace place){
		places=manger.get(boy);
		if(places==null){
			places=new ArrayList<ParkingPlace>();
			boy.add(place);
			places.add(place);
			manger.put(boy, places);
		}else{
			places.add(place);
<<<<<<< HEAD
			boy.add(place);
=======
>>>>>>> ddca9f09141d60695fe0657c57d3f9d8eec7470f
			manger.put(boy, places);
		}
	}
	
}
