package talkwalk;

public class Problem03v2_DLL {

    // Implement Double Link List and the methods
    // deleteNode is supportive method for remove and remove all methods
    // sole method printAllNodesFromHead is enough, but I have used also printing from Tail
    // Credit: simplified version https://www.softwaretestinghelp.com/doubly-linked-list-in-java/
    // Credit: https://www.geeksforgeeks.org/delete-doubly-linked-list-node-given-position/
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int val) {
            this.data = val;
        }
    }

    static Node head;
    Node tail = null;

    static Node deleteNode(Node del) {
        if (head == null || del == null) {
            return null;
        }
 
        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }
 
        // Change next only if node to be
        // deleted is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        // Change prev only if node to be
        // deleted is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }
        del = null;
 
        return head;
    }


    // Remove at certain index of DLL
    public void remove(int n) {
        /* if list in NULL or
        invalid position is given */
      if (head == null || n <= 0) {
          return;
      }

      Node current = head;
      int i;

      /*
      * traverse up to the node at
        position 'n' from the beginning
      */
      for (i = 1; current != null && i < n; i++) {
          current = current.next;
      }
       
      // if 'n' is greater than the number of nodes
      // in the doubly linked list
      if (current == null) {
          return;
      }

      // delete the node pointed to by 'current'
      deleteNode(current);
    }
    
    public void removeAll(int val) {
        if (head == null) {
            return;
        }
        Node current = head;
        while(current != null) {
            if (current.data == val) {
                deleteNode(current);
            }
            current = current.next;
        }
    }
    
    // https://www.geeksforgeeks.org/merge-sort-for-doubly-linked-list/
    // Merge sort is considered the most optimal for DLL
    // split and merge is the supportive methods
    public Node sort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node second = split(node);
 
        // Recur for left and right halves
        node = sort(node);
        second = sort(second);
 
        // Merge the two sorted halves
        return merge(node, second);
    }

    // Function to merge two linked lists
    Node merge(Node first, Node second) {
        // If first linked list is empty
        if (first == null) {
            return second;
        }
 
        // If second linked list is empty
        if (second == null) {
            return first;
        }
 
        // Pick the smaller value
        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
    
    // Split a doubly linked list (DLL) into 2 DLLs of half sizes
    Node split(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }


    public void addNode(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
            head.prev = null;
            tail.next = null;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    public void printAllNodesFromHead() {
        Node curr_pointer = head;
        if (head == null) {
            System.out.print("Double Linking List is empty");
            return;
        }
        while (curr_pointer != null) {
            System.out.print(" "+curr_pointer.data);
            curr_pointer = curr_pointer.next;
        }
    }

    public void printAllNodesFromTail() {
        Node curr_pointer = tail;
        if (tail == null) {
            System.out.print("Double Linking List is empty");
            return;
        }
        while (curr_pointer != null) {
            System.out.print(" "+curr_pointer.data);
            curr_pointer = curr_pointer.prev;
        }
    }
    
    public static void main(String[] args) {
        Problem03v2_DLL myDLL = new Problem03v2_DLL();
        myDLL.addNode(5);
        myDLL.addNode(1);
        myDLL.addNode(4);
        myDLL.addNode(5);
        myDLL.addNode(3);
        myDLL.addNode(5);
        //myDLL.printAllNodesFromHead();
        //myDLL.remove(2);
        //myDLL.printAllNodesFromHead();
        myDLL.removeAll(5);
        myDLL.printAllNodesFromHead();
        // Please note I didn't test it properly
        //Node sortedDLL = myDLL.sort(head);
        //System.out.println(sortedDLL.toString());
    }

}
