/*
  BTS insert,search benchmarks runs
  use positive numbers from 1 till maxUpBound
  or read integers from file
  Notice: development done by using openjdk 15.0.2 2021-01-19 (aka java version 15)
   which includes enhanced for loop types, switch cases with '->'

 */
//import BST.;
import java.io.*;
import java.util.*;



public class Main {
    /** member variables**/
    private static final Random RANDOM=new Random(); // random object
    private static final int N = 10000;//10^5 key records
    private static final int maxUpBound = 1000000; // max upper bound number to generate from random func
    private static final int maxKeys2Search = 100; // search for 100 keys
    private static final int K2a = 100; // case 1 up bound to add to K1, for range[K1,K1+K2]
    private static final int K2b = 1000; // case 2
    private  int countBinSearch = 0; //total counter for binSearch
    private  int countLowerBoundIfs = 0;
    private  int countUpperBoundIfs = 0;
    private BST MyBSt;

    /**
     * Main class constructor
     */
    public Main() {
        MyBSt = new BST(N);
    }



    /**
     * ----------- pickRandom()-----------------------
     * Pick n numbers between 1 (inclusive) and k (inclusive)
     * @param n how many numbers in a range you want
     * @param k the upper bound of int numbers
     * @return a unique set of integers numbers
     */
    public Set<Integer> pickRandom(int n, int k) {
        int floorLim = 1;
        int seeder = k+1-floorLim;
        final Set<Integer> picked = new HashSet<>();
        while (picked.size() < n) {
            picked.add(RANDOM.nextInt(seeder) + floorLim );
        }
        return picked;
    }

    /**
     * readBIn --readBinaryInput read a .bin file and get integers
     * @param filePath2read a string path-filename to read integer values
     * @return  an array of ints with all keys to be inserted
     */
    public int[] readBIn(String filePath2read)  {

        List<Integer> readKeys = new ArrayList<Integer>();

        try {
            System.out.println(filePath2read);
            DataInputStream in = new DataInputStream(new FileInputStream(filePath2read));
            while (true) {
                //System.out.println(in.readInt());
                readKeys.add(in.readInt());
            }


        }catch (EOFException ignored) {
            //in.close();
            System.out.println("[EOF]");
        } catch (FileNotFoundException e){
            System.out.println("\n ERROR : your file name/path to be read is not a valid one.File NOT FOUND!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readKeys.stream().mapToInt(Integer::intValue).toArray();

    }

    /**
     * readIntFromU () read an integer from user input
     * @return a number integer corresponding to the num-choice for menu
     */
    public int readIntFromU()
    {
        String input;
        int number = 0;
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
            number = Integer.parseInt(input);

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

    /**
     * readStrFromU reading string input e.g. path file 2read
     * @return a string if read something else null
     */
    public String readStrFromU(){
        String input_str = null;
        try {

            // Enter data using BufferReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // Reading data using readLine
            input_str = reader.readLine();


        }catch (IOException e){
            e.printStackTrace();
        }
        return input_str;
    }

    /**
     * insertNRandomKeys generate random keys in a range
     * and insert them to BTS
     */
    public void insertNRandomKeys(){
        long startTime = System.nanoTime();
        System.out.println("\n---------------------------------------------------\n");
        System.out.println("-> Starting Inserting N Random generated keys ...\n");
        Set<Integer> pickedNums = pickRandom(N, maxUpBound);
        System.out.println("---> Random Numbers generated\n");
        //System.out.println(pickedNums);
        System.out.println("---> inserting keys to tree....\n");
        for (Integer pickedNum : pickedNums) {
            int aKey = (int) pickedNum;
            //System.out.print(i + ", ");
            MyBSt.insertKey(aKey);
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("->Insertion completed "+timeElapsed/ 1000000+ "(sec), N = "+N+" keys inside the tree!\n");
        System.out.println("[+] Total avg. if-cond during insertion (counter/N):"+MyBSt.getCountInsIf()/N+"\n");

        System.out.println("First Key "+MyBSt.getBST()[0][0]);
        System.out.println("Last Key "+MyBSt.getBST()[N-1][0]);
        System.out.println("\n---------------------------------------------------\n");

    }

    /**
     * insertNKeysFromFile read integer values from file
     * and insert them
     * @param keys an array with int keys read from file
     */
    public void insertNKeysFromFile(int[] keys){
        long startTime = System.nanoTime();
        System.out.println("-> Starting Inserting N keys read from file...\n");
        System.out.println("---> inserting keys to tree....\n");
        for (int key : keys) {
//            System.out.println(key);
            MyBSt.insertKey(key);
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("->Insertion completed "+timeElapsed/ 1000000+ "(sec), N"+keys.length+ " keys inside the tree!\n");
        System.out.println("[+] Total avg. if-cond during insertion (counter/N):"+MyBSt.getCountInsIf()/ keys.length+"\n");
    }
    public void searchInBST(){
        System.out.print("\n-----------------------------------------------------------\n");
        System.out.println("\n @ Simple Search BST key  count Comparisons Results -\n");
        System.out.print("  -> Starting searching key inside the tree...\n");

        long startTime1 = System.nanoTime();
        Set<Integer> pNums = pickRandom(maxKeys2Search, maxUpBound); // get 100 random keys to search for
        List<Integer> numbersList = new ArrayList<Integer>(pNums) ;
        for(Integer k : numbersList){
            int aKey = (int) k;
            int indx = MyBSt.searchKey(MyBSt.getRootIndx(), aKey);
//            System.out.println("\n - Key Found at position "+indx);

        }
        long endTime1 = System.nanoTime();
        long timeElapsed1 = endTime1 - startTime1;
        System.out.println("  \n[-] Total BST  avg comparisons for simple key search  "+MyBSt.getCountScompares()/maxKeys2Search);
        System.out.println("  -> Key search  completed "+timeElapsed1/ 1000000+ "(sec), for "+maxKeys2Search+ " keys!\n");

    }
    /**
     * SearchInorderRange keys between [k1,k2] benchmark
     */
    public void searchInorderRange(){
        System.out.print("\n-----------------------------------------------------------\n");
        System.out.println("\n @ Inorder Search BST in Range Comparison Results -\n");
        System.out.print("  -> Starting searching in Range [k1,k2] inside the tree...\n");
        Set<Integer> pNums = pickRandom(maxKeys2Search, maxUpBound); // get 100 random keys to search for
        List<Integer> numbersList = new ArrayList<Integer>(pNums) ;

        long startTime1 = System.nanoTime();
        int totalComparisons1 = 0;
        //K=100
        for(Integer k : numbersList){
            int aKey = (int) k;
            MyBSt.searchKeysInRange(MyBSt.getRootIndx(),aKey,k+K2a);
            totalComparisons1 += MyBSt.getCountSRcompares();
            MyBSt.setCountSRcompares(0); //reset counter

        }
        long endTime1 = System.nanoTime();
        long timeElapsed1 = endTime1 - startTime1;
        System.out.println("  \n[-] Total BST (inorder) avg comparisons for range search with K=100 "+totalComparisons1/maxKeys2Search);
        System.out.println("  -> Range search for K=100 completed "+timeElapsed1/ 1000000+ "(sec), for "+maxKeys2Search+ " keys!\n");

        // K=1000
        long startTime2 = System.nanoTime();
        int totalComparisons2 = 0;
        for(Integer k : numbersList) {
            int aKey = (int) k;
            MyBSt.searchKeysInRange(MyBSt.getRootIndx(), aKey, k + K2b);
            totalComparisons2 += MyBSt.getCountSRcompares();
            MyBSt.setCountSRcompares(0); //reset counter
        }
        System.out.println("  \n[-] Total BST (inorder) avg comparisons for range search with K=1000 "+totalComparisons2/maxKeys2Search);
        long endTime2 = System.nanoTime();
        long timeElapsed2 = endTime2 - startTime2;
        System.out.println("  \n->Range search for K=1000 completed "+timeElapsed2/ 1000000+ "(sec), for "+maxKeys2Search+ " keys!\n");

        System.out.println("\n -------------------------------------------------\n\n");


    }
    /**
     * binarySearchesStats
     *  generate a List with random integers, then sort them
     *  generate a List with 100 random possible keys to search for
     *  for each key call binary search method, count if-cond
     *  then do range searches [K1,K2], count if-cond
     */
    public void binarySearchesStats(){
        System.out.println("\n -------------------------------------------------\n");
        System.out.println("\n -Binary Search Comparison Results -\n");
        Set<Integer> pNums = pickRandom(N, maxUpBound);
        List<Integer> numbersList = new ArrayList<Integer>(pNums) ;

        //sort
        Collections.sort(numbersList);
        int[]sortedKeys = numbersList.stream().mapToInt(Integer::intValue).toArray(); //Integer -> int[]

        // pick maxKeys2search and search for each one
        Set<Integer> keys2search = pickRandom(maxKeys2Search, maxUpBound);
        List<Integer> keys2searchList = new ArrayList<Integer>(keys2search) ; // set -> Integer

        //BinSearch
        long startTime1 = System.nanoTime();
        System.out.println("  -->Searching for each key out of "+maxKeys2Search+" searching...\n");
        for(Integer k : keys2searchList){
            int aKey = (int) k;
            int indx = runBinarySearch(sortedKeys,aKey,0,sortedKeys.length-1);
           // System.out.println("\n - Key found at position = "+indx);
        }
        long endTime1 = System.nanoTime();
        long timeElapsed1 = endTime1 - startTime1;
        System.out.println(" \n->BinSearch completed "+timeElapsed1/ 1000000+ "(sec), search for N ="+maxKeys2Search+ " keys. \n");
        System.out.println(" \n[-] Total avg. comparisons if-cond of binSearch = "+this.countBinSearch/maxKeys2Search);

        System.out.println("\n-> Range search for K= 100 starting...\n");
        long startTime2 = System.nanoTime();
        // Range 100 searches with width/range 100
        for(Integer k : keys2searchList) {
            int aKey = (int) k;
            int lowerBound = searchLowRange(sortedKeys,aKey);
            int upperBound = searchUpRange(sortedKeys,aKey+K2a);
//            System.out.println("\n Keys Range for K=100 indexes ["+lowerBound+", "+upperBound+"] \n");
        }
        // avg comparisons for K=100
        int totalAvgComparisons1 = (this.countLowerBoundIfs+this.countUpperBoundIfs)/maxKeys2Search;
        long endTime2 = System.nanoTime();
        long timeElapsed2 = endTime2 - startTime2;
        System.out.println("->BinSearch (Range) for K=100 completed "+timeElapsed2/ 1000000+ "(sec), search for N ="+maxKeys2Search+ " \n");
        System.out.println("[-] Total Avg comparison for range search for K=100, "+totalAvgComparisons1);

        System.out.println("\n-> Range search for K= 1000 starting...\n");
        long startTime3 = System.nanoTime();
        // reset to count for K=1000
        this.countLowerBoundIfs = 0 ;
        this.countUpperBoundIfs = 0;

        // Range 1000 searches with width/range 100
        for(Integer k : keys2searchList) {
            int aKey = (int) k;
            int lowerBound = searchLowRange(sortedKeys,aKey);
            int upperBound = searchUpRange(sortedKeys,aKey+K2b);
            //System.out.println("\n Keys Range for K=1000 indexes ["+lowerBound+", "+upperBound+"] \n");
        }
        // avg comparisons for K=100
        int totalAvgComparisons2 = (this.countLowerBoundIfs+this.countUpperBoundIfs)/maxKeys2Search;
        long endTime3 = System.nanoTime();
        long timeElapsed3 = endTime3 - startTime3;
        System.out.println("->BinSearch in a Range completed "+timeElapsed3/ 1000000+ "(sec), search for N ="+maxKeys2Search+ " \n");
        System.out.println(" \n[-] Total Avg comparison for range search for K=1000, "+totalAvgComparisons2);
        System.out.println("\n -------------------------------------------------\n");
    }

    /**
     * binary search for key equal
     * @param sortedArray an array with int keys,sorted
     * @param key a key to search for inside sortedArray
     * @param low low bound, array first elemetn index
     * @param high upper bound length of array
     * @return position where key found
     */
    public int runBinarySearch(int[] sortedArray, int key, int low, int high) {
        int index = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                this.countBinSearch+=1;
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                this.countBinSearch+=1;
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                this.countBinSearch+=1;
                index = mid;
                break;
            }
        }
        return index;
    }

    /**
     * searchLowRange -search for lower bound key
     * @param arr a sorted array with keys
     * @param key a key for the bottom range key
     * @return index where the lower bound found
     */
    public int searchLowRange(int[] arr, int key) {
        int low=0,high=arr.length,mid=-1;
        boolean flag=false;

        while(low<high) {
            mid=(low+high)/2;
            if(arr[mid]==key) {
                this.countLowerBoundIfs+=1;
                flag=true;
                break;
            } else if(arr[mid]<key) {
                this.countLowerBoundIfs+=1;
                low=mid+1;
            } else {
                this.countLowerBoundIfs+=1;
                high=mid;
            }
        }
        if(flag) {
            return mid;
        }
        else {
            if(low>=arr.length)
                return -1;
            else
                return low;
            //high will give next smaller
        }
    }

    /**
     * searchUpRange
     * @param arr a sorted array
     * @param key key of the upper bound to search
     * @return index of the closest upper bound
     */
    public int searchUpRange(int[] arr,int key) {
        int low=0,high=arr.length,mid=-1;
        boolean flag=false;

        while(low<high) {
            mid=(low+high)/2;
            if(arr[mid]==key) {
                this.countUpperBoundIfs+=1;
                flag=true;
                break;
            } else if(arr[mid]<key) {
                this.countUpperBoundIfs+=1;
                low=mid+1;
            } else {
                this.countUpperBoundIfs+=1;
                high=mid;
            }
        }
        if(flag) {
            return mid;
        }
        else {
            if(low>=arr.length)
                return -1;
            else
                return high-1;
            //high will give next smaller
        }
    }

    /**
     * main function to execute the program
     * @param args parsing input arguments
     */
    public static void main(String[] args) {
        // write your code here
        Main m =new Main();
//        Set<Integer> pickedNums = m.pickRandom(10,100);
//        //       String[] strArray = pickedNums.toArray(new String[pickedNums.size()]);
//        System.out.println(pickedNums);
//        Iterator iterator = pickedNums.iterator();

        //simple iteration
//        while(iterator.hasNext()){
//            int i = (int) iterator.next();
//            System.out.print(i + ", ");
//        }
//
//        System.out.println("\n" + pickedNums);
        //       System.out.println(Arrays.toString(strArray));

        // create Menu loop
        int answer;

        // show options
        m.printMenu();
        //read answer option
        do
        {
            answer=m.readIntFromU(); // menu option read
            /*check if answer is not valid number*/
            if(answer>2||answer<0)
                System.out.println("!|Sorry invalid choice..Plz try again!{available choices(0-2)}|..");
        }while(answer>2||answer<0);

        switch (answer) {
            case 1 -> {
                m.insertNRandomKeys(); // insert keys
                m.searchInBST();      // search for a key
                m.searchInorderRange(); // search for keys in range
                m.binarySearchesStats(); //binarySearches comparison using an array
            }
            case 2 -> {
                System.out.println("- Give the file name/path to be read..\n");
                String filep = m.readStrFromU();
                int[] kk = m.readBIn(filep);
                m.insertNKeysFromFile(kk);
                m.searchInBST();
                m.searchInorderRange();
                m.binarySearchesStats(); //binarySearches comparison  using an array
            }
            case 0 -> {
                System.out.println("\n->Program finished..");
                System.exit(0);
            }
            default -> System.out.println("\nERROR during switch mode-main-");
        }

    }

    // a method to print menu messages- available options
    public void printMenu(){
        System.out.println("=================================================");
        System.out.println("\n |MAIN MENU choose..");
        System.out.println(" |Press 1 for generating N random numbers. ");
        System.out.println(" |Press 2 for reading N numbers from .bin file.");
        System.out.println(" |Press 0 for exit.");
        System.out.println("\n*|Make your choice:");
        System.out.println("==========================================================");
    }
}
