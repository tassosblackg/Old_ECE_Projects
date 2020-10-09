/**
 * Author:ANASTASIOS KARAGEORGIADIS AM.:2013030135
 */
package projectPack1;

//import tuc.ece.cs102.util.StandardInputRead;

public class WorkManShip {
	public static final int NumbOfWorks=50;//number of workmanships...
	
	/*member variables*/
	private String WorkName ;
	private int Code ;
	private int duration;
	private float cost;//cost of antalaktika
	//private int counter=0;

	/*-------------Constructors------------------*/
	public WorkManShip() {
		
	}//default constructor
	
	public WorkManShip(String workName,int i){
	WorkName=workName;
	Code=i+1;
	duration =0;
	cost=0;
	}
	//----------------------------------------------
	/***********************************************/
	/*.........Set methods.......................*/
	public void setWorkName(String workName) {
		WorkName = workName;
	}

	public void setCode(int code) {
		Code = code;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
   
	public void setCost(float cost) {
		this.cost = cost;
	}

	//.............................................
	/**
	 * 
	 */
	/*.........Get methods...................*/
	public String getWorkName() {
		return WorkName;
	}

	public int getCode() {
		return Code;
	}

	public int getDuration() {
		return duration;
	}
    
	 
	public float getCost() {
		return cost;
	}

    //..........................................
	
	/**
	*
	**/
	
	/*********Other methods*******************/
	/*print WorkManShip data*/
	public void printWMS(WorkManShip[] W, int counter,int I){
		/*print WorkManShop data*/
		System.out.println("||****These are Workmaship's data: ****||");
		for(int i=0; i<counter;i++)
		{	
			if(W[i]!=null)
			{
			    if(I==1)//only at option 5 are printed
			    {
				    System.out.println("||-->For WorkManShip's data No: " +(i+1) +"||");
			        System.out.println("||Press number: " +i +"||");
			    }
		        System.out.println(" |Name: " +W[i].getWorkName());
		        System.out.println(" |Code: " +W[i].getCode());
		        if(W[i].getCost()>0)
		        	System.out.println(" |Cost of mehanic parts: " +W[i].getCost());
		        if(W[i].getDuration()>0)
		        	System.out.println(" |Duration of WorkManShip: " +W[i].getDuration());
		        System.out.println("------------------------------------------------------------\n");
			}
			else
				if(I==1)
				System.out.println(" \n|!!!These WorkManShip data have been deleted or they are empty.!\n");
		}//end for
	}
	
	
	
	/*Delete data*/
    public void deleteWMS(WorkManShip[] W,int answer,int index){
    	
    	
    	W[answer]=null;//delete asking data
    	/*moving objects so overgab the apace and last position is left empty*/
    	for(int i=answer;i<index-1;i++)
    	  W[i]=W[i+1];
    	
    	  W[index-1]=null;//free last position
    	
    	
    	
	}
    /*print WorkManShip data*/
	public void print1WMS(WorkManShip W){
		/*print WorkManShop data*/
		System.out.println("||****These are Workmaship's data: ****||");
		if(W!=null)
			{
			    
		        System.out.println(" |Name: " +W.getWorkName());
		        System.out.println(" |Code: " +W.getCode());
		        System.out.println("------------------------------------------------------------\n");
			}
			else
				
				System.out.println(" \n|!!!These WorkManShip data have been deleted or they are empty.!\n");
		
	}
	
	
}
