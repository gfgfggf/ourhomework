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
			//System.out.println("�ռ�����");
			throw new ParkFullException("�ռ�����");
		}else{
			return "success";
		}
	}
	public Ticket save(Car car){
		if(space()!=null)
		{
		if(place.containsValue(car)){
			throw new ExistsException("���ĳ���������");
		}else{
			Ticket ticket=new Ticket();
			place.put(ticket, car);
			capacity++;
			return ticket;
		}
		}else{
			throw new ParkFullException("�ռ�����");
		}
		
	}
	public Car get(Ticket ticket){
		if(!place.containsKey(ticket)){
			throw new NoExistsException("���ĳ��Ѿ�����������.....");
		}else{
			
			if(capacity==0){
				throw new CanNotGetCarException("������ȡ��.......");
			}else{
				Car car=place.get(ticket);
				place.remove(ticket);
				capacity--;
				return car;
			}
				
		}
	}
	
}
