
/**Author: ANASTASIOS KARAGEORGIADIS AM.:2013030135.....Employee Class*/

package centralPack;

import readPackage.*;

public class Employee extends Item{
	/*member variables*/
	/*afm,adress are inherited from Item*/
	protected String FullName;
	protected String key;
	/*objects*/
	
	
	/*Contructors*/
	public Employee(){
		//default constructor
	}
	
	public Employee (String k){
		key=k;
	}//set new key value
	
	public Employee(String fullName,String adress,String afm){
		super(adress,afm);
		FullName=fullName;
		key=fullName;
	}
	/*///////Getters and Setters///////////////////////*/
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	

	//======================================================
	
	/**||Other Methods|***********/
	
	/**------|BASIC INHERITED METHODS from Item|------------- */
    public boolean equals(Item a){
    	if(key.equals((String)a.key()))
    		return true;
    	else
    		return false;
    }
	
    public boolean less(Item a){
    	if(key.compareTo((String)a.key()) < 0)
    		return true;
    	else 
    		return false;
    }
	
    public Object key(){
    	return key;
    	
    }
	//------------------------------------------------------------------------------------------------------
    //******************************************************************************************************
    
   
    /**|Insert Employee Basic data|****/
    public Employee insertE(){
    	String name,address,afm;
    	Employee e=new Employee();
    	ReadNcheck r=new ReadNcheck();
    	System.out.println(".......................................................");
    	System.out.println("\n *Insert Employee data...\n");
    	//insert name
    	name=r.readNcheckS("fullName");
    	//insert address
    	address=r.readNcheckS("Address");
    	//insert afm
    	afm=r.readNcheckS("Afm");
    	
    	e=new Employee(name,address,afm);
    	return e;
    	
    }
    //-------------------------------------------
    
  
    
    
    /**************|Print Methods|**********************************************/
	public void printEmpl(){
		System.out.println("\n   |||These are Basic Employee's data: " );
		System.out.println("    ||FullName:   " +getFullName());
		System.out.println("    ||Adress:  " +Address);
		System.out.println("    ||Afm:  " +Afm);
		System.out.println("-------------------------------------------------");
	}
	//------------------------------------------------------------------------------
	
}
