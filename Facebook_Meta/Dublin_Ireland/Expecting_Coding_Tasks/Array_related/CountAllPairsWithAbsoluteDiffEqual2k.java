import java.util.HashMap;
import java.util.Map;

// CREDITS: https://gist.github.com/kylemboos/30f8786a66dfa6f3776744bbeb47d797
//              http://www.geeksforgeeks.org/count-pairs-difference-equal-k/
public class CountAllPairsWithAbsoluteDiffEqual2k {
	
	public static int countOfDistinctPairs(int[] input, int k){
        int numOfPairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : input){
            map.put(i, map.containsKey(i) ? 2 : 1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int i = e.getKey();

            //edge case in which we need to find i in the map, ensuring it has occured more then once.
            if(k == 0)
                numOfPairs = numOfPairs + map.get(i) == 2 ? 1 : 0;

            else if(map.containsKey(i-k))
                numOfPairs++;
        }
        return numOfPairs;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 4, 5};
        int k = 3;

        System.out.println(countOfDistinctPairs(arr, k));
    }

}
