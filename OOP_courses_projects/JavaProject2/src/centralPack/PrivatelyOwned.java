
/**Author: ANASTASIOS KARAGEORGIADIS AM.:2013030135.....PrivatelyOwned Class*/

package centralPack;

import readPackage.*;

public class PrivatelyOwned extends Building{
	/*member variables*/
	/*adress,area are inherited*/
	private float ObjectiveValue;
	
	/*Contructors*/
	public PrivatelyOwned(){
		//default constructor
	}
	public PrivatelyOwned(String adress, float area,float objectiveV){
		super(adress,area);
		ObjectiveValue=objectiveV;
	}
	
	
	//*******Getters and Settrs*************************//
	public float getObjectiveValue() {
		return ObjectiveValue;
	}
	public void setObjectiveValue(float objectiveValue) {
		ObjectiveValue = objectiveValue;
	}
	//======================================================
	
	/**********||||Other Methods|||||||||||||*****/
	
	/**|Insert PrivatelyOwned data|**************/
	public PrivatelyOwned insertPO(){
		float Ovalue;
		ReadNcheck r=new ReadNcheck();
		PrivatelyOwned p=new PrivatelyOwned();
		RealEstate R=new RealEstate();
		
		//insert common RealEstate data
		R=R.insertRlE();
		System.out.println("\n *Insert PrivatelyOwned Building's data...\n");
		//read extra variables data
		Ovalue=r.readNcheckF("ObjectiveValue");
		
		p=new PrivatelyOwned(R.getAddress(),R.getArea(),Ovalue);
		
		return p;
	}
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	/****----------------|Prints PrivatelyOwned data|-------------------------------------******/
	public void printPO(){
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n ||These are PrivatelyOwned building's data: ");
		super.printRl();//call method to print basic RealEstate data
		
		System.out.println("  |Objective Value:  " +getObjectiveValue()+"$");
		System.out.println("----------------------------------------------------------------------\n");
	}
	//------------------------------------------------------------------------------------

}
