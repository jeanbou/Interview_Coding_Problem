
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * The collection of possible task (I didn't have it) to code from T.D. based testing site
 * Check repository at https://github.com/HimashiNethinikaRodrigo/Test*
  * 
 */

public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> set = new HashSet<>(Arrays.stream(names1).collect(Collectors.toSet()));
        for (String name2 : names2) {
            set.add(name2);
        }
        String[] uniqueNames = set.toArray(new String[set.size()]);
        Arrays.sort(uniqueNames);
        return uniqueNames;
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }

}

