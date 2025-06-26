import java.util.ArrayList;

// CREDITS:
// http://practice.geeksforgeeks.org/problems/print-leaf-nodes-from-preorder-traversal-of-bst/0

public class PreorderArray2Tree {
	static void printLeafNodes(ArrayList<Integer> list) {
        if(list.size()==0)return;
        if(list.size()==1) {
            System.out.print(list.get(0)+" ");
            return;
        }
        int parent = list.get(0);
        ArrayList<Integer> leftChild = new ArrayList<Integer>();
        ArrayList<Integer> rightChild =  new ArrayList<Integer>();
        for(int i=1; i<list.size(); i++) {
            if(list.get(i)<parent)leftChild.add(list.get(i));
            if(list.get(i)>parent)rightChild.add(list.get(i));
        };
        printLeafNodes(leftChild);
        printLeafNodes(rightChild);
    };

    public static void main(String[] args) {
        //int[] arr  = {10,5,1,7,40,50};
        //int[] arr =  {890, 325, 290, 530, 965};
        int[] arr = {3,2,4};
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++)list.add(arr[i]);
        printLeafNodes(list);
    }

}
