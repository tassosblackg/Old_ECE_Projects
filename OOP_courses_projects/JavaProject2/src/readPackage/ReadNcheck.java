/**Author:ANSTASIOS KARAGEORGIADIS AM.:2013030135....ReadNcheck class| reads data,checks and prints appropriate messages*/ 

package readPackage;



public class ReadNcheck {

	StandardInputRead sir =new StandardInputRead();
	
	/*constructors*/
	public ReadNcheck(){
		//default constructor
	}
	
	
	/****!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!**/
    //Methods to Read AND Check.. They take a String AS Parameter, which one is Name of the string we wanna insert ex. s="Name "
    //if you want to insert the Name of some variable,object etc...
	/**---------------------|read a string|-------------------------------**/
	public String readNcheckS(String s){
    	
    	String a;
    	StandardInputRead sir =new StandardInputRead();
    	do{
    		a=sir.readString("\n ->Give me the " +s+" :");
    		if(a==null)
    		{
    			System.out.println(" \n!!Error during insertion of " +s +":");
    			System.out.println("     ..Please try again to insert " +s +" data... ");
    		}
    		
    	}while(a==null);
    	return a;
    }
    //**------------------------------------------------------------------------**/
    
    /**!!!!!!!!!|read a positive float number|!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!**/
    public float readNcheckF(String s){
    	
    	float a;
    	StandardInputRead sir =new StandardInputRead();
    	do{
    		a=sir.readPositiveFloat("\n ->Give me the " +s +" :");
    		if(a<0)
    		{
    			System.out.println("\n !!!Error during insertion of " +s +":");
    		    System.out.println("       ..Please try again to insert " +s +" data... ");
         	}
    		
    	}while(a<0);
    	return a;
    }
    /**-------------------------------------------------------------------------------*/
    
    /**-------------------------|read a positive int|***********************************/
     public int readNcheckI(String s){
    	
    	int a;
    	StandardInputRead sir =new StandardInputRead();
    	do{
    		a=sir.readPositiveInt("\n ->Give me the " +s +" :");
    		if(a<0)
    		{
    			System.out.println("\n !!!Error during insertion of " +s +":");
    			System.out.println("    ..Please try again to insert " +s +" data .... ");
    		}
    		
    	}while(a<0);
    	return a;
    }
     //---------------------------------------------------------------------------------
}
