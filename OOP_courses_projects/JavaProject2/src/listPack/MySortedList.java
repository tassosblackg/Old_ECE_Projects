/**Author:ANASTASIOS KARAGEORGIADIS AM.:2013030135...This code extends SortedList code........*/


package listPack;

import centralPack.*;

import readPackage.*;


public class MySortedList extends SortedList {
	
	/*override*/
	
	
	/***************Search By String*******************************************************************/
	/*******-------------|Give a string to search for the right object|-------------------*************/
	public Item findS(Item a,MySortedList l ){
		String s;//the string with which you want to search data
		
		ReadNcheck r=new ReadNcheck();//object for reading methods
		
		MyNode tmp=null;//to keep the node in which the data have been found
		
		boolean obj = false;//if there is an object
		
		/*try to catch the right object*/
		if(a instanceof Employee){
			System.out.println("\n -->Search for an Employee by fullName...\n");
			s=r.readNcheckS("fullName");//read the fullName
			a=new Employee(s);//set key for search
			obj=true;//there is object
			
		}
		else if( a instanceof RealEstate){
			System.out.println("\n -->Search for a RealEstate by address.......\n");
			s=r.readNcheckS("Address");
			a=new RealEstate(s);//KEY.....SET KEY....
			obj=true;//there is object
		}
		else
		{
			System.out.println("Not available type of object..A search can't be done...!!");
			obj=false;
			
		}	
		if(obj)
		{
		  	tmp=l.search(a);
		  	if(tmp!=null)
		  	{
		  		System.out.println("*The data you wanted have been found!!!*");
		  		FindNprint(tmp.getValue());///call the method to print node data
		  		return (tmp.getValue());
		  	}
		  	else
		  	{	
		  		System.out.println("\n*|Wrong insertion,none data have been found with this criterion..!|\n");
		  	    return null;
		  	}
		  	
		}
		else
		{
			System.out.println("Noone type of this object found!");
			return null;
		}
	}
	/**********!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!********************/
	//--------------------------------------------------------------------------------------------------------------------------
	
	/*******************************************************************************************************************/
	/**------|Delete a node(data) searching my name,or address|------------------------------***************************/
	public void deleteLD(Item a,MySortedList l)
	{
	     a=l.findS(a, l);///call method to search for the data you asked
	     if(a!=null)//if data have been found
	     {
	    	 System.out.println("*The above data will be deleted....!");
	    	 l.delete(a);//call the deleted method
	    	 System.out.println("..Data have been deleted....\n");
	     }
	     else
	    	 System.out.println("Data couldn't been deleted....\n");
	}
	//-------------------------------------------------------------------------------------------------------------------- 
	
	/*********--------------------------------***************/
	/**------|Print List Data of every object|----------**/
	public void print()
	{
		
		if(isEmpty())
		    System.out.println("\n!|The list you tried to print is empty!|!");
		
		
		else 
		{
		        //for loop to print all list data
			    for(MyNode tmp=head; tmp!=null; tmp=tmp.getNext())
		        {
		    	    Item e=tmp.getValue(); //set e and then call the method
		        	
		        	FindNprint(e);///find object and prints its data
		        
		    	}//end of for loop
		        
		}//end of else block
	}//end of print method
	//------------------------------------------------------------------------------------------------
	
	
	/*********~~~~~~!!!!!|Print only One Node's data|!!!!!!~~~~~~~~~~~~~~~~****************/
	public void printANode(Item a)
	{
		//Item a=n.getValue();
		FindNprint(a);///call the method which search for an object and prints its data
	
		
	}
	//-----------------------------------------------------------------------------------
	
	
	
	/***************************************************************************/
	/**********|Find Type of Object and Print its Data|**********/
	private void FindNprint(Item z)
	{
		/**Try To Found the Right Type Of Object**/
	     if(z instanceof HourlyEmployee)
	     {
		     HourlyEmployee h=new HourlyEmployee();
		     h= (HourlyEmployee)(z);
		     h.printHourlyEmplD();//print HourlyEmployee data.
	     }
	     
	     else if((z instanceof BasicPlusCommissionEmployee))
	     {
		    BasicPlusCommissionEmployee b=new BasicPlusCommissionEmployee();
		     b=(BasicPlusCommissionEmployee)(z);
		     b.printBPCEmpl();//print BasicPlusCommissionEmployee's data
	     }
	     else if(z instanceof CommissionEmployee)
	     {
		     CommissionEmployee c=new CommissionEmployee();
		     c=(CommissionEmployee)(z);
		     c.printComEmpl();//print CommissionEmployee's data
	     }
	     else if(z instanceof BuildingGround)
	     {
		     BuildingGround B=new BuildingGround();
		     B=(BuildingGround)(z);
		     B.printBlG();//print BuildingGround's data
	     }
	     else if(z instanceof PrivatelyOwned)
	     {
		     PrivatelyOwned p=new PrivatelyOwned();
		     p=(PrivatelyOwned)(z);
		     p.printPO();//print PrivatelyOwned's data
	     }
	     else if(z instanceof LeaseHold)
	     {
		     LeaseHold l=new LeaseHold();
		     l=(LeaseHold)(z);
		     l.printLh();//print LeaseHold's data
	     }
	     else//in case that object doesn't belong to any of these classes
	    	 System.out.println("|Type of object hasn't found!!|");
	}
	//-------------*-------------------------*----------------------------*------------------------------*----------------------
	
	
	/***********************************************************************************/
	/**|||||Print Data in Hierarchy by giving a Class Name||||||**/
	public boolean printAllInHierarchy(String className){
		boolean found=false;//class and object haven't found
		int timesGetIn=0;
		String s="centralPack."+className;//full path of classes
		//try and catch block
		try
		{
			if(head!=null)
			{
			
			
			    for(MyNode tmp=head; tmp!=null; tmp=tmp.getNext())//keep looking in the list
			    {
				
				
			        if(Class.forName(s).isInstance(tmp.getValue()))
		            {
		        	    timesGetIn++;//how many times get in the above if condition
			        	if(timesGetIn==1)//print message only the first time
		        	    System.out.println("\n*Class has been found....\nNow searching for type of object to print its data....\n");
		        	    
		        	    FindNprint(tmp.getValue());//find type of node object and print its data
		        	    System.out.println("//////////////////////////////////////////////////////////////////////////////////\n");
		        	    found=true;//class and its object found
		            }//end if
			        	        							     			
		        }//end for
			}
			else
				System.out.println("..List is empty...object can't been found!!!");
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.toString());
		}
		return found;
	}
	
	//----------------------------------------------------------------------------------------------------
	
}//end of class