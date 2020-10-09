/**
 * Author:ANASTASIOS KARAGEORGIADIS AM.:2013030135
 */
package projectPack1;

import tuc.ece.cs102.util.StandardInputRead;
import java.util.Date;

public class Main {

	private int counter=0;//workshop counter
	private int counter1=0;//WorkManShip counter
	private int counter3=0;//Employee counter
	private int counter4=0;//Vehicle counter
	private int counter5=0;//Repairing counter
	/**/
	private WorkManShip[] Works = new WorkManShip[WorkManShip.NumbOfWorks];
	private Workshop[] Wshop= new Workshop[Workshop.NumbOfWorkshops];
	private Employee[] employees= new Employee[Employee.NumbOfEmployees];
	private Vehicle[] vehicles = new Vehicle[Vehicle.NumbOfVehicles];
	private Repairing[] fixes =new Repairing[Repairing.NumbOfRepairings];
	/*main method*/
	public static void main(String[] args) {
		/*Necessary objects*/
		
		Main main=new Main();
		
		//Vehicle[] vehicles = new Vehicle[Vehicle.NumbOfVehicles];
		//Repairing[] fixes= new Repairing[Repairing.NumbOfRepairings];
	    
		
		
		
		
		/*Variables*/
		
		int answer1=0,answer2=0;
	    
		/*while loop to run the main program again*/
		while(true)
		{
		    answer1=0;//reset answer1
			System.out.println("============================================================");
			/*print menu*/
		    printMenu();
		    /*read choice*/
		    answer1=ReadInMenu(answer1);
		
		
		    /**-----------------Switch mode, Menu....---------------------------------------------------------------**/
		
		    switch(answer1){
		        case 1://want to insert workshop
		        { 
		    	    System.out.println("\nYou have selected option ''insert Workshop data'':");
		    	    System.out.println("________________________________________________________\n");
		    	    
		        	/*creating workshop data*/
		        	main.insertWorkshop();
		    	   
		        }
		        break;
		        
		        case 2://want to insert workmanships
		        {
		          
		          System.out.println("\nYou have selected option ''insert WorkManShip data'' :");
		          System.out.println("___________________________________________________________\n");
		          /*creating workmaship data*/
		           main.insertWorkMs();
		          
		        }
		        break;
		        
		        case 3:
		        {
		        	System.out.println("\nYou have selected option ''insert Employee data'':");
		        	System.out.println("_______________________________________________________\n");
		            main.insertEmployee(); 
		        }   
		        break;
		        case 4:
		        {	
		        	System.out.println("\nYou have selected option ''insert Vehicle data'':");
		        	System.out.println("______________________________________________________\n");
		        	main.insertVehicle();
		        }
		        break;
		        case 5:
		        {	
		        	System.out.println("\nYou have selected option ''insert Repairing data'':");
		        	System.out.println("_______________________________________________________\n");
		        	main.insertRepairings(); 
		        }
		        break;
		        case 6: 
		        {
		    	    System.out.println("\n You have selected option delete:");
		    	    System.out.println("______________________________________\n");
		        	
		        	/*prints option's submenu*/
		    	    printDelMenu(); 
		    	   /*read submenu's answer*/
		    	   answer2=ReadInMenu(answer2);
		    	   /*switch mode for submenu1*/
		    	   switch(answer2)
		    	   {
		    	       
		    	       case 1: 
		    	       {
		    	    	   System.out.println("\n |You have selected option ''delete WorkManShip's data'' .\n");
		    	    	   /*print available data for delete*/
		    	    	   main.Works[0].printWMS(main.Works, main.counter1, 1);
		    	    	   /*read answer*/
		    	    	   int a;
		    	    	   a=main.readCh(main.counter1);
		    	    	   
		    	    	   /*call delete method*/
		    	    	   main.Works[0].deleteWMS(main.Works, a, main.counter1);
		    	    	   main.setCounter1(main.counter1-1);//reduce numb of counter1 since delete
		    	       }
		    	       break;
		    	       case 2: 
		    	       {
		    	    	   System.out.println("\n |You have selected option ''delete Employee's data'' .\n");
		    	    	   /*print available data for delete*/
		    	    	   main.employees[0].printE(main.employees, main.counter3, 1);
		    	    	   /*read answer*/
		    	    	   int a;
		    	    	   a=main.readCh(main.counter3);
		    	    	   
		    	    	   /*call delete method*/
		    	    	   main.employees[0].deleteE(main.employees, a, main.counter3);
		    	    	   main.setCounter3(main.counter3-1); //reduce numb of counter3 since delete
		    	       }
		    	       break;
		    	       case 3: 
		    	       {
		    	    	   System.out.println("\n |You have selected option ''delete Vehicle's data'' .\n");
		    	    	   /*print available data for delete*/
		    	    	   main.vehicles[0].printV(main.vehicles, main.counter4, 1);
		    	    	   /*read answer*/
		    	    	   int a;
		    	    	   a=main.readCh(main.counter4);
		    	    	   
		    	    	   /*call delete method*/
		    	    	   main.vehicles[0].deleteVeh(main.vehicles, a, main.counter4);
		    	    	   main.setCounter4(main.counter4-1);//reduce numb of counter4 since delete
		    	       }
		    	       break;
		    	       case 4: 
		    	       {
		    	    	   System.out.println("\n |You have selected option ''delete Repairing's data'' .\n");
		    	    	   /*print available data for delete*/
		    	    	   main.fixes[0].printRepairing(main.fixes, main.counter5);
		    	    	   /*read answer*/
		    	    	   int a;
		    	    	   a=main.readCh(main.counter5);
		    	    	   
		    	    	   /*call delete method*/
		    	    	   main.fixes[0].deleteRepair(main.fixes, a, main.counter5);
		    	    	   main.setCounter5(main.counter5-1);
		    	       }
		    	       
		    	       break;
		    	       default:System.out.println("Error during switch submenu1{option 6}!");
		    	    }
		    	    answer1=answer2=0;//reset answer2's value..
		    	    break;
		         }//end case 6
		    
		        case 7:
		        {
		        	System.out.println("\n You have selected option find and print Repairing data by specific criterions:");
		        	System.out.println("____________________________________________________________________________________\n"); 
		        	
		        	/*prints option's submenu*/
		    	     printRepairingSubMenu();
		    	    /*read submenu's answer*/
		    	    answer2=ReadInMenu(answer2);
		    	    /*switch submenu*/
		    	    switch(answer2)
		    	    {
		    	        case 1:
		    	        {
		    	        	System.out.println(" \n|You have selected search by Vehicle's plate number:");
		    	        	System.out.println("_________________________________________________________\n");
		    	        	String a;
		    	        	StandardInputRead sir =new StandardInputRead();
		    	        	do
		    	        	{
		    	        		a=sir.readString(" \n|Give a Vehicle's plate number to search by.:");
		    	        		if(a==null)
		    	        			System.out.println(" \n|!!Wrong during insertion of Vehicle's plate number {search}");
		    	        	}while(a==null);
		    	        	main.fixes[0].findPlateN(main.fixes, a, main.counter5);//call method to search an print
		    	        }
		    	        
		    	        break;
		    	        case 2: 
		    	        {
		    	        	System.out.println(" \n|You have selected search by a date rage:");
		    	        	System.out.println("_________________________________________________________\n");
		    	        	Date a,b;
		    	        	/*read to dates*/
		    	            System.out.println(" \n|Down date:");
		    	        	a=main.readDate();
		    	        	System.out.println(" \n|Up date:");
		    	        	b=main.readDate();	
		    	        	/*find and print data*/
		    	        	main.fixes[0].findDateRage(main.fixes, a, b, main.counter5);
		    	        	
		    	        }
                        
		    	        break;
		    	        case 3: 
		    	        {
		    	        	System.out.println(" \n|You have selected search by a cost of Repairing:");
		    	        	System.out.println("_________________________________________________________\n");
		    	        	float cost;
		    	        	StandardInputRead sir =new StandardInputRead();
		    	        	/*check cost insertion {a}*/
		    	        	do
		    	        	{
		    	        		cost=sir.readPositiveFloat(" \n|Give a cost:");
		    	        		if(cost<0)
		    	        			System.out.println(" \n|!!Wrong during insertion of cost!\n\nPlease try again...\n");
		    	        	}while(cost<0);
		    	        	/*find and print data*/
		    	        	main.fixes[0].findCost(main.fixes, cost, main.counter5);
		    	        }
		    	        
		    	        break;
		    	        default: System.out.println("Error during switch submenu2{option 7}!");
		    	    }//end subswitch2
		    	    answer1=answer2=0;//reset answer2's value
		    	    break;
		    	
		        }//end case 7
		    
		        case 8:
		        {
		    	    System.out.println("\n You have selected option print data:");
		    	    System.out.println("_________________________________________\n");
		    	    
		        	/*prints option's submenu*/
		    	    printOneOfAllMenu();
		    	    /*read submenu's answer*/
		    	    answer2=ReadInMenu(answer2);
		    	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		    	    /*submenu's switch*/
		    	    switch(answer2)
		    	    {
		    	         case 1:
		    	         {
		    	        	System.out.println("\n |You have selected option print ''all WorkManShip data'':\n");
		    	        	System.out.println("________________________________________________________________\n");
		    	            main.Works[0].printWMS(main.Works, main.counter1,0);
		    	         }	
		    	         break;
		    	         case 2: 
		    	         {
		    	        	System.out.println("\n |You have selected option print ''all Employee data'':\n");
		    	        	main.employees[0].printE(main.employees, main.counter3,0);
		    	         }
		    	         break;
		    	         case 3:
		    	         {	
		    	        	System.out.println("\n |You have selected option print ''all Vehicle data'':\n");
		    	        	main.vehicles[0].printV(main.vehicles, main.counter4,0);
		    	         }
		    	         break;
		    	         case 4:
		    	         {
		    	        	System.out.println("\n |You have selected option print ''all Repairings data'':\n");
		    	        	main.fixes[0].printRepairing(main.fixes, main.counter5);
		    	         }
		    	         break;
		    	         default: System.out.println("Error during switch submenu3{print option 8}!");
		    	    }//end switchSubMenu3
		    	    
		    	    
		    	   
		        }//end case 8
		        answer1=answer2=0;//reset answer2's value..
		        break;
		        case 9: System.out.println("\n|->Program stops here!Bye!|<-"); System.exit(0);
		        default: System.out.println("Error during main switch mode!");
		    }//end main switch mode
		}//end while(1)
		/**\\\\\\\\\\switch mode end here////////////////////////////////////////////////////***/
		
		
		
		
	
	
	
	}//end public static void main
	
	
/****************************************************************************************************************************/
	/**------------Main methods----------------------------------------------------------------------------------------**/
	/**set methods**/
	
	/*prints menu options*/
	private static void printMenu(){
		
		System.out.println("Choose between these options of Menu: ");
		System.out.println("Please run in sequence....\n");
		System.out.println(" 1.Press 1 to insert a Workshop's data.");
		System.out.println(" 2.Press 2 to insert a WorkManShip's data.");
		System.out.println(" 3.Press 3 to insert an Employee's data.");
		System.out.println(" 4.Press 4 to insert a Vehicle's data.");
		System.out.println(" 5.Press 5 to insert a Repairing's data.");
		System.out.println(" 6.Press 6 to delete some data.");
		System.out.println(" 7.Press 7 to find and print a Repairing's data by specific criterions.");
		System.out.println(" 8.Press 8 to print some data.");
		System.out.println(" 9.Press 9 to exit the programm.");
	}
	//..................................................................................................
	
	/*prints delete option's sub menu*/
	private static void printDelMenu(){
		System.out.println("Choose between these options: \n");
		System.out.println("  1.Press 1 to delete a WorkManship's data.");
		System.out.println("  2.Press 2 to delete a Employee's data.");
		System.out.println("  3.Press 3 to delete a Vehicle's data.");
		System.out.println("  4.Press 4 to delete a Repairing's data.");
	}
	//........................................................................
	
	/*prints Repairing's ||find and print||option's sub menu*/
	
	private static void printRepairingSubMenu(){
		System.out.println("Choose an option to search for Repairing's data.\n");
		System.out.println(" 1.Press 1 to search by Vehicle's plate number.");
		System.out.println(" 2.Press 2 to search by a date rage. ");
		System.out.println(" 3.Press 3 to search by cost of Repairing.");
	}
    //..........................................................................
	

	/*prints option's 8, submenu*/
	private static void printOneOfAllMenu(){
		System.out.println("Choose what you want to print:");
		System.out.println(" 1.Press 1 to print a WorkManShip's data.");
		System.out.println(" 2.Press 2 to print an Employee's data.");
		System.out.println(" 3.Press 3 to print a Vehicle's data.");
		System.out.println(" 4.Press 4 to print a Repairing's data.");
	}
	//...................................................................
    /***********************************************************************/
    /*set methods for main*/
	public void setCounter1(int counter1) {
		this.counter1 = counter1;
	}


	public void setCounter3(int counter3) {
		this.counter3 = counter3;
	}


	public void setCounter4(int counter4) {
		this.counter4 = counter4;
	}


	public void setCounter5(int counter5) {
		this.counter5 = counter5;
	}
    //--------------------------------------------------------------------
	
	/**get methods for main*/
	public int getCounter1() {
		return counter1;
	}


	public int getCounter3() {
		return counter3;
	}


	public int getCounter4() {
		return counter4;
	}


	public int getCounter5() {
		return counter5;
	}
   /****************************************************************************************/
    /**----------------------------------------------------------------**/
	/*A method to read answers of user when using the menu*/
	private static int ReadInMenu (int a) {
		
		/*object*/
		StandardInputRead sir =new StandardInputRead();
		/****/
		/*variables*/
		boolean bounds=false;
		int limit1=1,limit2=9;//limit2-limit1 = rage of menu options,for example 1-9....
		
		//controls the bounds of menu for example 1-9,or 1-4...
		switch(a)
		{
		    case 6: limit2=4;break;
		    case 7: limit2=3;break;
		    case 8: limit2=4;break;
		    default: limit1=1;limit2=9;
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
	/******/
	
/**-----------------------------end menu options methods-------------------------------------------------------------------**/
	
	
	/****************************!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!****************************************/
    /********InsertMethods**************************/
	
	/*insert workshop data method*/
	 public void insertWorkshop(){
		/*objects*/
		StandardInputRead sir = new StandardInputRead();
	    /*Variables*/
		String fullName,adress,telephone;
	    boolean nend=false;
	   if(counter<Workshop.NumbOfWorkshops)
	   {
	       /*control insertion*/
	       do
	        {
	    	    fullName=sir.readString(" \n |Give Workshop's owner's full name seperate with space: ");
	    	    adress=sir.readString(" |Give Workshop's adress: ");
	    	    telephone=sir.readString(" |Give Workshop's telephone number: ");
	    	
	    	     /*if there is a mistake during reading*/
	    	    if((fullName==null)||(adress==null)||(telephone==null))
	    	   {
	    		    System.out.println(" !!Wrong during reading insertion!");
	    		    nend=true;
	    	   }
	    	
	        }while(nend);
	    Wshop[counter]=new Workshop();//default set of Workshop object
	    Wshop[counter]=new Workshop (fullName,adress,telephone);//create workshop
	    counter++;
	   }
	   else System.out.println("\n\n->!Workshops list is full!Go on an other option..\n\n");
	}
	//--------------------------------------------------------------------------

	
	
	/*Insert WorkManShip data*/
	public void insertWorkMs()
	{
		    if(counter1<WorkManShip.NumbOfWorks)
		    {
		        /*objects*/
		        StandardInputRead sir = new StandardInputRead();
		        
		        /*variables*/
		        String name;
		        
		        /*checking insert and repeat read until insertion is fine*/
		        do
		        {
			        name=sir.readString(" |Give a WorkManShip name: ");
			        if(name==null)
				     System.out.println(" !!Wrong during insertion of WorkManShip's name!");
		
		        }while(name==null);
		        Works[counter1]= new WorkManShip();//default set of object
		        Works[counter1]= new WorkManShip (name,counter1);
		        counter1++;
		        /*create list of Works at workshop class*/
		        for(int i=0; i<counter;i++)
		        Wshop[i].setListOfWorks(Works);
		    }
		    else
		    {
		    	System.out.println("\n\n!WorkManShip list is full! ");
		    	System.out.println("If want to delete ''workmanship'' data,next time select option 6 from Menu!");
		    	System.out.println("If you don't,just go on other options of menu,(except 2)!\n");
		        System.out.println();
		    }
		
	}
	//---------------------------------------------------------------------------------------------------------
	/**
	 * 
	 */
	/*Insert employee method*/
	public void insertEmployee(){
        
		if(counter3<Employee.NumbOfEmployees)
		{
			/*objects*/     
			StandardInputRead sir = new StandardInputRead();
			
			String lname;
			float Charge;
			
			/*check string reading*/
			do
			{
				lname=sir.readString(" |Give employee's last name: ");
			    if(lname==null)
			    System.out.println("!!Wrong during insertion of employee's last name!\n\nPlease try again...\n");
			}while(lname==null);
			
			/*check float reanding*/
			do
			{
				Charge=sir.readPositiveFloat(" |Give employee's charge per hour: ");
				if(Charge<0)
					System.out.println("!!Wrong during insertion of employee's charge per hour!\n\nPlease insert a positive number...\n");
			}while(Charge<0);
			employees[counter3]=new Employee();
			employees[counter3]=new Employee(counter3,lname,Charge);
			counter3++;
			/*creating list of employees at workshop class*/
			for(int i=0;i<counter;i++)
			Wshop[i].setListOfEmployees(employees);
			
		}
		else
		{
			System.out.println("\n\n!Employees list is full! ");
	    	System.out.println("If want to delete ''employee'' data,next time select option 6 from Menu!");
	    	System.out.println("If you don't,just go on other options of menu,(except 3)!\n");
	        System.out.println();
		}//end else
			
		}//end method insertEmployee.....
	//-------------------------------------------------------------------------------------------------------------------------------------
/**
 * 
 */
	/*insert Vehicle method*/
	public void insertVehicle(){
		
		if(counter4<Vehicle.NumbOfVehicles)
		{
			/*objects*/
			StandardInputRead sir = new StandardInputRead();
			/*variables*/
			String plateNumb,lname,telephone;
			
			/*check insertion of plate number*/
			do
			{
				plateNumb=sir.readString(" |Give Vehicle's plate number: ");
				if(plateNumb==null)
					System.out.println("|!!Wrong during giving plate number!\n\nPlease try again...\n");
				
			}while(plateNumb==null);
			/*check insertion of last name*/
			do
			{	
				lname=sir.readString(" |Give Vehicle's owner's last name: ");
				if(lname==null)
					System.out.println("!!!Wrong during giving last name!\n\nPlease try again...\n");
			
			}while(lname==null);	
			/*check insertion of telephone*/
			do
			{
				  telephone=sir.readString(" |Give Vehicle's owner's telephone number: ");
    			  if(telephone==null)
				   System.out.println("!!Wrong during giving telephone number!\n\nPlease try again...\n");
			}while(telephone==null);
			
			vehicles[counter4]=new Vehicle();//default create of vehicles objects
			vehicles[counter4]=new Vehicle(plateNumb,lname,telephone);
			counter4++;//a counter that counts how many data has been inserted
			/*create list of vehicles at workshop class*/
			for(int i=0;i<counter;i++)
				Wshop[i].setListOfVehicles(vehicles);
		}
		else
		{
			System.out.println("\n\n!Vehicles list is full! ");
	    	System.out.println("If want to delete ''vehicle'' data,next time select option 6 from Menu!");
	    	System.out.println("If you don't,just go on other options of menu,(except 4)!\n");
	        System.out.println();
			
		}
	}//end of insertVehicle method****//////////////////
	
	/**
	 * 
	 */
    /*insert Repairings method*/
	public void insertRepairings(){
	
		if(counter5<Repairing.NumbOfRepairings)
		{
		    /***/
			StandardInputRead sir = new StandardInputRead();
		    int answer1,answer2,answer3,duration,i=0,end;
		    Date date;
		    float cost;
		    fixes[counter5]=new Repairing();
		    do
		    {
		         if(i<Repairing.NumbOfW)
		         {
			         System.out.println("\nChoose a WorkManShip from list below:");
		        	 /*print WorkManShop data*/
		             Works[0].printWMS(Works, counter1,1);
		            /*read answer of user*/
		            answer1= readCh(counter1);
		
		            /*insert duration of work*/
		            do
		            {
		                duration= sir.readPositiveInt("\n\n|Give WorkManShip's duration: ");
		                if(duration<0)
		                	System.out.println("\n!!Wrong during insertion of WorkManShip's duration\n\nPlease try again...\n");
		            }while(duration<0);
		            /*check insertion of cost*/
		            do
		            {
		            	cost=sir.readPositiveFloat(" \n|Give the cost of WorkManShip{antallaktika}:");
		            	if(cost<0)
		            		System.out.println(" \n|!!!Wrong during insertion of cost {antallaktika}");
		            }while(cost<0);
		            
		            //set duration in the specific WorkManShip's object
		            Works[answer1].setDuration(duration);
		            Works[answer1].setCost(cost);
		            
		            System.out.println("\nChoose an employee form list below:");
		            /*print employee*/
		            employees[0].printE(employees, counter3,1);
		            answer2= readCh(counter3);
		            /*semi create fixes list*/
		            fixes[counter5]=new Repairing(Works[answer1],employees[answer2],i);
		            /*insert Repairings total cost*/
		            fixes[counter5].setTotalCost(Works[answer1].getCost()+(Works[answer1].getDuration()*employees[answer2].getChargePerHour()));
		            i++;//counter of how many works and employees have you insert
		          
		            System.out.print("|Do you want to insert more WorkManShips? |");
		            System.out.print("\n |Press 0 for 'yes'.\n |Press 1 for 'no'.\n");
		            end=readCh(2);
		        }
		        else
		        {
		            end=1;
		    	    System.out.println("\n |Sorry,This Repairing is full of WorkManShips!\n");
		        }
		    }while(end==0);
		     System.out.println("\nChoose a Vehicle from list below: ");
		    /*print vehicle*/
		    vehicles[0].printV(vehicles,counter4,1);
		    answer3= readCh(counter4);
		    /*Read date of Repairing*/
		    date=readDate();
		    
		    fixes[counter5].setVeh(vehicles[answer3]);
		    fixes[counter5].setDate(date);
		    counter5++;
		    /*create list of Repairing inside Workshop class*/
		    for(int j=0; j<counter;j++)
		    	Wshop[j].setListOfRepairings(fixes);
	 }
	else
	{
		System.out.println("\n\n!Repairing list is full! ");
    	System.out.println("If want to delete ''repairing'' data,next time select option 6 from Menu!");
    	System.out.println("If you don't,just go on other options of menu,(except 5)!\n");
        System.out.println();
			
	}
		
	}//end of Repairing insert
	
	
	
	/**read repairings data menu**/
	public int readCh(int c)
	{
		StandardInputRead sir = new StandardInputRead();
		int answer;
		boolean bounds=false;
		
		do
		{
			answer=sir.readPositiveInt("\n||Make your choice: ");
			if (answer<0||answer>c)
			{
				bounds=true;
				System.out.println("|Your choice is out of limits!\n\nPlease try again...\n");
			}
			else
				bounds=false;
		}while(bounds);
		
		return answer;
	}//end read repairings menu
	
	/*read date*/
	public Date readDate(){
		StandardInputRead sir = new StandardInputRead();
		Date date;
		do
		{
			date=sir.readDate(" |Give the date of Repairing: ");
			if(date==null)
				System.out.println("!!Wrong during insertion of date(hh/mm/yy)!\n\nPlease try again...\n");
		}while(date==null);
		return date;
	}//end of read date
	
	
	
}//end of class Main
