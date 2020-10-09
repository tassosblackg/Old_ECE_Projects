
/**Author:ANASTASIOS KARAGEORGIADIS AM.:201303135...CommissionEmployee class...*/

package centralPack;

import readPackage.*;

public class CommissionEmployee extends Employee {

	/*member variables*/
	private float Sales;
	private float RakeOff;
	
	/*Contructors*/
	public CommissionEmployee(){
		//default contructor
	}
	public CommissionEmployee(String name,String adress,String afm, float sales,float rakeOff){
		super(name,adress,afm);
		Sales=sales;
		RakeOff=rakeOff;
	}
	
	
	/*****Getters and Setters***/
	public float getSales() {
		return Sales;
	}
	public float getRakeOff() {
		return RakeOff;
	}
	public void setSales(float sales) {
		Sales = sales;
	}
	public void setRakeOff(float rakeOff) {
		RakeOff = rakeOff;
	}
	//======================================================
	
	/********Other Methods***********/
	
	
	/**|Insert CommissionEmployee's data|*/
	public CommissionEmployee insertCE(){
		
		float sales,rakeoff;
		ReadNcheck r=new ReadNcheck();
		CommissionEmployee c=new CommissionEmployee();
		Employee e=new Employee();
		
		e=e.insertE();//call insertE to read the common dat of all employees
		System.out.println("\n ->Insert CommissionEmployee's data.....\n");
		//read extra variables data
		//insert sales
		sales=r.readNcheckF("Sales");
		//insert rakeoff
		rakeoff=r.readNcheckF("Rake-Off");
		
		c=new CommissionEmployee(e.getFullName(),e.getAddress(),e.getAfm(),sales,rakeoff);
		
		return c;
	}
	
	
	
	/*****//////////////////////////////////////////////////////////////////////////////********/
	public void printComEmpl(){
		System.out.println("\n|||These are Commission Employee's data: " );
		super.printEmpl();//prints Employee data
		System.out.println("   ||Sales:  " +getSales()+"$");
		System.out.println("   ||RakeOff:  " +getRakeOff()+"%");
		//System.out.println("-------------------------------------------------------------\n" );
	}
}
