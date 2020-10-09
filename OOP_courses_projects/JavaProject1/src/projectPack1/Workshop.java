/**
 * Author:ANASTASIOS KARAGEORGIADIS AM.:2013030135
 */
package projectPack1;

//import tuc.ece.cs102.util.StandardInputRead;

public class Workshop {
	/*constant*/
	public static final int NumbOfWorkshops=1;//change if you want more Workshops...
	
	
	public static int counter=0;
	/*member variables*/
	private String FullNameOw;
	private String Adress;
	private String TelephNumber;
	
	/*objects*/
	private WorkManShip[] listOfWorks = new WorkManShip[WorkManShip.NumbOfWorks];
	private Employee[] listOfEmployees = new Employee[Employee.NumbOfEmployees];
	private Vehicle[] listOfVehicles = new Vehicle[Vehicle.NumbOfVehicles];
	private Repairing[] listOfRepairings = new Repairing[Repairing.NumbOfRepairings];
	
     /*-----Constructors------------*/
   	  public Workshop() {
		
	  }//default constructor

	  public Workshop(String fullNameOw, String adress, String telephNumber) {
		
		FullNameOw = fullNameOw;
		Adress = adress;
		TelephNumber = telephNumber;
		/*initialize objects*/
		for(int i=0; i<WorkManShip.NumbOfWorks;i++)
		listOfWorks[i] = new WorkManShip();
		for(int i=0; i<Employee.NumbOfEmployees;i++)
		listOfEmployees[i]= new Employee();
		for(int i=0; i<Vehicle.NumbOfVehicles;i++)
		listOfVehicles[i]= new Vehicle();
		for(int i=0; i<Repairing.NumbOfRepairings;i++)
		listOfRepairings[i]=new Repairing();	
		
	 }
    //-------------------------------------------------------------------------------

	
    /**---------Set methods----------------------------**/
	
	    public void setFullNameOw(String fullNameOw) {
		  FullNameOw = fullNameOw;
	    }

	    public void setAdress(String adress) {
		  Adress = adress;
	    }
			
		public void setTelephNumber(String telephNumber) {
		  TelephNumber = telephNumber;
	    }
        
	    /**Lists set methods**/
		public void setListOfWorks(WorkManShip[] listOfWorks) {
			this.listOfWorks = listOfWorks;
		}


		public void setListOfEmployees(Employee[] listOfEmployees) {
			this.listOfEmployees = listOfEmployees;
		}


		public void setListOfVehicles(Vehicle[] listOfVehicles) {
			this.listOfVehicles = listOfVehicles;
		}
		
		public void setListOfRepairings(Repairing[] listOfRepairings) {
			this.listOfRepairings = listOfRepairings;
		}

	
    /**-------------------------------------------------------**/
  
	/*-----------Get methods------------------------------------*/
	public String getFullNameOw() {
		return FullNameOw;
	}
	
	public String getAdress() {
		return Adress;
	}
	
	public String getTelephNumber() {
		return TelephNumber;
	}
     
	/**Lists getMethods**/
	public WorkManShip[] getListOfWorks() {
		return listOfWorks;
	}


	public Employee[] getListOfEmployees() {
		return listOfEmployees;
	}


	public Vehicle[] getListOfVehicles() {
		return listOfVehicles;
	}

    public Repairing[] getListOfRepairings() {
		return listOfRepairings;
	}

	
   /*--------------------------------------------------------------------------*/

    
    /*--------------Other methods--------------------*/
    /**Insert methods**/
	
	
	

    //---------------------------------------------------------------
	
	/*prints Workshop's data*/
	public void printW(){
		System.out.println("Workshop's Owner's FullName: " +FullNameOw);
		System.out.println("Workshop's Adress: " +Adress);
		System.out.println("Workshp's Telephone nuber: " +TelephNumber);
	}
	



	


	
	
	

	

}//end of class
