package odoo_hackkerank;

import java.util.HashSet;
import java.util.Set;

// Credits: https://github.com/varunu28/LeetCode-Java-Solutions/blob/master/Easy/Fair%20Candy%20Swap.java
// https://www.programmerall.com/article/2628505437/
// 

public class FairCandySwap {

	public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for (int num : A) {
            sumA += num;
            set.add(num);
        }
        
        for (int num : B) {
            sumB += num;
        }
        
        int diff = (sumA - sumB)/2;
        
        int[] ans = new int[2];
        for (int num : B) {
            if (set.contains(num + diff)) {
                ans[0] = num + diff;
                ans[1] = num;
                break;
            }
        }
            
        return ans;
    }
	
	public static void main(String[] args) {
		

	}

}
