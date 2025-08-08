package Leetcode;

import java.util.ArrayList;

public class Solution7 {
    public static int removeDuplicates(int[] nums) {
        ArrayList <Integer> list = new ArrayList<>();
        for(int i =0; i < nums.length; i++){
            if(nums[i] == nums[i+1-i]){
               list.add(nums[i]);
            }else{
                list.add(nums[i]);
            }
        }
        return list.size();
    }

    import java.util.*;

    public class Main {
      
      public static void subArray(int[] nums){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;  
            for(int i =0; i < nums.length; i++){
                int sum = 0;
                for(int j = i; j < nums.length; j++){
                    for(int k = i; k <= j; k++){
                        System.out.print(nums[k]+" ");
                        sum = sum + nums[k];
                    }
                    System.out.println();
                    System.out.println(sum+" sum");
                    if(sum > max){
                      max = sum;
                    }
                       if(sum < min){
                      min = sum;
                    }
                    
                    sum =0;
                }
                System.out.println();
            }
            
            System.out.println("Max sum"+max);
            System.out.println("MIN sum"+min);
       }
       
       
        public static void main(String[] args) {
            int[] arr = {3, 4, 5, 6};
            subArray(arr);
      }
    }

 public static void main(String[] args) {
    int[] arr = {3, 4, 5, 6};
    subArray(arr);
 }
}
