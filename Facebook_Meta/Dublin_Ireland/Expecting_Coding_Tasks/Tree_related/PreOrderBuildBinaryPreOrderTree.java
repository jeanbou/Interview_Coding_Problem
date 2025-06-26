//A binary tree node
class TRNode {

    int data;
    TRNode left, right;

    TRNode(int d) {
        data = d;
        left = right = null;
    }
}

class Index {

    int index = 0;
}


public class PreOrderBuildBinaryPreOrderTree {

    Index index = new Index();

    // Driver program to test above functions
    public static void main(String[] args) {
        PreOrderBuildBinaryPreOrderTree tree = new PreOrderBuildBinaryPreOrderTree();
        int[] pre = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        TRNode root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }

    // A recursive function to construct BST from pre[]. preIndex is used
    // to keep track of index in pre[].
    TRNode constructTreeUtil(int[] pre, Index preIndex, int key, int min, int max, int size) {

        // Base case
        if (preIndex.index >= size) {
            return null;
        }

        TRNode root = null;

        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max) {

            // Allocate memory for root of this subtree and increment *preIndex
            root = new TRNode(key);
            preIndex.index = preIndex.index + 1;

            if (preIndex.index < size) {

                // Contruct the subtree under root
                // All nodes which are in range {min .. key} will go in left
                // subtree, and first such node will be root of left subtree.
                root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);

                // All nodes which are in range {key..max} will go in right
                // subtree, and first such node will be root of right subtree.
                root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);
            }
        }

        return root;
    }

    // The main function to construct BST from given preorder traversal.
    // This function mainly uses constructTreeUtil()
    TRNode constructTree(int[] pre, int size) {
        int preIndex = 0;
        return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }

    // A utility function to print inorder traversal of a Binary Tree
    void printInorder(TRNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

}
