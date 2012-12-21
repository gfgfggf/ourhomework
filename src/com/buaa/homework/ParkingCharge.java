package com.buaa.homework;

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
			System.out.println("ͣ���б�ţ�"+boy);
			ArrayList<ParkingPlace> parkingPlaces=map.get(boy);
			for(ParkingPlace p:parkingPlaces){
			System.out.println("           ͣ������ţ�"+p);
			System.out.println("           �ܳ�λ����"+p.getMaxSize());
			System.out.println("           ��λ����"+p.FreeSpace());
			}
			System.out.println("��ͣ���е�TOTAL��λ����"+boy.getTotalCars());
			System.out.println("��ͣ���е�TOTAL��λ����"+boy.getTotalFree());
		}
		System.out.println("�����ţ�"+manger);
		System.out.println("         ��λ����"+manger.getTotalCars());
		System.out.println("         ��λ����"+manger.getTotalFree());
	}
}
