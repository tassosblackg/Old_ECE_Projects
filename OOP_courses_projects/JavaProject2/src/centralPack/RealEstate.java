
/**Author: ANASTASIOS KARAGEORGIADIS AM.:2013030135.....RealEstate Class*/

package centralPack;

import readPackage.ReadNcheck;

public class RealEstate extends Item{
      /*member variables */
	/*adress is inherited from Item*/
	protected float Area;
	protected String key;
	
	//private BuildingGround Bg = new BuildingGround();
	//private Building Bl=new Building();
	
	/*--------------Contructors-------------------*/
	public RealEstate(){
		//default constructor
		
	}
	/**key set for search***/
	public RealEstate(String k){
		key=k;
	}
	
	public RealEstate(String address,float area){
		super(address);
		Area=area;
		key=address;
	}
	//--------------------------------------------
	
	/***Getters And Setters*******/
	
	
	public float getArea() {
		return Area;
	}

	public void setArea(float area) {
		Area = area;
	}
	//**********************************

	/****|||||Other Methods||||||****************/
	
	/*------------|BASIC INHERITED METHODS from Item|---------------*/
	
	public boolean equals(Item a){
		if(key.equals((String)a.key()))
			return true;
		else
			return false;
	}
	
	public boolean less(Item a){
		if(key.compareTo((String)a.key())<0)
			return true;
		else
			return false;
		
	}
	
	public Object key(){
		return key;
	}
	//--------------------------------------------------------------------------------------
	
	
	
	/**|Insert RealEstate basic data|****/
	public RealEstate insertRlE(){
		String address;
		float area;
		ReadNcheck r=new ReadNcheck();
		RealEstate RlE=new RealEstate();
		System.out.println(".......................................................");
		System.out.println("\n *Insert RealEstate data....");
		//insert address
		address=r.readNcheckS("Address");
		//insert area
		area=r.readNcheckF("Area in squarely meters");
		RlE=new RealEstate(address,area);
		
		return RlE;
		
	}
	/********|Print RealEstate Basic data|*********/
	public void printRl()
	{
		
		System.out.println(" ||These are RealEstate basic data.......");
		System.out.println("  |Adress:" +Address);
		System.out.println("  |Area:" +Area+" m^2" +" (squarely meters)");
		System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
	}
	//--------------------------------------------------------------------------------------------------------
	
}
