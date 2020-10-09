/*
 *+--------------------------------------+
 *|Anastasios Karageorgiadis                            |
 *|Am.:2013030135                                     |
 *|LabTeam: LAB21124955                             |                                            
 *|Project2o DATA structures                         _|                           
 *|_______________________________________|
 *! PROSOXH!!!!! An prose3ete h synasrthsh DIAGRAFHS pu yparxei mes thn main
 *einai se sxolia gt de douleuei swsta...o algorithmos ths diagrafhs vrisketai sthn klassh BPtree..sthn methodo deleteKey
 * mphke se sxolia edw gia na mhn dhmiourgei provlhma..perissotera e3eigountai sthn arxh ths BPtree klasshs kai mesa sthn methodo thn idia...
 *
 *EXTRA: Exei prosthe8ei kai h epilogh ths ektypwshs mias selidas tu arxeiou
 *
 */
package MainP;

import java.io.*;
import java.io.OutputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import BPtree.*;


//import reading libraries



public class Main
{
    //member variables
    private BPtree bpt;
    //menu options
    final int minOption=0;
    final int maxOption=4;
    
    public Main(){
       bpt=new BPtree();
     }

    public void createBPtree(){
      
      bpt.insert();//insert N keys to a tree
      }
    
    public void searchAkey(int key){
      
      bpt.search4key(key);
     }

    public void searchRageKeys(int min,int max){
       bpt.searchRageKeys(min,max);
     }
    /*public void deleteAkey(int key){
       bpt.deleteKey(key);
     }*/
   public void printN(int position){
       bpt.printAnode(position);
     }

     public static void main(String args[]) throws IOException, ClassNotFoundException {
 
        System.out.println("*Start of programm...running.. ");
        Main m =new Main();
        int answer;
        m.createBPtree();//creates BPtree and inserts N keys
        System.out.println("|*Keys insertion has finished...Successfully.. ");
        System.out.println("--------------------------------------------------\n ");
        
        //menu
       while(true)
       {
            m.PrintMenu();
            answer=m.ReadAnswer();
            switch(answer){
               case 1: 
               {
                  System.out.println("|Give a key(integer): ");
                  int key;
                  key=m.readKey();
                  m.searchAkey(key);
                  break;
               }
               case 2:
               {
                  System.out.println("|Give down rage key(min): ");
                  int dr,ur;
                  dr=m.readKey();
                  System.out.println(" |Give me up rage key(max): ");
                  ur=m.readKey();
                  m.searchRageKeys(dr,ur);
                  break;
               }
               case 3:
               {
                   System.out.println("|Give a key to delete: ");
                   int dk;
                   dk=m.readKey();
                   //m.deleteAkey(dk);
                   break;
               }
               case 4:
               {
                   System.out.println("|Give the page you want to print: ");
                   int p;
                   p=m.readPos();
                   m.printN(p);
                   break;
               }
              
               case 0:

               {
                  System.out.println("**You're exiting the programm...exit..complete...programm finished...! ");
                  System.exit(0);
                  break;
               }
               default:System.out.println("****ERROR during switch mode--menu*******! ");
          }//end switch
           
        }//end while

                               
        

    }

    public void PrintMenu(){
       System.out.println("------------------------------------------------------------ ");
       System.out.println("||Make a choice between of them:                          ||");
       System.out.println(" |Press 1 if you want to search for a key.                |");
       System.out.println(" |Press 2 if you want to search for a rage of keys.       |");
       System.out.println(" |Press 3 to delete a key.                                |");
       System.out.println(" |Press 4 to print a page.                                |");
       System.out.println(" |Press 0 to exit.                                        |");
       System.out.println("____________________________________________________________ ");
   }
   public int ReadAnswer(){
     
        String input = null;
        int number = 0;
        try 
        {
             do{
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                 input = bufferedReader.readLine();
                 number = Integer.parseInt(input);
                //return number;
                 if(number<minOption||number>maxOption)
                     System.out.println(" *Choice must be between 0-4..try again...");
                 }while(number<minOption||number>maxOption);
         } 
        catch (NumberFormatException ex) 
        {
            System.out.println("@Not a number !ERROR readAnswer*");
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return number;

    
   }
   
   public int readKey(){
       String input = null;
        int number = 0;
        try 
        {
             do{
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                 input = bufferedReader.readLine();
                 number = Integer.parseInt(input);
                 //return number;
                 if(number<1)
                     System.out.println(" *Key must be greater than 1..try again..");
             }while(number<1);
         } 
        catch (NumberFormatException ex) 
        {
            System.out.println("@Not a number !ERROR READKEY");
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return number;

    }
   
   public int readPos()
   {
        String input = null;
        int number = 0;
        try 
        {
             do{
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             input = bufferedReader.readLine();
             number = Integer.parseInt(input);
             //return number;
             if(number<0)
                 System.out.println(" *Page must be greater than 0..try again..");
             }while(number<0);
         } 
        catch (NumberFormatException ex) 
        {
            System.out.println("@Not a number !ERROR READKEY");
        } catch (IOException e) 
        {
           e.printStackTrace();
        }
        return number;

    }
   
}   
