package com.buaa.homework;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlaceCompany {
	List company=null;
	int CompanySize;
	public ParkingPlaceCompany(int CompanySize){
		this.CompanySize=CompanySize;
		company=new ArrayList(CompanySize);
	}
	public void addParkingPlace(ParkingPlace parkingPlace){
		company.add(parkingPlace);
	}
	
	
}
