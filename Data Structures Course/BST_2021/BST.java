public class BST {
    // member variables
    private int[][] btsArray; //Nx3 array
    private static final int colNum = 3; // number of columns fields info,right,left
    private int rootIndx; //tree's root position in the array
    private int nextPos2Ins; // next Position in the array to insert
    private int countInsIf; // count insertion if compare statements
    private int countSRcompares; // count Search in Range comparisons
    private int countScompares; //count Search comparisons


    /**
     * BTS tree constructor
     * @param TotalNumOfKeys get an int N from Main class object
     */
    public BST(int TotalNumOfKeys) {
        this.rootIndx = -1;
        this.nextPos2Ins = 0;
        this.btsArray = new int[TotalNumOfKeys][colNum];
        this.countInsIf = 0;
        this.countSRcompares = 0;
        this.countScompares = 0;
    }

    /**
     * insertKey  call recursive insert
     * @param key a key to insert
     */
    public void insertKey(int key){
        this.rootIndx = insertRecurs(this.rootIndx,key);
    }

    /**
     * insertRecurs -- recursively insert a key
     * @param root starting with root's index and then getting each subtree's root index
     * @param key a key value to insert
     * @return root index
     */
    public int insertRecurs(int root,int key){
        if(root ==-1){
//            System.out.println("TheKey= "+key);
            this.btsArray[nextPos2Ins][0] = key; //insert key, empty node
            this.btsArray[nextPos2Ins][1] = -1; // something like null for int
            this.btsArray[nextPos2Ins][2] = -1;
            root = nextPos2Ins;
            nextPos2Ins +=1;
            this.countInsIf+=1; // increase comparison counter
            return root;
        }
        else if(key < this.btsArray[root][0]){
//            System.out.println("leftRecindx= "+this.btsArray[root][1]);
            this.countInsIf+=1; // increase comparison counter
            this.btsArray[root][1] = insertRecurs(this.btsArray[root][1],key);
        }
        else if(key > this.btsArray[root][0]){
//            System.out.println("rightRecindx= "+this.btsArray[root][2]);
            this.countInsIf+=1; // increase comparison counter
            this.btsArray[root][2] = insertRecurs(this.btsArray[root][2],key);
        }

        return root;
    }

    /**
     * searchKey  in tree
     * @param root root index starting from tree root and go to each subtree's root
     * @param key key to search for
     * @return index where key is found
     */
    public int searchKey(int root, int key)
    {
        // Base Cases: root is null or key is present at root
        if (root==-1 || btsArray[root][0]==key) {
            this.countScompares += 1;
            return root;
        }

        // Key is greater than root's key
        if (btsArray[root][0] < key) {
            this.countScompares += 1;
            return searchKey(btsArray[root][2], key);
        }

        // Key is smaller than root's key
        return searchKey(btsArray[root][1], key);
    }

    /**
     *  The functions prints all the keys which in
     *  the given range [k1..k2]. The function assumes than k1 < k2
     * @param root index of root node for each subtree
     * @param k1 lower bound
     * @param k2 upper bound
     */
    public void searchKeysInRange(int root, int k1, int k2) {

        /* base case */
        if (root == -1) {
            return;
        }

        /* Since the desired o/p is sorted, recurse for left subtree first
         If root->data is greater than k1, then only we can get o/p keys
         in left subtree */
        if (k1 < btsArray[root][0]) {
            this.countSRcompares +=1;
            searchKeysInRange(btsArray[root][1], k1, k2);
        }

        /* if root's data lies in range, then prints root's data */
        if (k1 <= btsArray[root][0] && k2 >= btsArray[root][0]) {
            this.countSRcompares +=2; // 2 comparisons in this if
            System.out.print(btsArray[root][0] + " ");
        }

        /* If root->data is smaller than k2, then only we
         can get o/p keys in right subtree */
        if (k2 > btsArray[root][0]) {
            this.countSRcompares +=1;
            searchKeysInRange(btsArray[root][2], k1, k2);
        }
    }
    // Setters Methods

    public void setRootIndx(int rootIndx) {
        this.rootIndx = rootIndx;
    }

    public void setNextPos2Ins(int nextPos2Ins) {
        this.nextPos2Ins = nextPos2Ins;
    }

    public void setCountSRcompares(int countSRcompares) {
        this.countSRcompares = countSRcompares;
    }
    // Getters Methods

    public int getCountSRcompares() {
        return countSRcompares;
    }

    public int getRootIndx() {
        return rootIndx;
    }

    public int getNextPos2Ins() {
        return nextPos2Ins;
    }

    public int getInfo(int arrayIndx){
        return btsArray[arrayIndx][0];
    }

    public int getLeft(int arrayIndx){
        return btsArray[arrayIndx][1];
    }

    public int getRight(int arrayIndx){
        return btsArray[arrayIndx][2];
    }

    public int[][] getBST(){
        return btsArray;
    }

    public int getCountInsIf(){
        return countInsIf;
    }

    public int getCountScompares() {
        return countScompares;
    }
    //    public int getNode(int arrayIndx){
//        int[] node = new int[3];
//        node[0]=btsArray[arrayIndx][0];
//        node[1]=btsArray[arrayIndx][1];
//        node[2]=btsArray[arrayIndx][2];
//        return ;
//    }

    /**
     * freeNode delete node
     * keep the previous available position to insert in the right field/column
     *  and update the current available to where is the node that deleted
     * @param arrayIndx an index for line inside the array to delete
     */
    public void freeNode(int arrayIndx){
        this.btsArray[arrayIndx][2] = this.nextPos2Ins;
        this.nextPos2Ins = arrayIndx;
    }
}
