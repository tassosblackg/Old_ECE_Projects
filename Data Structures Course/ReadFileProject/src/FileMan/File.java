/*
 * Author: ANASTASIOS KARAGEORGIADIS AM.:2013030135
 * A class that manages files,more specific insertion of data,search...etc.
 * method that contains:createF(),insertD(),printF(),printPd(),readFromU().
 * 
 */
package FileMan;


import java.io.RandomAccessFile;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**imports exceptions classes**/
import java.io.IOException;
import java.io.FileNotFoundException;
//---------------------------------**/
import java.util.Random;

/**
 *
 * @author soulis
 */
public class File {
   /****Constants*/
    final int M=100;//number of file's disk pages
    final int Psize=512;//size of disk page
    final int n=Psize/4; //number of integers in a page
    final int Min=1;//minimum limit of rage **create random numb**
    final int Max=130000;//maximum limit of rage--for random number generate--

    public static final int N_keys=20;//number of keys using the search method
   /*-------------------------------------------------------------------------------------------------------*/ 
    /*member variables*/
    private int key;
    private int Dpage;
    private final int[] buffer/*=new int[n]*/;
    private int overP;//in which page we can write the overflow
    
    public RandomAccessFile f;
    public BufferedReader br;
  //_________________________________________________________________
    
    /*Methods------------------------------------------*/
    //constructor
    public File(String name){
        //default
        //n=Psize/4;//number of integers in a page
        buffer=new int[n]; //buffer for reading n' writing keys to file
        br = new BufferedReader(new InputStreamReader(System.in));//create an object for reading
        buffer[n-2]=0;//a counter thats counts how many nums there are into the buffer-file
        buffer[n-1]=-1;//a num that shows if you have an overflow page and where is it
        overP=M;//set the overflow page
        //intialize
        createF(name);//create file
    }
    /****Getters n' Setters**/
    
    /**-------------------Other methods--------------------------------------------------------------*/
     /*@create a file--initialize-*/
     private void createF(String N){
        try
        {
             f=new RandomAccessFile(N,"rw");
             //write M=100 times an empty buffer to the file-to create the pages
             for(int j=0;j<M;j++)
             {    
               for(int i=0;i<n;i++)   
                f.writeInt(buffer[i]);
             }
             f.close();
        }
        catch(FileNotFoundException e){
            System.out.println("\n->File can not be Created!");
        }
        catch(IOException e)
        {
            System.out.println("\n->An error occured while trying to Intialize the file!");
        }
      }
     /*@insert Random data to file*/
     public void insertD(String N)
     {
       int[]buf=new int[n];//a buffer where we add the key, make the necessary changes and write it to the file
       
       int diskA=0;//how many disk accesses
       int m=0;//a counter which counts how many numbers have randInt returns  
       try
       {
          f=new RandomAccessFile(N,"rw");
          while(m<Max)//until generate and write Max keys
          {
              key=randInt(Min,Max);//generate a random key
              /*if(m<3)//print 3 keys to see
              *{System.out.println("/*key="+key+" *");}*/
            
              m++;//increase counter
              Dpage=h(key);//find the page where the key must be written
              /*System.out.println("\n*->|Dpage="+Dpage+"**|");*/
              boolean writen=false;//egine egrafh tou kleidiou?|den exei graftei akoma|
              /*these steps below must be repeated in case of overflow page*/
              while(writen==false)//do loop until the key has been writen into the file
              {
                 
                  f.seek(0);//bring file pointer at start of file
                  f.seek(Dpage*Psize);//move to the wanted position into the file
                  /*read data from this page*/
                  for(int i=0;i<n;i++)
                  {
                      buf[i]=f.readInt();//read an int from file
                      diskA++;//one read one disk access
                  }
                  /*|check where you can write(into the file) the new key|*/
                  if(buf[n-2]<126)//check if you can write to this page
                  {
                     buf[buf[n-2]]=key;//grafeis to kleidi sthn prwth dia8esimh 8esh tou buffer
                     buf[n-2]=buf[n-2]+1; //increase the counter about how many nums is in the page
                     f.seek(0);//metakinhsh deikth arxeiou sthn arxh
                     f.seek(Dpage*Psize);//metakinhsh deikth ekei pu 8eloume na gra4oume sto arxeio
                     /*write buffer into the file,in a specific page*/
                     for(int j=0;j<n;j++)
                     {
                         /*write integer key into the file*/
                         f.writeInt(buf[j]);
                         diskA++;//one write one disk access
                     }
                     writen=true;//key have been writen into the file
                    /*System.out.println("\n!!!@|KeyWriten_state="+writen+"!!!!/");*/
                  }
                  else if(buf[n-1]>-1)//des an yparxei overflow selida kai phgaine na 3anadiavaseis
                  {
                     Dpage=buf[n-1];//allazei h selida pu prepei na paw na gra4w to kleidi
                     writen=false;//key hasn't been writen to the file yet
                  }
                  else//den yparxei xwros gia egrafh kai den yparxei overflow selida|Ara dhmiourgw overflow selida|
                  {
                     writen=false;//key hasn't been writen to the file yet
                     f.seek(0);//epanafora deikth sthn arxh tou arxeiou
                     f.seek(overP*Psize);//metafora deikth sthn prwth dia8esimh overflow selida
                     /*arxikopoihsh ayths ths selidas*/
                     for(int i=0;i<n;i++)
                     {
                         /*write the empty buffer to overflow page*/
                         f.writeInt(buffer[i]);//buffer has been setted at the start of the programm
                         diskA++;//one write one disk access
                     }
                     Dpage=overP;//new page to seek an read and check if you can write
                     overP++;//epomenh dia8esimh oveflow selida|Dpage=overP++;|einai to idio|
                  
                  }
                  /*CHECK WRITE------------------if end--------------------------------------------------------------------*/
              }//do while-loop until the key has been writen into the file-|END WHILE _LOOP2|
              
          }//end main while-loop|while(m<Max)|
              
           System.out.println("\n->File has filled with "+Max+" numbers!\n");
           System.out.println(" |Disk Accesses during insertion= "+diskA+" accesses for writing all keys.!|\n");
          
          
       }
       catch(FileNotFoundException e)
       {
           System.out.println("\n->File can not be Found-Opened!");
       }
       catch(IOException e)
       {
           System.out.println("\n!Error during inserting data to file-insertD method-!/n");
       }
     }
     /*@seach data in a file*/
     public void searchD(String N){
        int[] buff=new int[n];//a buffer for saving the read, integers from file
        int[] keyS=new int[N_keys];
        int diskAcc=0;//counter for disk accesses
        try
        {
            f=new RandomAccessFile(N,"r");
            /*System.out.println("\n||Give me a key to search in the file:");
            key=readFromU();//take an int from user*///if you want to read from user a key
            /*search for N_keys random keys in the file*/
            for(int t=0;t<N_keys;t++)
            {
                diskAcc=0;
                key=randInt(Max/2,Max);//save some random keys to search for them
                Dpage=h(key);
                boolean found;
                /*these steps below must be repeated if we have overflow page*/
                do
               {
                   f.seek(0);
                   f.seek(Dpage*Psize);
                   //read page's data
                   for(int i=0;i<n;i++)
                   {
                       buff[i]=f.readInt();
                       diskAcc++;//katme read mia prosvash sto disko
                   }
                   //check if key match
                   found=false;
                   int k=0;//a counter
                   //oi dyo teleytaioi arithmoi ths selidas den einai kleidia opote den tous elenxoume
                   while((k<(n-2))&&(found==false))//an yparxoun akomh arithmoi sthn selida gia na 4a3ei kai den exei vtethei
                  {
                       if(buff[k]==key)
                       {
                          found=true;
                          System.out.println("\n**|Key="+key+" found at Page="+Dpage+"!*\n");
                          System.out.println("||Searching disk accesses....");
                          System.out.println(" |Disk accesses= "+diskAcc+" accesses !|");
                       }
                       else
                      {
                          found=false;
                          k++;
                      }
                  }
                  //if key haven't be found in a page
                  if(found==false)
                  {
                    
                     if(buff[n-1]>-1)//an yparxei overflow selida
                     {
                       System.out.println("\n|*Now searching at overflow page!....\n");
                       Dpage=buff[n-1];//epomenh selida anazhthshs h overflow selida
                     }
                     else
                     {
                        System.out.println("*Key="+key+" haven't been found!");
                     }
                  } 
                  //*******************************************************************************/
               }while((found==false)&&(buff[n-1]>-1));//an to kleidi den exei vrethei kai yparxei overflow selida
           }
            
            
            f.close();//close file
            System.out.println("->Search has finished..");
            
          }
          catch(FileNotFoundException e)
          {
              System.out.println("\n->Error during opening file-search method-");
          } 
        catch(IOException e)
        {
            System.out.println("\n-->ERROR DURING READING FILE-searchD method-!");
        }
        
        
     }
     
     
    
     /*@|find disck page to write or read data*/
     public int h(int key){
         return (key%M);
     }
     
     /*@print data of whole file*/
     public void printF(String N)
     {
         int[]a=new int [n];//a buffer for reading from file
         int p=0;//a counter fro file page's
         System.out.println("\n->|Printing whole file's data...\n");
         /*until last page of file*/
         while(p<M)
         {
             printPd(N,p,0);//take the page to print from printF() method
             p++;//increase p counter
         }
                          
     }
     
     /*@ |--printPd()--|print a page's data|-----------------------------------------------------------
     *PArametrs:
     *string N->filename
     *
     *st==1//shmainei oti h synarthsh diavazei apo thn consola th selida pu ektypwnei
     *st==0//shmainei oti pernietai san orisma h sleida pu 8eloume na ektypwsoume
     *p//page number to print if st==0 alliw p=0
     *
     */
     public void printPd(String N,int p,int st){
         //read for a page number 2 print its data
         int pageN=0;//page that is taken from user
         int[] b=new int[n];//a buffer for reading ints from a page of file
        /*read from console*/ 
        if(st==1)
        {
            /*check if pageN is an availiable number*/
            do
            {
           
              System.out.println("\n|Give the page number (possible values 0-99)");
              pageN=readFromU();
              if(pageN<0||pageN>99)
              System.out.println("\n -->Only values between 0-99 are acceptable.Plz try again!");
            }while(pageN<0||pageN>99);
        }
        else
        {
            pageN=p;//h selida pu 8eloume pernietai san orisma
        }
         try
         {
             f=new RandomAccessFile(N,"r");
             
             System.out.println("->|Printing "+pageN+" page's data...|\n");
             /*These steps below must be repeated for overflow pages*/
             boolean overflow=true;//estw oti yparxei kai overflow
             while(overflow==true)
             {
                 f.seek(0);//metakinhsh deikth sthn arxh tou arxeiou
                 f.seek(pageN*Psize);//metakinhsh deikth sthn zhtoumenh thesh
                 /*read page*/
                 for(int i=0;i<n;i++)
                 { 
                     /*read page's data*/
                     b[i]=f.readInt();//read from file an int
                 }
                 /*print page's data*/
                 for(int j=0;j<n;j++)
                 {
                     System.out.println(" *|Key("+j+")= "+b[j]);
                 }
                 /*an yparxei overflow selida sthn selida pu zhthsame*/
                 if(b[n-1]>-1)
                {
                   System.out.println(" ->|Printing "+pageN+" page's overflow page..|");
                   pageN=b[n-1];//nea selida pu 8a ektypw8ei
                   overflow=true;//yparxei overflow
                } 
                else//den yparxei overflow
                {
                     overflow=false;//sythikh termatismou while-loop
                }
                 
             }//end of while-loop for overflow
            
             
             System.out.println("\n->*Print page's data finished.../n");
         }
         catch(FileNotFoundException e)
         {
            System.out.println("\n**ERROR:File not Found--printPd method--!**");
         }
         catch(IOException e)
         {
             System.out.println("\n -->ERROR:while trying to read from file at printPd() method!");
         }
         
         
     }

     /*---|genarate random number|-----------------------------------------------*/
     public static int randInt(int min, int max) {

      // NOTE: Usually this should be a field rather than a method
     // variable so that it is not re-seeded every call.
      Random rand = new Random();

      // nextInt is normally exclusive of the top value,
     // so add 1 to make it inclusive
     int randomNum = rand.nextInt((max - min) + 1) + min;

      return randomNum;
     }
     /*-------------------------------------------------------------------------------------------------*/
     /*-----|@Read an integer|------------------------------------------------------------------------*/
     public int readFromU()
     {
        
         System.out.println(" |Give me a number(an integer):");
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
            System.out.println("Not a number !");
        } catch (IOException e) 
        {
           e.printStackTrace();
        }
        return number;
     }
     //------------------------------------------------------------------------*--------------------------------------------*
     
     /*--------------------------------------------------------------------------------------------------------------------------------*/
}
