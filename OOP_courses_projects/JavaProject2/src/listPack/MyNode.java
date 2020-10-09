/**ANASTASIOS KARAGEORGIADIS AM.:2013030135..This code has been given at lessons..... Node code....*/

package listPack;

import centralPack.Item;
//import readPack.tuc.ece.cs102.util.*;

public class MyNode {
	  /*meber variables*/
	  private Item info;
	  private MyNode next;
      
	  /*+++++++++++++++++Constuctors+++++++++++++++++++++++*/
	  public MyNode(Item dat) { info = dat; }     
	  
	  public MyNode(Item dat, MyNode b) {
	    info = dat;  next = b;
	  }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++
	  
	  /********Getters and Setters Methods*************/
	  public Item     getValue() { 
		  
		  return info;  
		  
	  }  
	  
	  public void     setNext(MyNode a)  { 
		  
		  next = a;     
		 
	  }
	  
	  public MyNode    getNext()   { 
		  
		  return next; 
		  
	  }
	  //-----------------------------------------


}
