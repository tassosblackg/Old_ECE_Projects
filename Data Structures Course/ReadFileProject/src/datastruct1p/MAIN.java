/*
 * Author:ANASTASIOS KARAGEORGIADIS
 * AM.:2013030135
 * Domes Dedomenwn Project1
 * Main class of program
 */
package datastruct1p;
import FileMan.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author soulis
 */
public class MAIN {
  /**member variables*/
    File fl;
    final static String FileName="BinDataFile.dat";
    
    /*constructor*/
    public MAIN(){
        fl=new File(FileName);
       
    }
    /*@insert data to the file*/
    public void insertD(String N)
    {
        fl.insertD(N);
    }
    /*@search data from file*/
    public void searchD(String N)
    {
        fl.searchD(N);
    }
    /*@print page of file*/
    public void printPd(String N)
    {
        fl.printPd(N,0,1);//p=0, st==1->read from console the page to print
    }
    /*@print file's data*/
    public void printF(String N){
        fl.printF(N);
    }
    /*-----|@Read an integer|------------------------------------------------------------------------*/
     public int readFromU()
     {
        String input = null;
        int number = 0;
        try 
        {
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             input = bufferedReader.readLine();
             number = Integer.parseInt(input);
             return number;
         } 
        catch (NumberFormatException ex) 
        {
            System.out.println("@Not a number !");
        } catch (IOException e) 
        {
           e.printStackTrace();
        }
        return number;
     }
    /****METHODS**********/
      /*MAIN METHOD**/
      public static void main(String[] args) {
          // TODO code application logic here
         MAIN m=new MAIN();
         m.insertD(FileName);
         int answer;
         do
         {
            m.printMenu();
            do
            {
                answer=m.readFromU();
                /*check if answer is not valid number*/
                if(answer>3||answer<0)
                    System.out.println("!|Sorry invalid choice..Plz try again!{available choices(0-3)}|..");
            }while(answer>3||answer<0);
            switch(answer)
            {
                case 1:m.searchD(FileName);break;
                case 2:m.printPd(FileName);break;
                case 3:m.printF(FileName);break;
                case 0: 
                {
                    System.out.println("\n->Program finished..");
                    System.exit(0);
                    break;
                }
                default:System.out.println("\nERROR during switch mode-main-");
            }
         }while(answer!=0);
        
      }
    /***---OTHER METHODS SOME PRINT MENUS POSIBLE*/
      
      public void printMenu(){
          System.out.println("=================================================");
          System.out.println("\n |MAIN MENU choose..");
          System.out.println(" |Press 1 for search"+File.N_keys+" keys in they file. ");
          System.out.println(" |Press 2 for printing a page's data.");
          System.out.println(" |Press 3 for printing the whole file.");
          System.out.println(" |Press 0 for exit.");
          System.out.println("\n*|Make your choice:");
          System.out.println("==========================================================");
      }
      public void readAnswer(){
          
      }
}
