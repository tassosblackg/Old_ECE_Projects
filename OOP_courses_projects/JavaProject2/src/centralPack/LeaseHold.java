
/**Author: ANASTASIOS KARAGEORGIADIS AM.:2013030135.....LeaseHold Class*/

package centralPack;

import readPackage.*;

public class LeaseHold extends Building {

	/*meber variables*/
	/*adress,area are inherited*/
	private float Rent;//money that are given for renting a building 
	private int YearOfRentEnd;//the year util when a building is rent 
	
	/*Contructors*/
	public LeaseHold (){
		//default constructor
	}
	public LeaseHold(String adress,float area,float rent, int yearOfRentEnd){
		super(adress,area);
		Rent=rent;
		YearOfRentEnd=yearOfRentEnd;
	}

	
	/*Getters and Setters*/
	public float getRent() {
		return Rent;
	}
	public int getYearOfRentEnd() {
		return YearOfRentEnd;
	}
	public void setRent(float rent) {
		Rent = rent;
	}
	public void setYearOfRentEnd(int yearOfRentEnd) {
		YearOfRentEnd = yearOfRentEnd;
	}
	//=====================
	
	/*****|||Other Methods|||||||***************************/
	
	/**|Insert LeaseHold data|********/
	public LeaseHold insertLh(){
		float rent;
		int year;
		ReadNcheck r=new ReadNcheck();
		LeaseHold l=new LeaseHold();
		RealEstate R=new RealEstate();
		
		//insert common RealeEstate data
		R=R.insertRlE();
		System.out.println("\n ->Insert LeaseHold Building's data....\n");
		//read extra variables data
		rent=r.readNcheckF("Rent");
		year=r.readNcheckI("YearOfRentEnd");//the year when rent is over
		
		l=new LeaseHold(R.getAddress(),R.getArea(),rent,year);
		
		return l;
	}
	
	
	
	public void printLh(){
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n ||These are LeaseHold building's data: ");
		super.printRl();//print RealEstate basic data
		
		System.out.println("  |Rent :  " +getRent()+"$");
		System.out.println("  |Year that rent stops :  " +getYearOfRentEnd());
		System.out.println("----------------------------------------------------------------------\n");
		
	}
}
