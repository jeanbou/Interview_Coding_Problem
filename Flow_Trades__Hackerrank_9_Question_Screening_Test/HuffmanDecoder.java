import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 The credits for the give solution
 https://www.geeksforgeeks.org/huffman-decoding/

 Description of the problem on Hackerrank site
 https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
 https://sites.temple.edu/vahid/2022/03/05/hackerrank-solutions-tree-huffman-decoding/
 **/

public class HuffmanDecoder {

    private static final Map<Character, String> codes = new HashMap<>();
    private static final Map<Character, Integer> freq = new HashMap<>();
    private static final PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();

    /** TEST YOUR HACKER RANK SOLUTION CLASS **/
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String encodedString = "";
        String decodedString = "";
        calcFreq(str);
        HuffmanCodes(str.length());
        System.out.println("Character With their Frequencies:");
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (char c : str.toCharArray()) {
            encodedString += codes.get(c);
        }
        System.out.println("\nEncoded Huffman data:");
        System.out.println(encodedString);
        decodedString = decodeFile(minHeap.peek(), encodedString);
        System.out.println("\nDecoded Huffman Data:");
        System.out.println(decodedString);
    }

    private static void HuffmanCodes(int size) {
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            minHeap.add(new MinHeapNode(entry.getKey(), entry.getValue()));
        }
        while (minHeap.size() != 1) {
            MinHeapNode left = minHeap.poll();
            MinHeapNode right = minHeap.poll();
            MinHeapNode top = new MinHeapNode('$', left.freq + right.freq);
            top.left = left;
            top.right = right;
            minHeap.add(top);
        }
        storeCodes(minHeap.peek(), "");
    }

    private static void calcFreq(String str) {
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
    }

    private static void storeCodes(MinHeapNode root, String str) {
        if (root == null) {
            return;
        }
        if (root.data != '$') {
            codes.put(root.data, str);
        }
        storeCodes(root.left, str + "0");
        storeCodes(root.right, str + "1");
    }

    private static String decodeFile(MinHeapNode root, String s) {
        String ans = "";
        MinHeapNode curr = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
            if (curr.left == null && curr.right == null) {
                ans += curr.data;
                curr = root;
            }
        }
        return ans + '\0';
    }

}

class MinHeapNode implements Comparable<MinHeapNode> {
    char data;
    int freq;
    MinHeapNode left, right;

    MinHeapNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
    }

    public int compareTo(MinHeapNode other) {
        return this.freq - other.freq;
    }

} // HuffmanDecoder