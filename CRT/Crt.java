package CRT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
//import java.util.stream.Gatherer.Integrator;
import java.util.stream.Gatherer.Integrator;

// import com.apple.laf.resources.aqua;

public class Crt {
    
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
            //1, 2, 3, 4, 5
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


        public void printNum(int n, int i){
            if(i == n) {
                System.out.println(n); 
                return;
            }
            else{
                System.out.println(i); 
                printNum(n, i+1);
            }
                
        }

        public int[] mergeSortedList(int[] arr1, int[] arr2){
            int n = arr1.length + arr2.length;
            
            int[] dummy = new int[n];
            for(int i =0; i < arr1.length; i++){
                dummy[i] = arr1[i];
            }
            int index = 0;
            for(int j = arr1.length;  j < n; j++){
                dummy[j] = arr2[index];
                index++;
            }


            // for(int j = arr1.length; j < arr2.length; j++){
            //     dummy[j] = arr2[index];
            //     index++;
            // }
            Arrays.sort(dummy);
            return dummy;         
        }

        public boolean palindrome(String str){
            String originalString = str.toLowerCase();
            StringBuilder sb = new StringBuilder(str.toLowerCase());
            String revereString = sb.reverse().toString();
            if(originalString.equals(revereString)){
                return true;
            }
            return false;
        }

        public void vowelsConsonantsCount(String str){
            String newStr = str.toLowerCase();
            int vowelCount = 0;
            int consonatCount = 0;
            for(int i =0; i < newStr.length(); i++){
                if(newStr.charAt(i) == 'a' || newStr.charAt(i) == 'e'||newStr.charAt(i) == 'i'||newStr.charAt(i) == 'o'||newStr.charAt(i) == 'u'){
                    vowelCount++;
                }else if(newStr.charAt(i) >= 'a' && newStr.charAt(i) <= 'z'){
                    consonatCount++;
                }
            }
            System.out.println("Vowels count "+vowelCount+" consonants count "+ consonatCount);
        }

        public void isAnagram(String str1, String str2){
            if(str1.length() == str2.length()){
                str1 = str1.toLowerCase();
                str2 = str2.toLowerCase();
                char[] a1 = str1.toCharArray();
                char[] a2 = str2.toCharArray();

                Arrays.sort(a1);
                Arrays.sort(a2);
                if(Arrays.equals(a1, a2)){
                    System.out.println("Is anagram");
                }else{
                    System.out.println("nopes");
                }
            }
        }

        public ArrayList<Integer> printPrimeNos(int n){
            ArrayList <Integer> list  = new ArrayList<>();
            for(int i =0; i <= n; i ++){
                if(isPrime(i)){
                    list.add(i);
                }
            }
            return list;
        }
        public boolean isPrime(int n){
            if(n < 2) return false;
            for(int i =2; i < n; i++){
                if(n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public ArrayList<Integer> isArmStromg(int num){
            //153
            ArrayList<Integer> list = new ArrayList<>();
            for(int i =1; i <= num; i++){
                int ori = i;
                int count = Integer.toString(i).length();
                // int count = String.valueOf(num).length();
                 //System.out.println(count);
                 int sum = 0;
                 int temp = i;
                 while (temp > 0) {
                     int rem = temp % 10;
                     sum =  sum + (int)Math.pow(rem, count);
                     temp = temp / 10;
                 }
                 if(sum == ori){
                     list.add(sum);
                 }
            }
     
           return list;
        }


        public String reverseString(String str){
           // StringBuilder sb = new StringBuilder();
            String[] arr = str.trim().split("\\s+");
            int start = 0;
            int end = arr.length - 1;
            while (start < end) {
                String temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
          String finalString = String.join(" ", arr);
          return finalString;
        }

    //
      public String removeOuterParenthesis(String str){
        int count =0;
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(ch == '('){
                if(count > 0) sb.append(ch);
                count++;
             }else{
                count--;
                if(count > 0) sb.append(ch);
             }
        }
        return sb.toString();
      }
        public boolean isValidParenthesis(String str){
            Stack <Character> stack = new Stack<>();
            for(int i=0; i < str.length(); i++){
                if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                    stack.push(str.charAt(i));
                }else{
                    if(!stack.isEmpty() && ((stack.peek() == '(' && str.charAt(i) == ')') || (stack.peek() == '[' && str.charAt(i) == ']') || (stack.peek() == '{' && str.charAt(i) == '}') )){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
            return true;

        }
        // public int largeOddNumber(String str){
        //     int n = Integer.parseInt(str);
        //     if(n % 2 != 0) return n;
        //     else{
        //         for(int i =0; i < str.length(); i++){
                    
        //         }
        //     }
        // }
        public void twoSum(int[] nums, int target) {
            //ArrayList<int[]> list = new ArrayList<>();
            int indx1 = 0;
            int indx2 = 0;
            for(int i =0; i < nums.length; i++){
                for(int j = i; j < nums.length;j++){
                    if(nums[i] + nums[j] == target){
                        indx1 = i;
                        indx2 = j;
                      
                    }
                }
            }
System.out.println(indx1 +" "+indx2);
            
        }
        
        public int possibleString(String str){
            int count = 1;
            for(int i= 0; i < str.length() - 1; i++){
                if(str.charAt(i) == str.charAt(i+1)){
                    count++;
                }
              
            }
            return count;
        }




      public int slidingWindow(int[]arr, int k){
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i =0; i < n - k + 1; i++){
            int currentSum = 0;
            for(int j = 0; j < k; j++){
                currentSum = currentSum + arr[i+j];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
      }

//kadane algorithm
      public int maximumSubArray(int[]arr){
        int maxSum = Integer.MIN_VALUE;
        int curentSum = 0;
        for(int i = 0; i < arr.length;i++){
            curentSum = curentSum + arr[i];
            maxSum = Math.max(maxSum, curentSum);
        }
        return maxSum;
      }

/*
 Write a function to determine if a given string is a valid password based on the following criteria: - 
 At least 4 characters - At least one numeric digit - At
  least one capital letter - Must not have space or slash (/) - Starting character must not be a number
 */

 public boolean isValidPassword(String password){
    if(password.length() < 4) return false;
    if(Character.isDigit(password.charAt(0))) return false;
    if(password.contains(" ") || password.contains("/")) return false;

    boolean hasDigit = false;
    boolean hasUpperCase = false;

    for(char a : password.toCharArray()){
        if(Character.isDigit(a)) hasDigit = true;
        if(Character.isUpperCase(a)) hasUpperCase = true;
    }
    if(!hasDigit) return false;
    if(!hasUpperCase) return false;

    return true;
 }



    public int[] leftRotateArray(int[] arr, int index){
        int n = arr.length;
        for(int i =0; i < index; i++){
            int first = arr[0];
            for(int j =0; j < n - 1; j++){
                arr[j ] = arr[j+1];
            }
            arr[n - 1] = first;
        }
        System.out.println(Arrays.toString(arr)+" left rotate");
        return arr;
    }


    public int[] rightRotateArray(int[] arr, int index){
        int n = arr.length;
        for(int i =0; i < index; i++){
            int last = arr[n- 1];
            for(int j = n- 1; j > 0; j--){
                    arr[j] = arr[j -1];
            }
            arr[0] = last;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public boolean isRotationsString(String str1, String str2){
        if(str1.length() == 0 || str2.length()  == 0) return false;    

        String s1s1 = str1 + str1;

        return s1s1.contains(str2);
    }

    // public  void isDoubleChar(String str){
    //     //geeksforgeeks

    // }

    public void majorityElement(int[] arr){
        List<Integer> list = new ArrayList<>();

        int n = arr.length;
        //1, 3, 2, 5, 1, 3, 1, 5, 1
        HashMap<Integer, Integer> map = new HashMap<>();

        // for(int i =0; i < n; i++){
        //     int count = 0;
        //     for(int j = 0; j < n; j++){
        //         if(arr[i] == arr[j]){
        //             map.put(arr[i], ++count);
        //         }
        // }
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int num : map.keySet()){
            if(map.get(num) > n/3){
                list.add(num);
            }
        }
            
        System.out.println(list);
        //System.out.println(map);
    }

    public boolean isAnagramUsingHashmap(String str1, String str2){
        HashMap<Character, Integer> map = new HashMap<>();
        if(str1.length() != str2.length()) return false;
        for(int i =0; i < str1.length(); i++){
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0)+1);
        }

        for(int i =0;i < str2.length(); i++){
            if(map.get(str2.charAt(i)) != null){
                if(map.get(str2.charAt(i)) == 1){
                    map.remove(str2.charAt(i));
                }else{
                    map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }

    public  void gcd(int n1, int n2, int len){
        ArrayList <Integer> list1 = new ArrayList<>();
        ArrayList <Integer> list2 = new ArrayList<>();
        for(int i =1; i < len; i++){
            if(n1 % i == 0){
                list1.add(i);
            }
        }
        for(int i =1; i < len; i++){
            if(n2 % i == 0){
                list2.add(i);
            }
        }
        System.out.println(list1);
        System.out.println(list2);
        list1.retainAll(list2);
        System.out.println(list1);
        int gcdElement = list1.get(list1.size() - 1);

        System.out.println(gcdElement);
    }


    public static int maxProfit(int[] arr){
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        for(int i =0; i < arr.length; i++){
            if(arr[i] < minPrice){
                minPrice = arr[i];
            }else{
                int profit = arr[i] - minPrice;
                maxPrice = Math.max( profit,maxPrice );
            }
        }
        return maxPrice;
    }
    public static int maxSumSubarray(int[] arr) {
        int currentMax = arr[0];
        int globalMax = arr[0];
    
        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            globalMax = Math.max(globalMax, currentMax);
        }
    
        return globalMax;
    }


       public static void main(String[] args) {
            Crt c = new Crt();
            int[] arr1 = {};
            int[] arr2 = {0};
            // c.printNum(5, 1);
            System.out.println(Arrays.toString(c.mergeSortedList(arr1, arr2)));
            String str = "Madam";
            System.out.println(c.palindrome(str));
            String sen = "I am prasad";
            String test = "Prasad";
            c.vowelsConsonantsCount(test);
            String tr = "Listen";
            String tr2 = "Prasad";
            c.isAnagram(tr, tr2);
            int n = 5;
            System.out.println(c.printPrimeNos(n));
            int num = 500;
            System.out.println(c.isArmStromg(num));
            String parenthesis = "(())()(())";
            System.out.println(c.removeOuterParenthesis(parenthesis));
            String sentence = "Hello   my name is Prasad";
            System.out.println(c.reverseString(sentence));
            int[]arr = {3,3};
            int target = 6;
            c.twoSum(arr, target);
            String str1 = "aaaa";
            System.out.println(c.possibleString(str1));
            int[] sliding = {3, 4, 5, 6, 7};
            int k = 3;
            System.out.println(c.slidingWindow(sliding, k));
            String pass = "a33E3333er";
           System.out.println(c.isValidPassword(pass));
           int[] a = {1, 2, 3, 4, 5, 6};
           System.out.println(c.leftRotateArray(a, 2));
           String test1 = "abcd";
           String test2 = "acbd";
           System.out.println(c.isRotationsString(test1, test2));
           String isDouble = "geekforgeeks";
           int[] majority = {1, 3,3, 3, 2, 5, 1, 3, 1, 5, 1};
           c.majorityElement(majority);
           String d1 = "race";
           String d2 = "care";
          System.out.println(c.isAnagramUsingHashmap(d1, d2));
	System.out.println("THIS IS FROM TERMINAL"); 

            c.gcd(45, 54, 100);
       }

}
