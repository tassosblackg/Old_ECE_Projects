
/**Author: ANASTASIOS KARAGEORGIADIS AM.:2013030135|| 
 * -----------------------------------------------------
 * I'm using code that it has been given at lessons, 
 * in classes Item,MyNode,SotredList....
 * ------------------------------------------------------
 */


package mainPack;

import centralPack.*;

import readPackage.*;//read and check code

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main main=new Main();//main object
		Item I;//item variable
		
		Company c=new Company();//create a Company's object
		int answer1=0,answer2=0,answer3=0;//answers of menu choices
		
		//while loop of menu
		while(true)
		{
		    /*print menu*/
			System.out.println("+==========+==============+=========================+=============+===========+============\n");
		    main.printMenu();
		    System.out.println("\n-------------------------------------------------------------------------------------------");
		    /*read answer*/
		    answer1=main.ReadInMenu(answer1);
		
		    /*switch mode*/
		    switch(answer1){
		        case 1:
		        {    
		        	if(c==null)    	
		            //create a company object
			    	c=c.insertComp();
		        	else
		        		System.out.println("You can't change Company's data...Wait until programm's end or press exit..!");
		        }	
		        answer1=0;//reset answer1
		        break;
		    
		        case 2:
		        {
		        	//insert or delete employee 
		        	/*print submenu*/
		    	    main.printSubMenu3();
		    	   /*read answer*/
		    	   answer2=main.ReadInMenu(answer1);
		    	   
		    	   //switch mode
		    	   
		    	   switch(answer2){
		    	      case 1:
		    	      {
		    	    	  //you choose insert employee data
		    	    	   main.printSubMenu3b();//submenu3b
		    	    	   //choose what kind of employee data you will insert
		    	    	   answer3=main.readSubM();//read choice
		    	    	   switch(answer3)
		    	    	   {
		    	    	       case 1:
		    	    	       {
		    	    		        //you choose to insert HourlyEmployee data
		    	    	    	    I=new HourlyEmployee();
		    	    		        c.insertListD(I);//to insert data into the list
		    	    	       }
		    	    	       break;
		    	    	       case 2:
		    	    	       {
		    	    	    	   //you choose to insert CommissionEmployee data
		    	    	    	  I=new CommissionEmployee();
		    	    	    	  c.insertListD(I);//to insert data into the list
		    	    	       }
		    	    	       break;
		    	    	       case 3:
		    	    	       {
		    	    	    	    //you choose to insert BasicPlusCommissionEmployee's data
		    	    	    	    I=new BasicPlusCommissionEmployee();
		    	    	    	    c.insertListD(I);//insert data into the list
		    	    	       }
		    	    	       break;
		    	    	       default: System.out.println("!!Error during submenu3b!!!");
		    	    	   
		    	    	   }//switch3
		    	      
		    	      }//case1-switc2
		    	      answer3=answer2=0;	  
		    	      break;
		    	      case 2:
		    	      {
		    	    	//you choose to Delete Employee data  
		    	    	  I=new Employee();
		    	    	  c.deleteD(I);//call method to delete data
		    	      }
		    	    	  
		    	      break;
		    	      default:System.out.println("||Error during switch mode of option !!");
		    	    }//switch2
		        	
		        	
		        }//case2-switch1
		        answer2=answer1=0;//reset answer1,2
		        break;
		        case 3:
		        { 
		    	    //insert or delete RealEstate
		        	/*print submenu*/
		    	    main.printSubMenu4();
		    	    /*read answer*/
		    	    answer2=main.ReadInMenu(answer1);
		    	    //switch mode
		    	    switch(answer2)
		    	    {
		    	         case 1:
		    	         {
                              //you choose to insert RealEstate data
		    	        	  main.printSubMenu4b();//choose what type of RealEstate data you will insert
		    	        	  answer3=main.readSubM();//read choice
		    	        	  switch(answer3)
		    	        	  {
		    	        	      case 1:
		    	        	      {
		    	        	    	  //you choose to insert BuildingGround's data
		    	        	    	  I=new BuildingGround();
		    	        	    	  c.insertListD(I);//add data to the appropriate list
		    	        	    	  
		    	        	      }
		    	        	      break;
		    	        	      case 2:
		    	        	      {
		    	        	    	  //you choose to insert PrivatelyOwned Building's data
		    	        	    	  I=new PrivatelyOwned();
		    	        	    	  c.insertListD(I);//add data to the appropriate list
		    	        	      }
		    	        	      break;
		    	        	      case 3:
		    	        	      {
		    	        	    	  //you choose to insert LeaseHold Building's data
		    	        	    	  I=new LeaseHold();
		    	        	    	  c.insertListD(I);//add data to the appropriate list
		    	        	    	  
		    	        	      }
		    	        	      break;
		    	        	      default:System.out.println("!!!Error during switch submenu of option 3(insert) from main menu!!!");
		    	        	  }

		    	         }
		    	         answer3=answer2=0;//reset answer2,3
		    	         break;
		    	         case 2:
		    	         {
		    	        	 //you choose to Delete RealEstate data
		    	        	 I=new RealEstate();
		    	        	 c.deleteD(I);//delete data of list
		    	         }
		    	        answer2=0;//reset answer2	 
		    	         break;
		    	         default:System.out.println("||Error during switch mode of option3--Insert-Delete-option !");
		    	    }
		        }
		        answer1=answer2=0;//reset answer1,2
		        break;
		    
		        case 4:
		        {
		    	    //you choose to search Employee data 
		        	I=new Employee();//create an object
		        	c.SearchL(I);//call the method to search the right list
		    	
		        }
		        answer1=0;//reset answer1
		        break;
		    
		        case 5:
		        {
		        	//you choose to search RealEstate data
		        	I=new RealEstate();//create an object
		        	c.SearchL(I);//call the method to search the right list
		        }
		        answer1=0;//reset answer1
		        break;
		        
		        case 6:
		        {
		        	//you choose to print All Company's data
		        	c.printAllCompanyD();
		        }
		        answer1=0;//reset answer1
		        break;
		        
		        case 7: 
		        {
		        	//you choose to print data By ClassName
		        	c.readNprintByClass();
		        }
		        answer1=0;//reset answer1
		        break;
		        case 8:
		        {
		        	 //you choose to exi the programm
		    	     System.out.println("\n||This is the end of program!Thank you!!||\n");
		    	     System.exit(0);
		        }
		        answer1=0;//reset answer1
		        default : System.out.println("Error!At main menu switch mode!!!");
		
		    }
		    
		}//end of while loop
		

	}//close public static method Main
    
	//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**************!!!!!!!!!!!!!!|MAIN METHODS|!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!***********************/
	
	/*prints menu options*/
	private void printMenu(){
		System.out.println("Choose between these options of Menu: ");
		System.out.println("Please run in sequence....\n");
		System.out.println(" 1.Press 1 to Insert a Company's data.");
		System.out.println(" 2.Press 2 to Insert or to Delete an Employee's data .");
		System.out.println(" 3.Press 3 to Insert or Delete RealEstate's data.");
		System.out.println(" 4.Press 4 to Search an Employee by fullname.");
		System.out.println(" 5.Press 5 to Search a RealEstate by adress .");
		System.out.println(" 6.Press 6 to Print full Company's data  .");
		System.out.println(" 7.Press 7 to Print an Employee's data or a RealEstate's data by specific class.");
		
		System.out.println(" 8.Press 8 to Exit the programm.");
	}
	/*prints submenu of option 3*/
	private void printSubMenu3(){
		System.out.println("  *||Choose between these options: ");
		System.out.println("    |1.Press 1 to Insert Employee's data.");
		System.out.println("    |2.Press 2 to Delete Employee's data.\n");
	
	}
	private void printSubMenu3b(){
		 System.out.println("  \n||Choose...");
		 System.out.println("     |1.Press 1 for HourlyEmployee's data.");
		 System.out.println("     |2.Press 2 for CommissionEmployee's data.");
		 System.out.println("     |3.Press 3 for BasicPlusCommissionEmployee's data.\n");
	}
	//---------------------------------------------------------------------------------
	//*************************|prints submenu of option 4|****************************************/
	private void printSubMenu4(){
		System.out.println("  *||Choose between these options: ");
		System.out.println("    |1.Press 1 to Insert RealEstate's data.");
		System.out.println("    |2.Press 2 to Delete RealEstates's data.\n");
	
	}
	private void printSubMenu4b(){
		 System.out.println("  \n||Choose...");
		 System.out.println("    |1.Press 1 for BuildingGround's data.");
		 System.out.println("    |2.Press 2 for PrivatelyOwned Building's data.");
		 System.out.println("    |3.Press 3 for LeaseHold Building's data.\n");
	}
	//----------------------------------------------------------------------------------------*****/
	/**|Read main menu answer|*****/
    private int ReadInMenu (int a) {
		
		/*object*/
		StandardInputRead sir =new StandardInputRead();
		/****/
		/*variables*/
		boolean bounds=false;
		int limit1=1,limit2=8;//limit2-limit1 = rage of menu options,for example 1-9....
		
		//controls the bounds of menu for example 1-9,or 1-4...
		switch(a)
		{
		    case 2: limit2=2;break;
		    case 3: limit2=2;break;
		    
		    default: limit1=1;limit2=8;
		}
		
		//control if insert data are Ok....
		do {
		 	    a=sir.readPositiveInt("\n Give your choice: ");
			    //check limits and print a message
			   if(a<limit1||a>limit2)
			   {
				    bounds=true;
				    System.out.println("|!!Your answer is out of bounds please try again!");
				    System.out.print(" |Menu bounds:  " +limit1);
				    System.out.println(" - " +limit2);
				    System.out.println("\nPlease try again: ");
			   }//if 1 ends..
			   else
				   bounds=false;
			
		   }while(bounds);
		//end of do..while	
		
		return a;
		
	}
   //------------end of ReadInMenu method---------------------------------------------------------	
    
    /**|Read submenu option's|***/
    private int readSubM(){
    	ReadNcheck r=new ReadNcheck();
    	int a=0;
    	int limit1=1,limit2=3;
    	boolean bounds=false;
    	do//check if answer is in bounds
    	{
    	    //read answer
    	    a=r.readNcheckI("Choice you made");
    	    if(a<limit1||a>limit2)
    	    {
    		    bounds=true;
    		    System.out.println(" !!Your choice is out of bounds..!\nPlease make your coice between these bounds:\n" 
    				+limit1 +"-" +limit2 +"\nPlease try again....\n");
    	    }
    	}while(bounds);
    	
    	return a;
    }
    //--*-----*------*------*---------*-------*------------*-*-*-*-*-*-*-*-*-------------*-------*-*-*-*-*-*-*-*-*-*-*-*******-*/

}//end of class Main
