package tmc;

// Credits : https://stackoverflow.com/questions/45373712/find-a-value-in-a-binary-tree-avoiding-stackoverflow-exception
// 25 minutes, the most complex task

public class TreeImplementation {
    class Node {

        Node left, right;
        int value;

        // The function that you have to insert
        public Node find(int v) {
            Node current = this;
            while (current != null) {
                if (current.value == v) {
                    return current;
                }
                // This will drop out of the loop naturally if there's no appropriate subnode
                current = v < current.value ? current.left : current.right;
            }
            return null;
        }
    }
}
