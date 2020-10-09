
/**Author:ANASTASIOS KARAGEORGIADIS AM.:2013030135.. BasicPlusCommissionEmployee class*/

package centralPack;

import readPackage.*;

public class BasicPlusCommissionEmployee extends CommissionEmployee {

	/*member variables*/
	/*name, adress, afm,sales,rakeofff are inherited*/
	private float MinBasicSalary;
	
	/*Constructors*/
	public BasicPlusCommissionEmployee(){
		//default contructor
	}
	public BasicPlusCommissionEmployee(String name,String adress, String afm,float sales,float rakeOff,float minBasicSalary){
		super(name,adress,afm,sales,rakeOff);
		MinBasicSalary=minBasicSalary;
	}
	
	
	/***Getters and Setters****/
	public float getMinBasicSalary() {
		return MinBasicSalary;
	}
	public void setMinBasicSalary(float minBasicSalary) {
		MinBasicSalary = minBasicSalary;
	}
	//==================================================
	
	/****|||||Other Methods||||*****************/
	
	
	
	/**|Insert BasicPlusCommissionEmployee's data|*******/
	public BasicPlusCommissionEmployee insertBE(){
		CommissionEmployee c=new CommissionEmployee();
		BasicPlusCommissionEmployee b=new BasicPlusCommissionEmployee();
		float salary;
		ReadNcheck r=new ReadNcheck();
		
		//call insert from CommissionEmployee class, since BasicPlusCommissionEmployee extends, this class
		c=c.insertCE();
		System.out.println("\n ->Insert BasicPlusCommissionEmployee's data....\n");
		//read salary
		salary=r.readNcheckF("MinBasicSalary");
		
		b=new BasicPlusCommissionEmployee(c.getFullName(),c.getAddress(),c.getAfm(),c.getSales(),c.getRakeOff(),salary);
		return b;
	}
	//---------------------------------------------------------------------------------------------------------------------
	
	//**********************************************************************************
	public void printBPCEmpl(){
		
		System.out.println("\n|||These are Basic Plus Commission Employee's data: " );
		super.printComEmpl();//Commission Employee's data
		System.out.println("   ||Minimum Basic Salary:   " +getMinBasicSalary()+"$");
		System.out.println("----------------------------------------------------------------\n" );
		
		
	}
}
