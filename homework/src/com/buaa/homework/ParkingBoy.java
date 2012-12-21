package com.buaa.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.buaa.exception.NoMuchSizeException;
import com.buaa.exception.ParkFullException;

public class ParkingBoy {
	ArrayList<Car> cars;
	ParkingPlace place;
	int totalCars=0;
	int i=0;
	public int getTotalCars() {
	
		return totalCars;
	}
	public int getTotalFree() {
		return totalCars-i;
	}
	ArrayList<ParkingPlace> places=new ArrayList<ParkingPlace>();
	Map<ParkingPlace,ArrayList<Car>> boy=null;
	public ParkingBoy()
	{
		
		boy=new HashMap<ParkingPlace, ArrayList<Car>>();
		
	}
	public void add(ParkingPlace place){
		places.add(place);
		totalCars+=place.getMaxSize();
		boy.put(place, new ArrayList<Car>());
	}
	public boolean isFull(){
	
		for(ParkingPlace p:places){
			this.place=p;
			
			cars=boy.get(p);
		if(cars.size()==place.getMaxSize()){
			continue;
		}
		else{
			
			return false;
		}
		}
		return true;
	}
	
	public Ticket save(Car car) 
	{	
		
		if(!isFull()){
			Ticket ticket=place.save(car);
			cars.add(car);
			boy.put(place, cars);
			i++;
			return ticket;
		}
		else
			throw new ParkFullException("全部都满了.....");
				
		}
	
	public Car get(Ticket ticket){
	
		if(cars.size()==0){
			if(places.size()==1){
				throw new NoMuchSizeException("此停车仔没有那么多停车场.....");
			}else{
				for(ParkingPlace p:places){
					if(p.FreeSpace()!=0)
						continue;
					else{
						this.place=p;
						this.cars=boy.get(p);
						return get(ticket);
					}
				}
				return null;
			}
		}else{
			Car car=place.get(ticket);
			cars.remove(car);
			i--;
			return car;
		}
		
		
	}
}
