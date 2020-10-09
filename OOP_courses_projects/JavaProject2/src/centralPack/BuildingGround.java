
/**Author: ANASTASIOS KARAGEORGIADIS AM.:2013030135.....BuildingGround Class*/

package centralPack;

import readPackage.ReadNcheck;

public class BuildingGround extends RealEstate {

	/*member variables*/
	/*adress,area are inherited*/
	private float BuildingFactor;
	
	/*Constructors*/
	public BuildingGround(){
		//default constructor
	}
	public BuildingGround(String adress,float area,float buildingFactor){
		super(adress,area);
		BuildingFactor=buildingFactor;
	}
	
	
	//*********Getters and Setters***************************//
	public float getBuildingFactor() {
		return BuildingFactor;
	}
	public void setBuildingFactor(float buildingFactor) {
		BuildingFactor = buildingFactor;
	}
	//====================================================
	
	/******||||Other Methods|||||**********************/
	
	
	/**|Insert BuildingGround data|*****/
	public BuildingGround insertBg(){
		float bFactor;
		ReadNcheck r=new ReadNcheck();
		BuildingGround B=new BuildingGround();
		RealEstate R=new RealEstate();
		
		//insert common RealEstate data
		R=R.insertRlE();
		System.out.println("\n ->Insert BuildingGround's data....\n");
		//read extra variables data
		bFactor=r.readNcheckF("BuildingFactor");
		
		B=new BuildingGround(R.getAddress(),R.getArea() ,bFactor);
		
		return B;
	}
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	/**--------------|Print BuildingGround data|-----------------------------*******/
	public void printBlG(){
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n ||These are Building Ground's data : ");
		super.printRl();//call method to print RealEstate basic data
		System.out.println("  |Building Factor : " +getBuildingFactor());
		System.out.println("---------------------------------------------------------------------------\n");
	}
	//-----------------------------------------------------------------------------------------
}
