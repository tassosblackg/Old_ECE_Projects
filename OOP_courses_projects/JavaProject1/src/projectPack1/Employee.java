/**
 * Author:ANASTASIOS KARAGEORGIADIS AM.:2013030135
 */
package projectPack1;



public class Employee {
   /*constant*/    
   private static final int Code = 201400;
   public static final int NumbOfEmployees=20;//number of employees working at workshop...
  
   /*member variables*/
   private int SerialCode;
   private String LastName;
   private float ChargePerHour;
   
   /*objects*/
   

  /*----------Constructors-------------------------------*/
   public Employee(){
	   
   }//default constructor
   
   public Employee(int i,String lastName, float chargePerHour) {
	
	SerialCode= Code +i;
	LastName = lastName;
	ChargePerHour = chargePerHour;
	
   }
/*-----------------------------------------------------------*/

   
  /*.........Set methods...................*/
 public void setSerialCode(int serialCode) {
	SerialCode = serialCode;
 }

 public void setLastName(String lastName) {
	LastName = lastName;
 }

 public void setChargePerHour(float chargePerHour) {
	ChargePerHour = chargePerHour;
 }
/*................................................................*/   

 /*...........Get methods..............*/
 public int getSerialCode() {
		return SerialCode;
	}



	public String getLastName() {
		return LastName;
	}



	public float getChargePerHour() {
		return ChargePerHour;
	}
/*......................................................*/

/*~~~~~~~~~~~~~Other methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  /*print Employee data*/	
  public void printE(Employee[] E, int counter,int I){
	  /*print employee*/
		System.out.println("||****These are Employee's data: ****||");
		for(int i=0;i<counter; i++)
		{
			if(E[i]!=null)
			{
			   if(I==1)//only at option 5 are printed
			   {
				   System.out.println("\n||->For Employee's data No: " +(i+1) +"||\n");
			       System.out.println("||Press number: " +i +"||");
			   }
			    System.out.println(" |Serial Code: " +E[i].getSerialCode() +"|");
			    System.out.println(" |Last Name: " +E[i].getLastName() +"|");
			    System.out.println(" |Charge Per Hour: " +E[i].getChargePerHour() +"|");
			    System.out.println("------------------------------------------------------------\n");
			}
			else
				if(I==1)
				System.out.println(" \n|!!!These Employee data have been deleted or they are empty.!\n");
		}
  }//-------------------------------------------------
  
  /*Delete data*/
  public void deleteE(Employee[] E,int answer,int index){
  	
  	
  	E[answer]=null;//delete asking data
  	/*moving objects so overgab the apace and last position is left empty*/
  	for(int i=answer;i<index-1;i++)
  	  E[i]=E[i+1];
  	
  	  E[index-1]=null;//free last position
  	
  	
  	
	}
  /*print Employee data*/	
  public void print1E(Employee E){
	  /*print employee*/
		System.out.println("||****These are Employee's data: ****||");
		
			if(E!=null)
			{
			   
			    System.out.println(" |Serial Code: " +E.getSerialCode() +"|");
			    System.out.println(" |Last Name: " +E.getLastName() +"|");
			    System.out.println(" |Charge Per Hour: " +E.getChargePerHour() +"|");
			    System.out.println("------------------------------------------------------------\n");
			}
			else
				
				System.out.println(" \n|!!!These Employee data have been deleted or they are empty.!\n");
		
  }//-------------------------------------------------

	
	
}
