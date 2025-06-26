// CREDITS: http://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/

/*
 * Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from root node down to the nearest leaf node.

For example, minimum height of below Binary Tree is 2.
Example Tree

Note that the path must end on a leaf node. For example, minimum height of below Binary Tree is also 2.

          10
        /    
      5  
 */

/* Java implementation to find minimum depth
of a given Binary tree */

/* Class containing left and right child of current
node and key value*/
class TNode {
    int data;
    TNode left, right;

    public TNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeMinDepth {

    //Root of the Binary Tree
    TNode root;

    /* Driver program to test above functions */
    public static void main(String[] args) {
        BinaryTreeMinDepth tree = new BinaryTreeMinDepth();
        tree.root = new TNode(1);
        tree.root.left = new TNode(2);
        tree.root.right = new TNode(3);
        tree.root.left.left = new TNode(4);
        tree.root.left.right = new TNode(5);

        System.out.println("The minimum depth of " + "binary tree is : " + tree.minimumDepth());
    }

    int minimumDepth() {
        return minimumDepth(root);
    }

    /* Function to calculate the minimum depth of the tree */
    int minimumDepth(TNode root) {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null) return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null) return 1;

        // If left subtree is NULL, recur for right subtree
        if (root.left == null) return minimumDepth(root.right) + 1;

        // If right subtree is NULL, recur for right subtree
        if (root.right == null) return minimumDepth(root.left) + 1;

        return Math.min(minimumDepth(root.left), minimumDepth(root.right)) + 1;
    }

}
