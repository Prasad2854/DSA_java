package Striversheet;
import java.util.*;;
public class ArrayMedium {
    
//finding the leader 
    public static ArrayList<Integer> leaderArray(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int maxElement = arr[n-1];
        list.add(maxElement);
        for(int i = n -2; i >= 0; i--){
            if(arr[i] > maxElement){
                list.add(arr[i]);
                maxElement = arr[i];
            }
        }
        return list;
    }

    //rotation of the array o(n)!!!
    public static int[] rotateEfficient(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        int[] result = new int[n];
    
        for (int i = 0; i < n; i++) {
            result[i] = arr[(i + d) % n];
        }
        return result;
    }


    //Majority element
    public static void majorityElement(int[] arr) {
        int n = arr.length;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int keyData = entry.getKey();
            int valueCount = entry.getValue();
    
            if (valueCount > n / 2) {
                System.out.println(keyData);
                return; 
            }
        }
        System.out.println(-1);
    }


    public static int[] majorityElementII(int[] arr){
        int n = arr.length;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        ArrayList<Integer> list  = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int keyData = entry.getKey();
            int valueData = entry.getValue();

            if(valueData > n/3){
                list.add(keyData);
            }
        }
        int[] result = new int[list.size()];
        for(int i =0; i < result.length; i++){
            result[i] = list.get(i);
        }
        Arrays.sort(result);
        return result;
        
    }


    //Product of the array
    public static void productArray(int[] arr){
     
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0; i < arr.length; i++){
            int product = 1;
            for(int j =0; j < arr.length ; j++){
                if(i != j){
                     product = product * arr[j];
                }
            }
            list.add(product);
        }
        System.out.println(list);
    }

    //geneating all the subarrays of the array
    public static void subArray(int[] arr, int k){
        int count = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i =0; i < arr.length; i++){
            ArrayList<Integer> subarray = new ArrayList<>();
            for(int j =i; j < arr.length; j++){
                subarray.add(arr[j]);
                list.add(new ArrayList<>(subarray));
            }
        }

        //print

        for(List<Integer> sub : list){
            int product = 1;
            for(int i =0; i < sub.size(); i++){
                product = product * sub.get(i);
            }
            if(product < k){
                count++;
            }
        
        }
        System.out.println(count);
    }


    // public static void validSum(int[] arr, int k){
    //     //all the subarrays
    //     int count = 0;
    //     List<List<Integer>> list = new ArrayList<>();
    //     for(int i =0; i < arr.length; i++){
    //         ArrayList<Integer> subArray = new ArrayList<>();
    //         for(int j = i; j < arr.length; j++){
    //             subArray.add(arr[j]);
    //             list.add(new ArrayList<>(subArray));
    //         }
    //     }
    //     //check for valid sum
    //     for(List<Integer> sub : list){
    //         int sum = 0;
    //         for(int i =0; i < sub.size(); i++){
    //             sum = sum + sub.get(i);
    //         }
    //         if(sum == k){
    //             count++;
    //         }
    //     }
    //     System.out.println(count);
    // }

    //Array permuations
    public static void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums){
        
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int number : nums){
            if(tempList.contains(number)){
                continue;
            }

            tempList.add(number);

            backtrack(resultList, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static int[] splitArray(int[] arr){
        int total = 0;
        for(int i : arr){
            total = total + i;
        }
        if(total % 3 != 0) return new int[]{-1, -1};
        int target = total / 3;
        
        int sum = 0;
        int first = -1;
        for(int i =0; i < arr.length; i++){
            sum = sum + arr[i];
            if(sum == target && first == -1){
                first = i;
                sum = 0;
            }else if(sum == target && first != -1 && i < arr.length - 1){
                return new int[] {first, i};
            }
        }
        return new int[]{-1, -1};
    }

    public static int longestOnes(int[] arr, int k){
        int start = 0;
        int n = arr.length;
        int maxOnes = 0;
        int count  = 0;
        for(int end = 0; end < n; end++){
            if(arr[end] == 0){
                count++;
            }
            while (count > k) {
                if(arr[start] == 0){
                    count--;
                }
                start++;
            }
            maxOnes = Math.max(maxOnes, end - start +1); // **
        }
        return maxOnes;
    }

    public static int longestConsecutive(int[] nums) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        Set<Integer> sortedSet = new TreeSet<>(set);
        Integer[] newArr = new Integer[sortedSet.size()];
        sortedSet.toArray(newArr);
        for(int i =0; i < newArr.length-1; i++){
            if(newArr[i+1] -  newArr[i] == 1){
                count++;
            }    
        }
        return count;
    }


        
    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 0};
        int[] majorityELement = {-5, 3, -5};
        ArrayList<Integer> list = new ArrayList<>();
        list = leaderArray(arr);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        System.out.println(Arrays.toString(majorityElementII(majorityELement)));
        int[] array = {12, 0};
        productArray(array);
        int[] testArr = {10, 5, 2, 6};
        subArray(testArr, 100);
        int[] test2Arr = {1,2,3};
        //validSum(test2Arr, 3);
        // List<List<Integer> >result = new ArrayList<>();
        // backtrack(result, new ArrayList<>(), test2Arr);
        // for(List<Integer> perm : result){
        //     System.out.println(perm);
        // }


        int[] divideArr = {1, 3, 4, 0, 4};
        System.out.println(Arrays.toString(splitArray(divideArr)));
        int maxOnes[] = {1, 0, 1, 1, 0, 0, 1};
        System.out.println(longestOnes(maxOnes, 2));
        int[] sequence = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(sequence));
    }

}
