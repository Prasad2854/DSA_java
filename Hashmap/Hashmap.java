package Hashmap;
import java.util.*;
import java.util.stream.Gatherer.Integrator;;
public class Hashmap {

    // public static boolean isAnagram(String s1, String s2){
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     if(s1.length() != s2.length()) {
    //         return false;
    //     }
    //     for(int i =0; i < s1.length(); i++){
    //         char ch = s1.charAt(i);
    //         map.put(ch, map.getOrDefault(ch, 0) + 1);
    //     }
    // }

    public static int union(int[] arr1, int[] arr2){
        LinkedHashSet <Integer> set = new LinkedHashSet<>();
        for(int i =0; i < arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int j= 0; j < arr2.length; j++){
            set.add(arr2[j]);
        }
        return set.size();
    }   

    public static int intersection(int[] arr1, int[] arr2){
        LinkedHashSet <Integer> set = new LinkedHashSet<>();
        for(int i =0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
       // {4, 5, 6, 6}
     //  int count = 0;
       for(int j =0; j < arr2.length; j++){
            if(set.contains(arr2[j])){
                set.remove(arr2[j]);
            }
       }
       return set.size();
    } 

    public static int maxSum(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        Integer[] newArr = new Integer[set.size()];
        newArr = set.toArray(newArr);
        
      

        int maximumSum = Integer.MIN_VALUE;
        for(int i =0; i < newArr.length; i++){
            int currentSum = 0;
            for(int j = 0; j < newArr.length;j++){
                currentSum = currentSum + newArr[j];
                maximumSum = Math.max(maximumSum, currentSum);
            }
        }
        return maximumSum;
    }

    public static boolean isAnagram(String s1, String s2){
        HashMap <Character, Integer> map = new HashMap<>();

        if(s2.length() != s1.length()){
            return false;
        }

        for(int i =0; i < s1.length(); i++){
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i =0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) - 1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }


    //Iterator 
    public static void iteratorFunction(){
        HashSet <Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(3);
        set.add(0);

        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

  public static void sortHashmap(int[] arr){
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i =0; i < arr.length; i++){
        map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
    list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

    LinkedHashMap<Integer, Integer> lmap = new LinkedHashMap<>();
    for(Map.Entry<Integer, Integer> entry : list){
        lmap.put(entry.getKey(), entry.getValue());
    }

    System.out.println(lmap);
  }

    
    public static void main(String[] args) {
        // int[] arr1 = {-100};
         int[] arr2 = {1, 3, 1, 2, 4, 1, 1};
        // System.out.println(union(arr1, arr2));
        // System.out.println(intersection(arr1, arr2));
        // System.out.println(maxSum(arr1));
        // String s1 = "care";
        // String s2 = "race";
        // System.out.println(isAnagram(s1, s2));
        // iteratorFunction();
        sortHashmap(arr2);
}
}
