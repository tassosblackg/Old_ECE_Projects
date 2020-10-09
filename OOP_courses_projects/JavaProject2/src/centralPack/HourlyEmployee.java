/**Author: ANASTASIOS KARAGEORGIADIS AM.:2013030135.....HourlyEmployee Class*/

package centralPack;

import readPackage.*;

public class HourlyEmployee extends Employee {

	/*member variables*/
	/*adress,afm are inherited*/
	private float HourlyPayment;
	private int HoursOfWork;
	
	/*Constructors*/
	public HourlyEmployee(){
		//default contructor
	}
	public HourlyEmployee(String name,String adress,String afm,float hourlyPayment,int hoursOfWork){
		super(name,adress,afm);
		HourlyPayment=hourlyPayment;
		HoursOfWork=hoursOfWork;
		
	}
	/***Getters and Setters**/
	public float getHourlyPayment() {
		return HourlyPayment;
	}
	public int getHoursOfWork() {
		return HoursOfWork;
	}
	public void setHourlyPayment(float hourlyPayment) {
		HourlyPayment = hourlyPayment;
	}
	public void setHoursOfWork(int hoursOfWork) {
		HoursOfWork = hoursOfWork;
	}
	//================================================
	
	/********|Other Methods|***************/
	
	/**|Insert HourlyEmployee data|**/
	public HourlyEmployee insertHE(){
		
		float payment;
		int hoursOfw;
		HourlyEmployee h;
		Employee e=new Employee();
		ReadNcheck R=new ReadNcheck();
		
		e=e.insertE();//call this method to insert common employees data name,address,etc... 
		System.out.println("\n ->Insert HourlyEmployee's data.....\n");
		//read extra variables data
		//insert payment per hour
		payment=R.readNcheckF("HourlyPayment");
		//insert number of work hours
		hoursOfw=R.readNcheckI("HoursOfWork");
		h=new HourlyEmployee(e.getFullName(),e.getAddress(),e.getAfm(),payment,hoursOfw);
		
		return h;
	}
	//-----------------------------------------------------------------------------------------
	
	//*************************************************************************************
	public void printHourlyEmplD(){
		System.out.println("\n|||These are Hourly Employee's data :");
		super.printEmpl();//prints Employee data
		System.out.println("  ||Hourly Payment: " +getHourlyPayment()+"$");
		System.out.println("  ||Hours of work: " +getHoursOfWork());
		System.out.println("----------------------------------------------------\n");
	}
}
