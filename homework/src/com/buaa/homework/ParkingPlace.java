package com.buaa.homework;

import java.util.HashMap;
import java.util.Map;

import com.buaa.exception.ExistsException;
import com.buaa.exception.NoExistsException;
import com.buaa.exception.ParkFullException;

public class ParkingPlace {
	int MaxSize;
	Map<Ticket,Car> place;
	int capacity=0;
	public int getMaxSize() {
		return MaxSize;
	}
	public ParkingPlace(int MaxSize){
		this.MaxSize=MaxSize;
		place=new HashMap<Ticket,Car>(MaxSize);
	}
	public int FreeSpace(){
		return (MaxSize-capacity);
	}
	
	public int getCapacity() {
		return capacity;
	}

	public String space(){
		if(capacity==MaxSize){
			//System.out.println("空间满了");
			throw new ParkFullException("空间满了");
		}else{
			return "success";
		}
	}
	public Ticket save(Car car){
		if(space()!=null)
		{
		if(place.containsValue(car)){
			throw new ExistsException("您的车已在里面");
		}else{
			Ticket ticket=new Ticket();
			place.put(ticket, car);
			capacity++;
			return ticket;
		}
		}else{
			throw new ParkFullException("空间满了");
		}
		
	}
	public Car get(Ticket ticket){
		if(!place.containsKey(ticket)){
			throw new NoExistsException("您的车已经不在这里面.....");
		}else{
			
			if(capacity==0){
				throw new CanNotGetCarException("您不能取车.......");
			}else{
				Car car=place.get(ticket);
				place.remove(ticket);
				capacity--;
				return car;
			}
				
		}
	}
	
}
