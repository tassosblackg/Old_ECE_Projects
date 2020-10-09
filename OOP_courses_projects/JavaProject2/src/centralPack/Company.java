
/**Author:ANASTASIOS KARAGEORGIADIS AM.:2013030135.. Company class*/

package centralPack;

import readPackage.ReadNcheck;//import reading  code
import listPack.MySortedList;





public class Company extends Item {
	/*memebr variables*/
	protected String Name;
	protected String key;
	//******lists*********/
	/**|Employee type lists|*/
	private MySortedList Empl=new MySortedList();//list of Employee data
	
	/**|RealEstate type lists|*/
	private MySortedList Rl =new MySortedList();//list of BuildingGround data
	
	
	
	/*Contructors*/
	public Company(){
		//default constructor
	}
	public Company(String k){
		key=k;
	}

	public Company(String name,String adress,String afm) {
		super(adress,afm);
		Name = name;
		key=name;
	}
	

	/**|Getters And Setters|**/
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
	
	
	/**|Ohter methods|*/
	
	//***************************************
	/*******|Basic Inherited methods|*********************/
	public boolean equals(Item k){
		if(key.equals((String)k.key()))
    		return true;
    	else
    		return false;
	}
	
	public boolean less(Item k){
		if(key.compareTo((String)k.key()) < 0)
    		return true;
    	else 
    		return false;
	}
    public Object key(){
    	return key;
    	}
    //----------------------------------------------
    
    /*******|INSERT COMPANY BASIC DATA METHOD|******************/
    public Company insertComp(){
    	String name,adress,afm;//variables to keep reading data
    	Company comp;//object
    	ReadNcheck R=new ReadNcheck();//read code
    	
    	    System.out.println(" |Insert a Company's basic data: ");//prints a message
    	
    	    //read name of Company
    	    name=R.readNcheckS("Name");
    	    //read adress of company
    	    adress=R.readNcheckS("Adress");
    	   //read registration number
    	   afm=R.readNcheckS("Afm");
    	   //Call the right constructor
    	   comp=new Company(name,adress,afm);
    	   
    	   return comp; 	 
    	    	
    	
    }
    //------------------------------------------------------------------------------------------------------------------------
    
    /********|INSERTS LIST DATA|*****************/
    public void insertListD(Item obj){
    	
    	/*find the type of object*/
    	//Check if is Employee
    	if(obj instanceof Employee)
    	{
    	    //start to search from the lowest class in hierarchy
    		//Because an object of BasicPlusCommissionEmployee can be an object of CommissionEmployee too
    		if(obj instanceof BasicPlusCommissionEmployee)
    	     {
    	    	 BasicPlusCommissionEmployee b=new BasicPlusCommissionEmployee();
    	    	 //call insert method
    	    	 b=b.insertBE();
    	    	 //list
    	    	 Empl.insert(b);
    	    	 //print data
    	    	 
    	     }
    	     else if(obj instanceof CommissionEmployee)
    	     {
    	    	 CommissionEmployee c=new CommissionEmployee();
    	    	 //call insert method
    	    	 c=c.insertCE();
    	    	 //list
    	    	 Empl.insert(c);
    	    	 //print data
    	    	 
    	     }
    	     else if(obj instanceof HourlyEmployee )
    	     {
    	    	 HourlyEmployee E=new HourlyEmployee();
    	    	 //call insert method
    	    	 E=E.insertHE();
    	    	 //list
    	    	 Empl.insert(E);
    	    	 //print data
    	    	
    	     }
    	     else System.out.println("The type of Employee object doesn't exist!||insertListE() method||!\n");
    	
    	}
    	//Check if is RealEstate
    	else if(obj instanceof RealEstate)
    	{
    		//the order of if doesn't matter because you don't use class Building for creating an object
    		if(obj instanceof BuildingGround)
    		{
    			BuildingGround bG=new BuildingGround();
    			//call insert method
    			bG=bG.insertBg();
    			//list
    			Rl.insert(bG);
    		}
    		else if(obj instanceof PrivatelyOwned)
    		{
    			PrivatelyOwned p=new PrivatelyOwned();
    			//call insert method
    			p=p.insertPO();
    			//list
    			Rl.insert(p);
    		}
    		else if(obj instanceof LeaseHold)
    		{
    			LeaseHold l=new LeaseHold();
    			//call insert method
    			l=l.insertLh();
    			//list
    			Rl.insert(l);
    		}
    		else System.out.println("RealEstate object doesn't exist!");
    	}
    	//print Employee list data	
    	//Empl.print();//prints data after insertion,it's not always necessary 
    	//print RealEstate list data
    	//Rl.print();//prints data after insertion,it's not always necessary
    		
    }
    //-------------------------------------------------------------------------------------------------------------------------
    
    /**---------|Search inside a list|-----------****/
    public void SearchL(Item a)
    {
    	if(a instanceof Employee)
    	{
    		Empl.findS(a, Empl);//call method to read ,search and print
    	}
    	else if(a instanceof RealEstate)
    	{
    		Rl.findS(a, Rl);//call method to read, search and print
    	}
    }
    ///------------------------------------------------------
    
    /*********************************************************
     ******|Delete data from a list|****************************/
    public void deleteD(Item a)
    {
    	if(a instanceof Employee)
    	{
    		Empl.deleteLD(a, Empl);//call method to read,search and delete
    	}
    	else if(a instanceof RealEstate)
    	{
    		Rl.deleteLD(a,Rl);//call method to read,search and delete
    	}
    }
    
    
    ///-------***********|print methods|*********----------------------------------------------------------------***//
    
    /**|Prints Company's Basic Data|***********/
    public void printCompanyD(){
    	System.out.println("->These are basic Company's data:");
    	System.out.println("  |Name :  " +Name );
    	System.out.println("  |Adress: " +Address);
    	System.out.println("  |Afm:  " +Afm);
    	System.out.println("*----*---------*--------*---------*--------*------*-\n");
    	
    }
    /////
    
    /*****************************************************************************************************
    /*************|Print Company's full Data|||Basic Company's data ++Lists |||||************************/
    public void printAllCompanyD(){
    	
    	System.out.println("\n****************************************************************************************************");
    	printCompanyD();//prints company data
    	System.out.print(" |->These are the rest Company's data....\n");
    	Empl.print();//prints Employee list data
    	System.out.println("-----------------------------------------------------------\n");
    	Rl.print();//prints Real Estate list data
    	System.out.println("===============================================================================================_~|~\n");
    }
    //============================================================================================================
   
    /**********|Read a Class' name and Search for its object in a list and Print its data|*************************/
    public void readNprintByClass()
    {
         boolean found1,found2=true;//found2 =true because I want to get in else if(found2==false) only....
         ReadNcheck r=new ReadNcheck();//object for reading methods
         String className;
         System.out.println("_______________________________________________________________");
         System.out.println("..These are available class names:\n 1.Employee\n 2.HourlyEmployee\n 3.CommissionEmployee" +
         		"\n 4.BasicPlusCommissionEmployee\n 5.RealEstate\n 6.BuildingGround\n 7.PrivatelyOwned\n 8.LeaseHold\n.......");
         System.out.println("\n..*Insert a class'name to search and print its object's data....");
         className=r.readNcheckS("ClassName");
       
         found1=Empl.printAllInHierarchy(className);//call the method and return if the class have found
         if(!found1)//only in case that class isn't a class of Employee call the RealEstate one...
         found2=Rl.printAllInHierarchy(className);
         else if(!found2)
        	 System.out.println("!!!!!|Class with this name not found....!!!");
    }
	//--------------------------------------------------------------------------------------------------------------------
	
}
