/**
 * Author:ANASTASIOS KARAGEORGIADIS AM.:2013030135
 */
package projectPack1;

public class Vehicle {
	/*constants*/
	public static final int NumbOfVehicles=50;//number of vehicles visiting workshop...
	
	/*------member variables------*/
	private String PlateNumber;
	private String LastNameOw;
	private String TelephNumber;
	
	/*--------------Constructors------------------------------------------------*/
	public Vehicle(){
		
	}//default constructor
	
	public Vehicle(String plateNumber, String lastNameOw, String telephNumber) {
		super();
		PlateNumber = plateNumber;
		LastNameOw = lastNameOw;
		TelephNumber = telephNumber;
	}
	//-----------------------------------------------------------------------------


   /*................Set methods.....................*/
	public void setPlateNumber(String plateNumber) {
		PlateNumber = plateNumber;
	}

	public void setLastNameOw(String lastNameOw) {
		LastNameOw = lastNameOw;
	}

	public void setTelephNumber(String telephNumber) {
		TelephNumber = telephNumber;
	}
	//....................................................
	
	/*.............Get methods.........................*/
	public String getPlateNumber() {
		return PlateNumber;
	}

	public String getLastNameOw() {
		return LastNameOw;
	}

	public String getTelephNumber() {
		return TelephNumber;
	}	
	//..................................................

	/**********Other methods****************************/
	/*print Vehicle data*/
    public void printV(Vehicle[] V, int counter,int I){
  	  /*print vehicle*/
		System.out.println("||****These are Vehicle's data:**** || ");
		for(int i=0;i<counter; i++)
		{
			if(V[i]!=null)
			{
			    if(I==1)//only at option 5 are printed
			    {
				    System.out.println("\n||->For Vehicle's data No: " +(i+1) +"||\n");
			        System.out.println("||Press number: " +i +"||");
			    }
			    System.out.println(" |Plate Number: " +V[i].getPlateNumber() +"|");
			    System.out.println(" |Owner's Last Name: " +V[i].getLastNameOw() +"|");
			    System.out.println(" |Owner's Telephone number: " +V[i].getTelephNumber() +"|");
			    System.out.println("------------------------------------------------------------\n");
			}
			else
				if(I==1)
				System.out.println(" \n|!!!These Vehicle data have been deleted or they are empty.!\n");
		}
    }
    
    /*Delete data*/
    public void deleteVeh(Vehicle[] V,int answer,int index){
    	
    	
    	V[answer]=null;//delete asking data
    	/*moving objects so overgab the apace and last position is left empty*/
    	for(int i=answer;i<index-1;i++)
    	  V[i]=V[i+1];
    	
    	  V[index-1]=null;//free last position
    	
    	}//end delete method
    
    /*print one vehicle's data*/
    public void print1V(Vehicle V){
    	  /*print vehicle*/
  		System.out.println("||****These are Vehicle's data:**** || ");
  		
  		
  			if(V!=null)
  			{
  			    
  			    System.out.println(" |Plate Number: " +V.getPlateNumber() +"|");
  			    System.out.println(" |Owner's Last Name: " +V.getLastNameOw() +"|");
  			    System.out.println(" |Owner's Telephone number: " +V.getTelephNumber() +"|");
  			    System.out.println("------------------------------------------------------------\n");
  			}
  			else
  				
  				System.out.println(" \n|!!!These Vehicle data have been deleted or they are empty.!\n");
  		}
    
 }
	

