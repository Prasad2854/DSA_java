package Recursion;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

//import com.apple.laf.resources.aqua;

//import com.apple.laf.resources.aqua;

public class Recursion {

    public void stringSame(String data){
        int ans = 0;
        char[] a = data.toCharArray(); 
        char[] copy = Arrays.copyOf(a, a.length);

        int start = 0;
        int end = a.length -1;
            while (start < end) {
                char temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
                end--;
            }
      
            for(int i =0 ; i < a.length; i++){
                if(a[i] == copy[i]){
                    ans++;
                }else{
                    return;
                }
            }

        System.out.println(ans);
        
    }

    public int fact(int n){
        if(n == 1){
            return 1;
        }else{
            return n + fact(n- 1);
        }
    }

    //0, 1, 1,2, 3, 5....

    public int fibo(int n){
        if(n <= 1){
            return n;
        }else{
            return fibo(n- 1) + fibo(n - 2);
        }
    }

    public boolean sortedArray(int[] arr, int i){
        if(i == arr.length -1 ){
            return true;
        }

        if(arr[i] > arr[i+1]){
            return false;
        }
        return sortedArray(arr, i+1);
    }

    public int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // Calculate mid to prevent potential integer overflow
            int mid = start + (end - start) / 2; 

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (target < nums[mid]) {
                end = mid - 1; // Search in the left half
            } else { // target > nums[mid]
                start = mid + 1; // Search in the right half
            }
        }

        return -1; // Target not found
    }

//lower bound
    public int lowerBound(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;
        while (start <= end) {
            int mid = start + (end - start)/2;

            //lower bound   arr[i] >= x (target)

            if(arr[mid] >= x){
                ans = mid;// Store this as a potential answer
                end = mid - 1; // Try to find a smaller valid index in the left half
            }else{
                start = mid + 1;
            }
         
        }
        return ans;
    }   

    //upper bound
    public int upperBound(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;
        while (start <= end) {
            int mid = start + (end - start)/2;

            //upper bound   arr[i] > x (target)

            if(arr[mid] > x){
                ans = mid;// Store this as a potential answer
                end = mid - 1; // Try to find a smaller valid index in the left half
            }else{
                start = mid + 1;
            }
         
        }
        return ans;
    }   

    public int getSum(int n){
        if(n == 1)
        return 1;

        else
        return n + getSum(n-1);
    }

    public int firstOccurence(int[] arr, int target, int i){
        if(arr[i] == target){
            return i;
        }
        else if(i == arr.length-1){
            return -1;
        }else{
            return firstOccurence(arr, target, i+1);
        }
    }

    public int lastOccur(int[] arr, int target, int i){
       if(i < 0){
        return -1;
       }

       if(arr[i] == target){
        return i;
       }
       return lastOccur(arr, target, i-1);
    }


    //O(n)
    public int power(int n, int i){
        if(i == 0) return 1;

        return n *  power(n, i-1);
    }

    //O(logn)
    public int optimizedPower(int n, int i){
        if(i == 0) return 1;
        int halfPower = optimizedPower(n, i/2);
        int halfPowerSquare = halfPower * halfPower;
        if(i % 2 == 0) return halfPowerSquare;

        else {
            return n * halfPowerSquare;
        }
        }


        //tile problem
        public int tileWays(int n){
            if(n == 1 || n == 0) return 1;

            return tileWays(n-1) + tileWays(n-2);
        }


        
        //using iteration
        public String removeDup(String data){
            /*
        LinkedHashSet is a class in Java that:
	•	Stores only unique elements (no duplicates)
	•	Maintains insertion order (unlike HashSet)
             */
            Set <Character> s = new LinkedHashSet<>();
            for(char ch : data.toCharArray()){
                s.add(ch);
            }
            
            StringBuilder sb = new StringBuilder();
            for(char c : s){
                sb.append(c);
            }
            return sb.toString();
        }


        //using recurions   
        public String removeDuplicatesRe(String data, int index, StringBuilder newStr, boolean[] arr){
            if(index == data.length()){
                return newStr.toString();
            }
            char cuurentChar = data.charAt(index);
            if(arr[cuurentChar - 'a'] == true){
                return removeDuplicatesRe(data, index+1, newStr, arr);
            }
            else{
                arr[cuurentChar -'a'] = true;
                return removeDuplicatesRe(data, index+1, newStr.append(cuurentChar), arr);
            }
        }

        //friends pairing problem
        public int pairFriend(int n){
            if(n == 1 || n == 2) return n;

            return pairFriend(n-1) + (n-1) * pairFriend(n-2);
        }


       //binary string
        public String binaryString(int n ,String str, int lastPlace){
            if(n == 0) return str;

            if(lastPlace == 0) return binaryString(n-1, str+"1", 1);

            return binaryString(n-1, str+"0", 0);
        }

        // 4, 5, 0, 2, 0, 1, 1      -> 4, 5, 2, 1, 1, 0, 0
        public int[] endZeros(int[] arr){
            int[] dummy = new int[arr.length];
            int index = 0;
            for(int i =0; i < arr.length; i++){
                if(arr[i] != 0){
                    dummy[index] = arr[i];
                    index++;
                }
             }
             while(index < arr.length){
                dummy[index] = 0;
                index++;
            }
            return dummy;
        }

        public int mountainArray(int[] arr){
            int n = arr.length;
            int count = 0;
            for(int i =0; i < arr.length; i++){
                if(arr[i] != arr[n-1-i]){
                    arr[n-i-1] = arr[i];
                    count++;
                }
            }
            System.out.println(Arrays.toString(arr));
            return count;
        }

//using hashset
        public boolean containDuplicatesSet(int[] arr){
            Set<Integer> set = new HashSet<>(); 
            for(int i : arr){
                if(set.contains(i)) return true;
                set.add(i);
            }
            return false;
        }

        public boolean containDuplicates(int[] arr){
            Arrays.sort(arr);
            int count = 0;
            for(int i = 0; i < arr.length -1 ;i++){
                if(arr[i] == arr[i+1]){
                    count++;
                }
            }
    
            if(count > 0) return true;
            else  return false;
        }
       

    public static void main(String[] args) {
        Recursion t= new Recursion();
        //t.stringSame("abbc");
        int[] ar = {1,2 ,3 ,4 , 1};
        //System.out.println(t.fact(5));
        //System.out.println(t.fibo(10));
       // System.out.println(t.sortedArray(ar, 0));
        //System.out.println(t.binarySearch(ar, 6));
       // System.out.println(t.lowerBound(ar, 10));
        //System.out.println(t.getSum(5));
        //System.out.println(t.firstOccurence(ar, 16, 0));
        //System.out.println(t.lastOccur(ar, 16, ar.length-1));
        //System.out.println(t.optimizedPower(2, 5));
       // System.out.println(t.tileWays(4));
       //System.out.println(t.removeDuplicatesRe("apnacollege", 0, new StringBuilder(""), new boolean[26]));
      //System.out.println(Arrays.toString(t.endZeros(ar)));
      //System.out.println(t.mountainArray(ar));
     // System.out.println(t.containDuplicatesSet(ar));
     //System.out.println(t.binaryString(3, " ", 0));
     System.out.println(t.pairFriend(2));
    }
}




