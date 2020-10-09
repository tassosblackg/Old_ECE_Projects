/*+--------------------------------------+
 *|Anastasios Karageorgiadis                            |
 *|Am.:2013030135                                     |
 *|LabTeam: LAB21124955                             |                                            
 *|Project2o DATA structures                         _|                           
 *|_______________________________________|
 *ayth einai h klassh komvos einai leaf,internal node h root
 *
 */
package BPtree;

/**
 *
 * @author soulis
 */
import java.io.*;
import java.util.*;

public  class BPnode implements Serializable {
    /*member variables*/
    private int parent;
    /*childen*/
    private int[] datPnt;/*@if node has pointers if leaf it has data..*/
    
    private int NumOfkeys;/*@arithmos kleidiwn pu exoun graftei se ena kombo*/
    private int[] keys ;//keys in a node
    
    private int RightBro;
    private int LeftBro;
    
     /*Constructors*/
    /*@parameter nn= BPtree.N, if is a root or internal node,
    *nn=m,if its leaf;//
    */
    public BPnode (int nn){
        parent=-1;
        RightBro=-1;
        LeftBro=-1;
        NumOfkeys=0;
        keys=new int [nn];
        datPnt=new int[nn+1];
    }
    
    
    /*--------------|getters n setters|---------------------------------------------------------*/
    //setters
    public void setRBro(int rb){
        this.RightBro=rb;
    }
    public void setLBro(int lb){
        this.LeftBro=lb;
    }
    public void setParent(int p){
        this.parent=p;
    }
    public void setNofKeys(int n){
        this.NumOfkeys=n;
    }
    public void setDatPointers(int pointOdat,int indx){
        this.datPnt[indx]=pointOdat;
    }
    //getters
    public int getRBro(){
        return(RightBro);
    }
    public int getLBro(){
        return(LeftBro);
    }
    public int getParent(){
        return parent;
    }
    
    public int getNumOfkeys (){
        return(this.NumOfkeys);
    }
    public int getkeys(int index){
       
        return(this.keys[index]);
    }
    public int getDatPnt(int index){
        return(this.datPnt[index]);
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /*##---------------------|other methods|---------------------------------------------------------*/
   public void setkey(int key,int pos)
   {
       this.keys[pos]=key;
   }
    
    /**INSERT
     *insert key in a root node
     * @param key
     */
    
   public void insertKey(int key,int indx){
       
       this.keys[indx]=key;
   }
   
    /**SEARCH
     *search for a key in root node
     * @param key
     * @return
     */
   
    public int search4Key(int key){
       return(key);
   }
   /**DELETE
     *delete key in a root node
     * @param key
     */
    
    
   public void deleteKey(int key){
       
   }
   /*@check if is leaf*/
   public boolean isLeaf(){
       boolean st=false;
       if( (this.RightBro!=-1) || (this.LeftBro!=-1) ) {
               st=true;
       }
       return st;
   }
   /*@check if isROot*/
   public boolean isRoot(){
       boolean st=false;
       if(parent==-1){
           st=true;
       }
       return st;
   }
   
   /*@|print|node's data*/
   public void printNode(){
       System.out.println(" *****Node's data***********");
       System.out.println(" |Parent="+this.parent);
       System.out.println(" |NumOfkeys= "+this.NumOfkeys);
       System.out.println(" |RightBro="+this.RightBro);
       System.out.println(" |LeftBro= "+this.LeftBro);
       System.out.println("||Printing keys...");
       for(int i=(BPtree.N-1);i>=0;i--)
       {
           System.out.println(" |key["+(i)+"]= "+this.getkeys(i));
           
       }
       System.out.println("\n||Printing pointers...");
       for(int j=BPtree.N;j>=0;j--)
       {
           System.out.println(" |*pointer["+j+"]= "+this.getDatPnt(j));
       }
       System.out.println(" |*last pointer["+BPtree.N+"]= "+this.getDatPnt(BPtree.N ));
       System.out.println("--------------------------------------------------------------\n ");
   }
}
