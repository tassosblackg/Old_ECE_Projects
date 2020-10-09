/**ANASTASIOS KARAGEORGIADIS AM.:2013030135..This code has been given at lessons..... List code....*/

package centralPack;

//import readPack.tuc.ece.cs102.util.*;

public abstract class Item {
     /*memeber variables*/
	/*Adress and Afm are common variables for subclasses*/
	protected String Address;//
	protected String Afm; //aritmos mitroou
	/*Constructors*/
	public Item(){
		//default constructor
	}
	
	public Item(String address){
		Address=address;
		Afm=null;
	}
	
	public Item(String address,String afm){
		Address=address;
		Afm=afm;
	}
	//*********Getters and Setters**********************//
	public String getAddress() {
		return Address;
	}

	public String getAfm() {
		return Afm;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setAfm(String afm) {
		Afm = afm;
	}
	
	//==============================================================
	
	/*neccessary methods*/
	
	abstract public boolean equals(Item k);
	
	abstract public boolean less(Item k);
	
	abstract public Object key();

	
	
}
