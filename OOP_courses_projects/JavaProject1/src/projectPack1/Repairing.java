/**
 * Author:ANASTASIOS KARAGEORGIADIS AM.:2013030135
 */
package projectPack1;

import java.util.Date;


public class Repairing {
	
	
	/*constants*/
	public static final int NumbOfRepairings=50;//number of repairings can insert....
	public static final int NumbOfW=5;//number of WorkManShips for each Repairing object
	/***member variables***/
	private Vehicle[] Veh=new Vehicle[1];//every Repairing is done in one car/Vehicle
	private Date Date;
	private WorkManShip[] Works=new WorkManShip[NumbOfW];
	private Employee[] Empl=new Employee[NumbOfW];//number of employees is equal to number of WorkManShips..
	private float TotalCost;//total cost of repairings
	
	
	/*------------Constructors------------------*/
    public Repairing() {
    	
	}//default constructor
    /*constructor 1*/
    public Repairing(WorkManShip w,Employee e,int i){
    	/*set objects*/
		
		Works[i]= new WorkManShip();
		Empl[i]=new Employee();
		
		
    	Works[i]=w;
    	Empl[i]=e;
    	
    	Veh[0]=new Vehicle();
    	Date =null;
    }
    /*constructor 2*/
	/*public Repairing(Vehicle vehicles, Date date) {
		Veh[0]=new Vehicle();
		Veh[0] = vehicles;
		Date = date;
		
		
		
	}*/
    //-------------------------------------------------

	/*..............Set methods...........................*/
	public void setVeh(Vehicle vehicles) {
		Veh[0] = vehicles;
	}


	public void setDate(Date date) {
		Date = date;
	}


	public void setWorks(WorkManShip[] works) {
		Works = works;
	}
		
	public void setEmpl(Employee[] empl) {
		Empl = empl;
	}
	
	public void setTotalCost(float totalCost) {
		TotalCost = totalCost;
	}
	//************************************************************
	/*..............Get methods................................*/
	public Vehicle[] getVeh() {
		return Veh;
	}


	public Date getDate() {
		return Date;
	}


	public WorkManShip[] getWorks() {
		return Works;
	}
	public Employee[] getEmpl() {
		return Empl;
	}
	
	public float getTotalCost() {
		return TotalCost;
	}
    //..............................................................
 
	/*******Other methods***********************/
	public void printRepairing(Repairing[] R, int counter){
		
		  	  /*print vehicle*/
				System.out.println("||****These are Repairing's data: *****||");
				for(int i=0;i<counter; i++)
				{
					if(R[i]!=null)
					{
					   
					    System.out.println(" \n|Repairing Vehicle's  data: "  +"|\n");
					    /*call print Vehicle data*/
					    Veh[0].printV(R[i].Veh, 1,0);
					    System.out.println(" \n|Repairing's date: " +R[i].getDate() +"|\n");
					    System.out.println(" \n|Repairing's WorkManShip data: |\n" );
					    /*call print WorkManShip method*/
					    Works[0].printWMS(R[i].Works,NumbOfW,0);
					    System.out.println(" \n|Repairing's Employee data: "  +"|\n");
					    /*call print Employee method*/
					    Empl[0].printE(R[i].Empl,NumbOfW,0);
					    System.out.println(" \n|Repairing's totalCost: " +R[i].getTotalCost());
					}
					else
						System.out.println(" \n|!!!These Repairing data have been deleted or they are empty.!\n");
				}
		   
	}
	/*Delete data*/
    public void deleteRepair(Repairing[] R,int answer,int index){
    	
    	
    	R[answer]=null;//delete asking data
    	/*moving objects so overgab the apace and last position is left empty*/
    	for(int i=answer;i<index-1;i++)
    	  R[i]=R[i+1];
    	
    	 R[index-1]=null;//free last position
    	
    	}//end delete method
	/*********find methods********/
    public void findPlateN(Repairing[] R,String plN,int index){
    	boolean found=false;
    	for(int i=0; i<index;i++)
    	{
    		if(R[i].Veh[0].getPlateNumber().equals(plN))
    		{
    			found=true;
    			System.out.println("Repairing found!\n");
    			/*print data*/
    			print1Repairing(R[i]);
    		}
    		else
    			if((i>=index-1)&&(found==false))
    			System.out.println("Repairing data not found!");
    	}
    		
    }
    public void findDateRage(Repairing[] R,Date date1, Date date2,int index){
    	boolean found=false;
    	
    	for(int i=0; i<index;i++)
    	{
    		if( (R[i].getDate().compareTo(date1)>=0)&&(R[i].getDate().compareTo(date2)<=0))
    		{
    			found=true;
    			System.out.println("|Repairing's data found!\n");
    			/*print data*/
    			print1Repairing(R[i]);
    		}
    		if((i>=index-1)&&(found==false))
    			System.out.println("Repairing's data that asked, have found!");
    	}
    	
    }
    
    public void findCost(Repairing[] R, float cost,int index){
    	boolean found=false;
    	for(int i=0; i<index;i++)
    	{
    		if(R[i].getTotalCost()>cost)
    		{
    			found=true;
    			System.out.println("Repairings data found and now are printing...\n");
    			/*print data*/
    			print1Repairing(R[i]);
    			
    			
    		}
    		if((i>=index-1)&&(found==false))
    			System.out.println(" |!!!Repairing's data that asked haven't found!\n");
    	}
    }
    public void print1Repairing(Repairing R){
		
	  	  /*print vehicle*/
			System.out.println("||****These are Repairing's data: *****||");
			
				if(R!=null)
				{
				   
				    System.out.println(" \n|Repairing Vehicle's  data: "  +"|\n");
				    /*call print Vehicle data*/
				    Veh[0].printV(R.Veh, 1,0);
				    System.out.println(" \n|Repairing's date: " +R.getDate() +"|\n");
				    System.out.println(" \n|Repairing's WorkManShip data: |\n" );
				    /*call print WorkManShip method*/
				    Works[0].printWMS(R.Works,NumbOfW,0);
				    System.out.println(" \n|Repairing's Employee data: "  +"|\n");
				    /*call print Employee method*/
				    Empl[0].printE(R.Empl,NumbOfW,0);
				    System.out.println(" \n|Repairing's totalCost: " +R.getTotalCost());
				}
				else
					System.out.println(" \n|!!!These Repairing data have been deleted or they are empty.!\n");
			}
	   
}

