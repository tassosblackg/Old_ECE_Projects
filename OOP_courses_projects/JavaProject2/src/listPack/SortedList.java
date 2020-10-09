/**ANASTASIOS KARAGEORGIADIS AM.:2013030135..This code has been given at lessons..... List code....*/



package listPack;

import centralPack.Item;

//import readPack.tuc.ece.cs102.util.*;

public abstract class SortedList {
	  /*member variables*/
	  protected MyNode head;  //head a pointer at the start of list             
	  protected int length;   //length of list            
      
	  /*Contructors*/
	  public SortedList()  {  
		  head = null;  
		  length = 0;     
	  }
	  /*Getters and Setters*/
	  public int getLength() { 
		  
		  return length; 
		  }
      
	  /*****|other Methods|*****************************************/
	  public boolean isEmpty()    { 
		  
		  return (head == null); 
	  }
       
	  //insert data in the list
	   public MyNode insert (Item a) {                         // Returns head
		    /*variables and objects*/
		    MyNode tmp = new MyNode(a);     
		    length++;
		    MyNode n1 = head, n2 = head;

		    
		    while ((n1 != null) && (n1.getValue().less(a) )) {  // Search for two nodes between of them we'll insert the new node
		      
		    	n2 = n1;   
		    	n1 = n1.getNext();  
		      
		    }                          
		    
		    if (n1 == head) {                                                  
		      tmp.setNext(n1); 
		      head = tmp;
		    }
		    else {                    // insert between n1 and n2 node.It is available for insert at the end too.
		      n2.setNext(tmp);
		      tmp.setNext(n1);   
		    } 
		    
		    return head;
		  } 
	   
		/*clear list*/
	   public void clearList() { 
		   
		   head = null; 
		   length = 0; 
		   
	   }
	   /*print*/
	   public void print() {
		   for (MyNode tmp = head; tmp != null; tmp = tmp.getNext())
		     
		      System.out.println("Node with data: " +  tmp.getValue());
		}
	   
	   /*search*/
	   public MyNode search(Item a) {
		    for (MyNode tmp = head;     tmp != null;      tmp = tmp.getNext())
	             if (a.equals(tmp.getValue()))    
		            return tmp;                         
	         return null;                                   
	  	}
	  
	   /*Delete a node*/
	   public MyNode delete (Item a) {
		    MyNode n1 = head, n2 = head;

		    while ((n1 != null) && (!a.equals( n1.getValue() ) ) ) {  
		        // searching for node we want to delete and his previous node
		        n2 = n1; 
		        n1 = n1.getNext(); 
		        }
		    
		    if (n1 != null) {     // the asked node found,now node will be deleted 
		        length--;
		        if (n2 != n1)       // n1 != head
		            n2.setNext(n1.getNext());
		        else                  // Delete first element and change head
		            head = head.getNext();     
		        n1.setNext(null);
		    }
		    
		    return head;
	   }





}//end of class
