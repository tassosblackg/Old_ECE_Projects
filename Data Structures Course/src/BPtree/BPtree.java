/*+--------------------------------------+
 *|Anastasios Karageorgiadis                            |
 *|Am.:2013030135                                     |
 *|LabTeam: LAB21124955                             |                                            
 *|Project2o DATA structures                         _|                           
 *|_______________________________________|
 *
 *VAsikh klassh pu ta ylopoiei ola
 *
 * Edw vriskontai oi methodoi ths eisagwghs, anazhthshs(kai me tus dyo tropous),kai diagrafhs
 * Diagrafh: de douleyei teliws swsta...px.8ewroume oti to kleidi pu 8eloume na svhsume vrisketai kai ston patera
 *alla yparxei oloklhros o algorithmos mesa sthn methodo opote mporeite na deite pws douleuei
 * epsihs sthn methodo searchKinN pu thn xrhsimopoioume gt anzhthsh tu kleidiou pou 8eloume na svhsoume ston patera
 *den elenxoume thn periptwsh pu to kleidi den yparxei...
 *aytes oi ateleies yparxoun logo elei4hs xronou gia peraiterw enasxolhsh....logw e3etastikhs..
 */
package BPtree;


import java.util.Random;
import java.io.ObjectInputStream;//objectreadnwrite,randomaccess
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author soulis
 */
public class BPtree {
   public static final String fileName="BPtree.dat";
   public static final int N=107;//arithmos kleidiwn pu mporoun na grafoun se ena komvo..maximum
   public static final int pageSize =1024;//megethos selidas diskou
   public static final int m=0;//data's size in file...
   private final int min=1;
   private final int max=100000;
   private int NumbOfInAcc=0;//how many Accesses made during insertion
   private int Sacc=0;//accesses during searching a key
   private int NofNodes=0;//numb of created nodes 
   private int DelAcc=0;//accesses of deletion
   private BPnode snode;//1st node
   /*Constructor*/
   public BPtree(){
       snode=new BPnode(N);
   }
   
   /*-------other methods--------------------------------------------------------------------------------------------------------------*/
   
   /*@|insert data|N keys in a tree node*/
   public void insert(){
       System.out.println("Start of insert()..**\n ");
       int[] b=new int[max];
       orderArray(b);//call function that create an N elements ordered array
       //diadikasia eisagwghs
       int indx=0;
       for(int i=(b.length-1);i>=0;i--)
       {//anapodh prospelash pinaka
           
           this.insertKey(b[i], indx);
           indx++;
       }
       
       System.out.println("======================================================== ");
       System.out.println("||*Insertion of N= "+b.length+"keys, has finished....");
/*       System.out.println(" |These are some keys:\n A[5]="+b[5]+" ,A[23]= "+b[23]+" A[58]="+b[58]+" A[130]="+b[230]+
               " A[250]="+b[250]+" A[423]= "+b[423]+ "A[1000]"+b[1000]+" A[2200]"+b[2200]+" A[10200]"+b[10200]+" A[15000]"+b[15000]
               +" A[15800]="+b[15800]+" A[31000]="+b[31000]+" A[45000]= "+b[45000]+" A[56123]= "+b[56123] 
               +" A[62331]="+b[62331]+" A[76345]="+b[76345]+".....\n******");*/
       System.out.println("\n |DiskAccesses(according read n'write)= "+NumbOfInAcc+"|.. ");
       System.out.println("____________________________________________________________");
       this.Sacc=0;//when function finished reset counter--so when go for search to count all over again...
       System.out.println("End of insert()..**\n ");
   }
  //*--------------------------------------------------------------------------------------------------------------------*/
   
   /*@|insert| a key*/
   public void insertKey(int key,int indx){
     BPnode node=new BPnode(N);
     if(indx<N)
     {
         System.out.println("*indx<N*\n ");
         snode.insertKey(key, N-1-indx);//eisagw to kleidi--
         snode.setNofKeys(snode.getNumOfkeys()+1);//ay3anw ton ari8mo twn kleidiwn
         //set pointers
         snode.setDatPointers(-1, indx);
     }
     else if(indx==N)
     {
         
         //set last ppointer
         snode.setDatPointers(-1, N);
         this.NofNodes=1;
         //snode.printNode();//print data of node
        
        //1o split
         this.splitNode(snode, NofNodes);
         //read node
         node=this.readSerialObj(0);//diavase root
         this.NumbOfInAcc++;//aykshse tiw prosvaseis kata mia
         //node.printNode();//ektypwse ta dedomena tu komvou pu diavases
         
         //4a3e to komvo pu 8a eisageis to kleidi
         int[] pos=new int[1];//position of the node
         this.Sacc=0;//mhdenise tis prosvaseis anazhthshs--prin kaneis anazhthsh
         node=this.search4node(node, key, pos);
         this.NumbOfInAcc=this.NumbOfInAcc+this.Sacc;//accesses mazi me aytes ths anazhthshs komvou
        
        //eisagwgh kleidiou ston komvo
         node.insertKey(key, (N-1-node.getNumOfkeys()));
         node.setNofKeys(node.getNumOfkeys()+1);
        //gra4e ton komvo sto arxeio
         System.out.println("position write="+pos[0]);
         this.writeSerialObj(node, pos[0]);//gra4e to node sthn 8esh pos[0] tou arxeiou
         this.NumbOfInAcc++;//ay3hse tis prosvaseis kata mia
         /*System.out.println("~~~!node after insert N key ");
         BPnode k=new BPnode(N);
         k=this.readSerialObj(pos[0]);
         k.printNode();*/
         
     }
     else//peran tou prwtou split eisagwgh stoixeiwn--genika--
     {
           //diavase to root node
           node=this.readSerialObj(0);
           this.NumbOfInAcc++;//ay3hse ths prosvaseis kata mia
           //4a3e gia ton komvo pu 8a eisagei to kleidi
           int[] p=new int[1];//node position
           this.Sacc=0;//mhdenise tis prosvaseis anazhthshs
           node=this.search4node(node, key, p);
           this.NumbOfInAcc=this.NumbOfInAcc+this.Sacc;//mazi me tis prosvaseis kata thn anazhthsh
           //eisagwgh kleidiou/**???
           node.insertKey(key, (N-1-node.getNumOfkeys()));
           //ay3anw ton ari8mo kleidiwn tu komvou-kata 1--
           node.setNofKeys(node.getNumOfkeys()+1);
           //check if split()?
           if(node.getNumOfkeys()==N)
           {
               //kata to split h eggrafh twn kainourgivn komvwn sto arxeio ginetai
               //entos ths methodou splitNode()....
               this.splitNode(node, this.NofNodes);//split the node--n' write to file
           }
           else//if not split write node 2 file
           {
               //eggrafh sto arxeio
               this.writeSerialObj(node, p[0]);//eggrafh komvou sthn 8esh p[0] sthn opoia eixe vrethei o komvos...
               //ay3hsh twn prosvasewn kata ena
               this.NumbOfInAcc++;
           }
     }
     this.Sacc=0;//reset ton ari8mo twn prosvasewn kata thn anazhthsh
     
    
   }
  //-------------------------------------------------------------------------------------------------------
   
   /*@|Split| nodes method
   *@parameter1-->obj of class BPnode,and it's the node we want to split
   *@parameter2-->a counter of how many nodes we've got,in the file..
   *@*/
   public void splitNode(BPnode node,int NofNodes)
   {
       /*System.out.println(" SPLIT>>PRINT*\n");
       node.printNode();*/
       
       BPnode node1=new BPnode(N);
       BPnode node2 =new BPnode(N);
       BPnode pnode=new BPnode(N);//pateras komvos
      //  int Node=0;//a counter whitch turns on "1", if node for split isRoot(),and at the end NofNodes=NofNodes+Node;
       
        
       if(node.isLeaf() || NofNodes==1)
       {                             
             if(node.isLeaf())
             {
                pnode=this.readSerialObj( node.getParent());//diavase kai fwrtwse ton patera tu fylou pu 8a kaneis split
                this.NumbOfInAcc++;
                pnode.insertKey(node.getkeys(N/2), (N-1-pnode.getNumOfkeys()) );//gra4e to kleidi
                pnode.setNofKeys(pnode.getNumOfkeys()+1);//increase number of keys in node
                //set parent node
              node1.setParent(node.getParent());
              node2.setParent(node.getParent());
             }  
             else//if it's the first node it;s doesn't have parent..
             {
              // System.out.println(" messaio kleidi");
              // System.out.println(" kleidi N/2="+node.getkeys(N/2));
               pnode.insertKey(node.getkeys(N/2),(N-1) );//eisagwgh sthn teleytaia 8esh tu pinaka
              // System.out.println(" parent key="+pnode.getkeys(N-1));
               pnode.setNofKeys(pnode.getNumOfkeys()+1);//increase number of keys in parent node
               //System.out.println(" @@@@@@@@@@@@@@");
           //System.out.println(" @ PARENT");
          // pnode.printNode();
               //set parent to children
               node1.setParent(0);
               node2.setParent(0);
               //set pointers
               for(int j=0;j<=N;j++)
                   pnode.setDatPointers(-1, j);
             
             }
           //take n' copy keys from node you split--|i can do it this a function copyFunc|---
             
           for(int i=0;i<N;i++)
           {
               if(i<N/2)
               {//???????
                   node1.insertKey(node.getkeys((N/2)-1-i),(N-1-i) );//take down-half keys of node
                   node1.setNofKeys(node1.getNumOfkeys()+1);//increase numb of keys
                }
               else
               {
                   //take, "up-half" keys of node include  the key that went to the parent
                   node2.insertKey(node.getkeys(i), i-N/2);
                   node2.setNofKeys(node2.getNumOfkeys()+1);//increase numb of keys
               }
               
               //set data--if we have data---
               if(m!=0)//if leaf has data
               {
                   //get data
                   if(i<N/2)
                   {
                       node1.setDatPointers(node.getDatPnt((N/2)-1-i), (N-1-i));
                   }
                   else
                   {
                        if(i==N/2)
                        {//set last pointer in node1
                           node1.setDatPointers(node.getDatPnt(i), N);
                        }
                        //set node2 pointers
                        node2.setDatPointers(node.getDatPnt(i), i-N/2);
                
                        if(i==node.getNumOfkeys()-1)//set last pointer in node2
                        {
                           node2.setDatPointers(node.getDatPnt(node.getNumOfkeys()), node2.getNumOfkeys());
                        }
                   }
               }
               else//if m==0--we don't have data
               {
                    //set pointers to <<"null">>--initialize pointer afu einai fylo
                   //sets all pointers except one--the last one, 'cause we have a loop untill node.getNofKeys()..
                    node1.setDatPointers(-1, i);
                    node2.setDatPointers(-1, i);
                    if(i==node.getNumOfkeys()-1)//last key index
                    {
                        //set the last pointer 
                        node1.setDatPointers(-1, N);
                        node2.setDatPointers(-1, N);
                    }
               }
              //**************/end of set data OR pointers block\***************************************************************           
            
        }//end for
           
      
         this.NofNodes=this.NofNodes+1;//increase number of nodes,one node will be override the old one --ayton pu egine split
         //System.out.println(" NOFN="+this.NofNodes);
         //set siblings
          node1.setRBro(this.NofNodes);
          node1.setLBro(-1);//thewrwntas oti to kleidi pu eisagoume vrisketai sthn poio aristerh 8esh
          node2.setLBro(this.NofNodes-1);
          //an yparxoun parapanw apo 1 kleidia sto komvo,hparxoun kai ta antistoixa paidia gia syndeseis
          //alliws einai teleytaio paidi de3ia kai de exei kapoio allo paidi-fylo gia 8eseis st RightBrother
               // System.out.println(" @@@@nofk="+pnode.getNumOfkeys());
           if(pnode.getNumOfkeys()>1)
            { 
                node2.setRBro(pnode.getDatPnt(N-1-pnode.getNumOfkeys() +2 ) );
            }
            else
            {
                node2.setRBro(-1);   
            }          
          /* System.out.println(" @@@@@@@@@@@@@@");
           System.out.println(" @ BRothers");
           System.out.println(" NODE1 RB"+node1.getRBro()+"\nLB="+node1.getLBro());
           System.out.println(" NODE@2 RB="+node2.getRBro()+"\nLB="+node2.getLBro());
           
                   System.out.println(" @@@@@@@@@@@@@@");*/
          
      }
      else //if is internal node the same way split
       {
           //System.out.println(" ######");
           //pnode.printNode();
           //System.out.println(" 33333333");
           
           if(node.isRoot())
           {
              //BPnode nroot=new BPnode(N);
              pnode.insertKey(node.getkeys(N/2), N-1);//insert the middle key of node to new root
              pnode.setParent(-1);//it's root
              pnode.setNofKeys(1);//one key has been added
              //Node++;//one more node
              //set parent node,for children
              //parent is a new root so parent =0
              node1.setParent(0);
              node2.setParent(0);
              
              //write the new root to file
           } 
           else//is internal node
           {
                //read father node
               System.out.println("#parent= "+node.getParent()+" **");
                pnode= this.readSerialObj( node.getParent());//diavase kai fwrtwse ton patera tu fylou pu 8a kaneis split
               this.NumbOfInAcc++;
               pnode.insertKey(node.getkeys(N/2),(N-1-pnode.getNumOfkeys()) );
          
               pnode.setNofKeys(pnode.getNumOfkeys()+1);//increase number of keys in parent node
               
                //set parent node
                node1.setParent(node.getParent());
                node2.setParent(node.getParent());
           }
           this.NofNodes=this.NofNodes+1;//increase number of nodes,one node will be override the old one --ayton pu egine split
           //for loop like before--copy node's keys to new children
           for(int i=0;i<node.getNumOfkeys();i++)
           {
                if(i<N/2)
               {
                   node1.insertKey(node.getkeys(N/2-1-i),(N-1-i) );//take the down-half keys of node
                   node1.setNofKeys(node1.getNumOfkeys()+1);//increase number of keys
                   //copy n'the pointers
                    //pointers
                   node1.setDatPointers(node.getDatPnt( (N/2)-1-i),(N-1-i) );
                   
               }
                else
                {
                    if(i>N/2)
                        node2.insertKey(node.getkeys(i),i-1-N/2);//take keys from the up-half of node without the key that went to parent
                        node2.setNofKeys( (node2.getNumOfkeys()+1) );//increase number of keys
                        //copy n' the pointers
                        //pointers
                        node2.setDatPointers(node.getDatPnt(i), i-N/2);
                }
           }
           //set last pointers..sta dyo paidia....????
           node1.setDatPointers(node.getDatPnt(N/2), N);
           node2.setDatPointers(node.getDatPnt(N), node2.getNumOfkeys());                 
       }
                       
       //set children to parent??????
       //ayto koino se oles tis periptwseis
       pnode.setDatPointers(this.NofNodes-1, (N-1- (pnode.getNumOfkeys()-1) ) );//left kid
       pnode.setDatPointers(this.NofNodes, (N- (pnode.getNumOfkeys()-1) ) );//right kid
       //set nuber of keys at 
       
       
     System.out.println(" @@SPLIT BEFORE WRITE PARENT!@@");
       
      /* pnode.printNode();
       System.out.println(" SPLIT BEFORE WRITE child1");
       node1.printNode();
       System.out.println(" SPLIT BEFORE WRITE child2");
       node2.printNode();
       System.out.println(" ????????????????????????????");
       System.out.println("  PARENT="+node1.getParent());
       System.out.println(" $$$$$$$$$$$$$$$$$$$$$$$$$$$$\n&");*/
       //|WRITE changed nodes to file
       //parent
       this.writeSerialObj(pnode, node1.getParent());
       //child1
       this.writeSerialObj(node1, pnode.getDatPnt((N-1- (pnode.getNumOfkeys()-1) )));//write left kid
       //child2
       this.writeSerialObj(node2, pnode.getDatPnt( N- (pnode.getNumOfkeys()-1) ) );//write right kid
       this.NumbOfInAcc=this.NumbOfInAcc+3;//prosvaseis sto disko
      /* System.out.println("%%% readNPrint%%%%position="+pnode.getDatPnt((N-1- (pnode.getNumOfkeys()-1) )) );
       BPnode n=new BPnode(N);
       n=this.readSerialObj(pnode.getDatPnt((N-1- (pnode.getNumOfkeys()-1) )));
       n.printNode();
       System.out.println(" ^^^^^^^^^^^");*/
       
       //anadromikh klish se periptwsh pu exei gemisei o pateras
       //chech if father node pnode must be splitted?
       if(pnode.getNumOfkeys()==N)//o komvos gemise
         splitNode(pnode,this.NofNodes);
       
   }
  //```````````````````````````````````````````````````````````````````````````````````````````````````````````````
   
   /*@|SEARCH4NODE|method, for searching the node(during insertion) where the key must be inserted*/
   public BPnode search4node(BPnode node,int key,int[]b){
       b[0]=-1;//position
      // System.out.println("SN* node is leaf?="+node.isLeaf()+"KEY= "+key);
      // node.printNode();
       while(node.isLeaf()!=true)
       {
          int i=0;//counter for node's keys
          boolean found=false;//if found or not the node
         
          while( (found==false) && (i<N) )//ola takleidia enos komvou elenxontai
          {
                   
               
                   if(key<node.getkeys(i))//check from which child of node must be, the key you want to insert 
                    {
                          found=true;                          
                           b[0]=node.getDatPnt(i);
                           node=this.readSerialObj(node.getDatPnt(i));
                           this.Sacc++;//prosvaseis anazhthshs
                           
                    }
                    else if( (i==(N-1)) || (key==node.getkeys(i)) )//an exeis ftasei sto teleytaio kleidi,kai to key den einai mikrotero tu kleidiou tu komvou s'ayto to shmeio
                    {//h an to kleidi pu 4axneis einai iso me to kleidi tu komvou
                          
                           node=this.readSerialObj( node.getDatPnt(i+1));
                           this.Sacc++;//prosvaseis anazhthshs
                           b[0]=node.getDatPnt(i+1);
                           found=true;
                     }
                    else//an den exei vrei akoma to komvo tu kleidiou kai den exei prospelasei ta kleidia ola
                    {
                      i++;
                     
                     }
               
          } 
           
        }//end while
       return node;
   }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   
   /*@|SEARCH for a key method|*/
   public void search4key(int key){
       
       this.Sacc=0;//mhdenise tis prosvaseis prin 3ekinhseis
       BPnode node=new BPnode(N);
       //read root**1 access
       node=this.readSerialObj( 0);//3ekina apo to root
       this.Sacc++;
       //search for node, where the key may be
       int[]  pos=new int[1];//position of this node
       node=this.search4node(node, key, pos);
       //check if the key is inside
       int i=0;
       boolean found=false;
       while((found==false)&&(i<N) )
       {
           if(key==node.getkeys(i))
           {
               found=true;
               
           }
           else
           {
               found=false;
               i++;
           }
       }
       if(found)
       {
           System.out.println("||Search was successfully ");
           System.out.println(" |*Key has found...KEY= "+key+"found at this position"+pos[0]);
           System.out.println(" |->Accesses="+Sacc+" acording how many reading it made..");
           System.out.println(" - - - - - - - - - - - --  - - -- - - - - - - - - - - -- - - - -  ");
       }
       else
       {
           System.out.println("||Searching has finished........ ");
           System.out.println(" |*Key doesn't found..the key was(KEY= "+key+").!");
           System.out.println(" |->Accesses="+Sacc+" acording how many reading it made..");
           System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -  -  - -  ");
       }
       
       
   }
  //===============================================================================================================
   
   /*@|Search for keys in a RAGE| method*/
   public void searchRageKeys(int downLimit,int upLimit){
       System.out.println(" |Now searching for rage...");
       this.Sacc=0;//mhdenise tis prosvaseis prin 3ekinhseis
       BPnode node=new BPnode(N);
       node=this.readSerialObj( 0);//search from root node
       this.Sacc++;
       //call search4node to find the leaf node
       int[] p=new int[1];//position where the node found
       node=this.search4node(node, downLimit, p);
      
       int i=0;
       int [] Array=new int[upLimit-downLimit+2];//rage of keys you can find
       boolean dlFound=false;
       int indx=0;
       int l=0;
       System.out.println(" |#search for rage...");
       
       //vres to kleidi pu einai pio konta sto katw orio
       while((dlFound!=true)&&(indx<N))
       {
           if( (node.getkeys(indx)>=downLimit)&&(node.getkeys(indx)<=upLimit) )
           {
               dlFound=true;
               l=indx;//krata thn 8esh pu to vrhkes
               break;//molis to vreis stamata
           }
           else if((node.getRBro()!=-1)&&(indx==N))//to kleidi den vrethike ston komvo pu 8ewrtika 8a eprepe na vrisketai opote proxwra sta aderfia de3ia
           {
               dlFound=false;
               node=this.readSerialObj(node.getRBro());//fortwse aderfo
               this.Sacc++;//ay3hse tis prosvaseis
               indx=0;//
           }
           else//to kleidi de vrethike oute sta aderfia ara den yparxoun kleidia sto evros pu zhthsame
           {
               dlFound=false;
               indx++;
               //break;//den exei nohma na synexiseis na 4axneis
           }
           
       }
       if(dlFound==true)//an ypaxoun kleidia se ayto to evros
           
       {
           System.out.println(" dwL="+node.getkeys(l)+" l="+l+" RBr="+node.getRBro());
             int k=0;//index for array where store keys of rage
             boolean upFound=false;
             boolean noBr=false;
             while((upFound!=true)&&(noBr!=true) )
             {
                 while( (l<N)&&(upFound!=true) )
                 {
                      if(node.getkeys(l)>upLimit)
                     {
                         upFound=true;
                         break;
                     }
                     else
                      {
                           if(node.getkeys(l)>0)
                           {
                                 Array[k]=node.getkeys(l);
                                  k++;
                           }
                      
                     l++;
                     }
                 }
                 if( (l==N) && (node.getRBro()!=-1)&&(upFound!=true))
                 {
                     node=this.readSerialObj(node.getRBro());
                     l=0;
                 }
                 else if( (l==N)&&(node.getRBro()==-1)&&(upFound!=true))
                 {
                     noBr=true;
                 }
             }
            //print
             System.out.println("||Search by keys in a range [ "+downLimit+" "+upLimit+"] has finished...here are the results..");
           for(int j=0;j<=k;j++)
           { 
               System.out.println(" |Key[ "+j+"]="+Array[j] );
           }
           System.out.println(" ............................................................................");
           System.out.println(" \n*|->Accesses="+Sacc+"acording how many reading it made..");
           System.out.println(" ______________________________________________________");
       }
       else//den ypaxoun kleidia se ayto to evros
       {
            System.out.println("||Search by keys in a range [ "+downLimit+" "+upLimit+"] has finished...here are the results..");
           System.out.println(" |There aren't any keys in this rage, in the tree!Sorry...");
           System.out.println(" ______________________________________________________");
       }
            
       //this.Sacc=0;//reset counter of search accesses*/
   }
  //----------------------------------------------------------------------------------------------------------
   
   /*@|Order| an array (of random ints) of ints--Auksousa taksinomhsh--
   **taksinomhsh tu pinaka pu periexei ta tyxai kleidia pu 8eloume na eisagoume
   **wste na bainoun swsta sto dentro--dieykolinei thn eisagwgh--*
   **vevaia den einai kai poly apodotiko an exeis polous ari8mous--polys xwros sthn mnhmh--
   **alla sth sygkekrimenh askhsh ta kleidia mas exoun mege8os 400kb...ola mazi
   */
   public void orderArray(int[] a){
       
       int value,i=0;
      // while(i<max){
        //value=randInt(min,max);
          /*eksasfalizoume oti ta kleidia einai diaforetika*/
               this.getRandomNonrepeat(a,min, max);
              // i++;
           
      // }
         
       Arrays.sort(a);
          
   }
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
       
    /*@---|genarate random number|-----------------------------------------------*/
     public static int randInt(int min, int max) {

      // NOTE: Usually this should be a field rather than a method
     // variable so that it is not re-seeded every call.
      Random rand = new Random();

      // nextInt is normally exclusive of the top value,
     // so add 1 to make it inclusive
     int randomNum = rand.nextInt((max - min) + 1) + min;

      return randomNum;
     }
    //-----------------------------------------------------------------------------
     
     /*@-----------------|get a unique random number|--------------------------------------*/
     public void/*int[]*/ getRandomNonrepeat(int[]random,int iMin, int iMax)
     {
               int iSize = iMax - iMin + 1;
              //int[] random = new int[iSize];
               int iLoopRepetion=0;
               Random rand = new Random();
               for(int i=0;i<iSize;i++)
               {
                    random[i]=rand.nextInt(iSize)+rand.nextInt((iMax-iMin)/2);
                    for(iLoopRepetion=0;iLoopRepetion<i;iLoopRepetion++)
                      if(random[i]==random[iLoopRepetion])
                        break;
                   if(iLoopRepetion!=(i)&&iLoopRepetion!=iSize-1)
                    i--;
              }
          //return random;
      }
     /*......................................................................................................*/
     
     /*@delete a key*/
     public void deleteKey(int key)
     {
             System.out.println("||Delete method starts.....(BPtree calss)...\n ");
             this.DelAcc=0;
             BPnode node=new BPnode(N);
              node=this.readSerialObj(0);
              int[]pos=new int[1];
              node=this.search4node(node,key,pos);
              this.DelAcc=this.DelAcc+this.Sacc;//prosthese tis prosvaseis kata thn anazhthsh
              int i=0;
              boolean found =false;
              int Fpos=0;
              //4a3e gia to kleidi
             while( (i<node.getNumOfkeys() )&&(found==false) )
             {
     
                    if(key==node.getkeys(i))
                    {
                        found=true;
                        Fpos=i;
                    }
                    else
                    {
                     i++;
                     }
              }

             if(found)
              {
                    //diagrafeis to kleidi vazontas sthn 8esh tu to 0 kai meiwnontas ton ari8mo twn kleidiwn sto komvo
                    node.setkey(0,Fpos);
                    node.setNofKeys(node.getNumOfkeys()-1);
                    boolean ok=false;
                    //epanalh4h   
                    if(node.getNumOfkeys()<N/2)//node is too empty
                     {
                           //diavase ton patera
                           BPnode p=new BPnode(N);//parent
                           p=this.readSerialObj(node.getParent());
                           this.DelAcc++;
                           int ind;
                           ind=this.searchKinN(p, node.getkeys(N-node.getNumOfkeys()));//vres thn 8esh ston patera pu vrisketai to kleidi
                          //check for siblings
                          if(node.getLBro()!=-1)
                           {
                                //load LeftBro
                                BPnode Ln=new BPnode(N);//left node
                                Ln=this.readSerialObj(node.getLBro());
                                this.DelAcc++;
                                if(Ln.getNumOfkeys()>N/2)//Borrow
                                {
                                      //shift one position the keys of node
                                      for(int j=Fpos; j>=1; j--)
                                      {
                                            node.setkey(node.getkeys(j-1),j);
                                             node.setDatPointers(node.getDatPnt(j-1), j);//shift pointers
                                       }  
                                     
                                                                         
                                      p.setkey(Ln.getkeys(N-1),ind );//gra4e to teleytaio paidi tu aristerou paidiou ston patera
                                      node.setkey(Ln.getkeys(N-1), node.getkeys(N-1-node.getNumOfkeys()));//gra4e to idio kleidi kai ston komvo pu egine h diagrafh
                                      node.setNofKeys(node.getNumOfkeys()+1);//ay3hse ta kleidia sto komvo pu diegra4es to kleidi
                                      //shift ston aristero geitona pros ta de3ia
                                      for(int t=N-1;t>=1;t--)
                                      {
                                          Ln.setkey(Ln.getkeys(t-1), t);//aristera->de3ia ta kleidia
                                      }
                                      //to idio kai gia tus deiktes
                                      for(int e=N;e>=1;e--)
                                      {
                                          Ln.setDatPointers(Ln.getDatPnt(e-1), e);
                                         
                                      }
                                      //write changed nodes to file
                                      this.writeSerialObj(node, p.getDatPnt(ind));
                                      this.writeSerialObj(Ln, p.getDatPnt(ind+1));
                                      this.DelAcc=this.DelAcc+2;
                                 }
                           
                                 else //merge
                                 {
             
                                        BPnode n=new BPnode(N);
                                        for(int k=0; k<Ln.getNumOfkeys();k++)
                                        {
                                             n.setkey(Ln.getkeys(k),k);
                                        }
                                        for(int l=0;l<node.getNumOfkeys();l++)
                                         {
                                             n.setkey(node.getkeys(l),Ln.getNumOfkeys()+l);
                                        }
                                        p.setkey(n.getkeys(0), ind);
                                        this.writeSerialObj(n, p.getDatPnt(ind+1));//write new node in file
                                        this.DelAcc++;
                                  }

                           }
                          else if(node.getRBro()!=-1)
                          {

                                 //load RightBro
                                 BPnode Rn=new BPnode(N);//left node
                                  Rn=this.readSerialObj(node.getLBro());
                                  this.DelAcc++;
                                  if(Rn.getNumOfkeys()>N/2)//Borrow
                                  {
                                        for(int a=N-1;a>Fpos;a--)
                                        {
                                            node.setkey(node.getkeys(a-1), a);//shift keys of node to right
                                            
                                        }
                                        for(int q=N;q>Fpos;q--)
                                        {
                                            node.setDatPointers(node.getDatPnt(q-1), q);//shift pointers
                                        }
                                        node.setkey(Rn.getkeys(0), N-1);//pare to 1o kleidi apo to de3h geitona k valto ston komvo
                                        p.setkey(Rn.getkeys(1), ind);//gra4e to epomeno kleidi tu de3h geitona ston patera
                                        //shift left keys n' pointers of rightNode
                                        for(int h=1;h<N;h++)
                                        {
                                            Rn.setkey(Rn.getkeys(h), h-1);
                                        }
                                        for(int w=1;w<=N;w++)
                                        {
                                            Rn.setDatPointers(Rn.getDatPnt(w), w-1);
                                        }
                                        this.writeSerialObj(node, p.getDatPnt(ind));//wtite changes nodes to file
                                        this.writeSerialObj(Rn, p.getDatPnt(ind+1));
                                        this.DelAcc=this.DelAcc+2;
                                  }
                                 else //merge
                                  {
                                       BPnode n=new BPnode(N);
                                       for(int k=0; k<Rn.getNumOfkeys();k++)
                                       {
                                              n.setkey(Rn.getkeys(k),k);
                                        }
                                        for(int l=0;l<node.getNumOfkeys();l++)
                                        {
                                             n.setkey(node.getkeys(l),Rn.getNumOfkeys()+l);
                                        }
                                        p.setkey(n.getkeys(0), ind);
                                        this.writeSerialObj(n, p.getDatPnt(ind+1));//write new node in file
                                        this.DelAcc++;
                                  }

           
                           }
                    }
                    //print
                    System.out.println("||Key deleted... ");
                    System.out.println(" |Number of access="+this.DelAcc+" according reads n' write to the file.");
     
              }
              else
              {
                    System.out.println("|*Key = "+key+"that you want to delete doesn't exist!");
              }
             System.out.println("-------------------------------------------------------------------------");
     }
    //---------------------------------------------------------------------------
   public int searchKinN(BPnode node,int key)
   {
       int p=0;
       int numb=0;
       boolean fnd=false;
       while((p<N)&&(fnd!=true))
       {
           if(key==node.getkeys(p))
           {
               fnd=true;
               numb=p;
               break;
           }
           else
           {
               p++;
               fnd=false;
           }
       }
       return numb;
   }


     /*@write to file*/
     public void writeSerialObj(BPnode node,int position){
         try{
               ByteArrayOutputStream bos = new ByteArrayOutputStream(pageSize) ;
               ObjectOutputStream out = new ObjectOutputStream(bos);
               out.writeObject(node);
               out.close();
               
                // Get the bytes of the serialized object
	     byte[] DataPage = new byte[pageSize];
               byte[] buf = bos.toByteArray(); // Creates a newly allocated byte array.
               System.arraycopy( buf, 0, DataPage, 0, buf.length); // Copy buf data to DataPage of DataPageSize
               
               // write to the file
               RandomAccessFile MyFile = new RandomAccessFile (fileName,"rw");
               MyFile.seek(position*pageSize);
               MyFile.write(DataPage); // write DataPageSize bytes
               
               //System.out.println("=======================");
               MyFile.close();
               
         
          
         }
          catch(FileNotFoundException e)
         {
             System.out.println("** WRITEobj filenotfound!");   
         }
          catch(IOException e)
         {
           System.out.println("**WRITEobj ioexception! ");   
         }
        
         
     }
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  
     /*@read from file*/
     public BPnode readSerialObj(int pos){
         // Read from file
         BPnode deserializedObject = null;
         try{
                    //System.out.println(" position2read="+pos);
                    RandomAccessFile MyFile = new RandomAccessFile (fileName, "r");
	       byte[] buf = new byte[pageSize];
	       MyFile.seek(pos*pageSize);
	       MyFile.read(buf);
	       
	       // DeserializeObject
	       ByteArrayInputStream bis = new ByteArrayInputStream(buf);
	       ObjectInputStream ois = new ObjectInputStream(bis);
	       deserializedObject = (BPnode)ois.readObject();
	       ois.close();
               
               
         }
         catch(ClassNotFoundException e)
         {
             System.out.println("*READOBJ method CLassNotFoundEX!\n ");
         }
         catch(IOException e)
         {
             System.out.println(" *REadobj IOException!");
             
         }
         if(deserializedObject==null)
            System.out.println(" |ERRROR WHILE READING OBJECT!\n");
         return deserializedObject;
     }
    //...............................................................................................................................................
     
     /*@print node's data*/
     public void printAnode(int position){
         BPnode n=new BPnode(N);
         System.out.println("||Printing node's data..... ");
         if((position>=0)&&(position<=this.NofNodes) )
         {
             n=this.readSerialObj(position);//fortwneis ton komvo apo thn selida
             n.printNode();
         }
         else
         {
             System.out.println(" |Page="+position+" doesn't exist!");
         }
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
     }
     
}
//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/-END OF CLASS-\/\/\///\\\//\/\//\/\/\/\/\\/\/\/\/\///\/////\/////////////////////////////////////