package Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution{
  //1
    public static int largestElement(int[] arr){
      int max_value = Integer.MIN_VALUE;
      for(int i =0; i < arr.length; i++){
        if(arr[i] > max_value){
          max_value = arr[i];
        }
      }
      return max_value;
    }

    //2
    public static int secondLargestElement(int[]arr){
      int first = Integer.MIN_VALUE;
      int second = Integer.MIN_VALUE;

      for(int i =0; i < arr.length ; i++){
        if(arr[i] > first){
          second = first;
          first = arr[i];
        }else if(arr[i] > second && arr[i] != first){
          //checks if first is greater than arr[i]
          second = arr[i];
        }
      }

      if(second == Integer.MIN_VALUE){ 
        //checks if all the elements in the array are same then first = element then second = Integer.MINVALUE
        return -1;
      }
      return second;

    }


    //3
    public static boolean isSorted(int[] arr){
        for(int i =0 ; i < arr.length -1;i++){
          if(arr[i] > arr[i+1]){
          return false;
          }
        }
        return true;
       
    }

    //4 Remove duplicates from Sorted array
    public static int removeDuplicates(int[] nums){
        HashSet <Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        return set.size();
    }

    //5 Left Rotate an array by one place
    public static void rotateArrayByOne(int[] nums) {
      //original arr : [2, 3 ,4 ,5 ,6]  
      //rotated arr : [3, 4, 5 , 6 ,2]
        int[] arr1 = Arrays.copyOf(nums, nums.length);
        //int first = nums[0];  // Alternative way
        for(int i =0; i < nums.length-1; i++){
         nums[i]= nums[i+1];
        }
        nums[nums.length-1] = arr1[0];       
        System.out.println(Arrays.toString(nums));     
    }

    //6 Left rotate an array by D places
    public static void rotateArray(int[] nums, int k) {
        //original arr : [2, 3 ,4 ,5 ,6]   k =3
        // j = 1 [3, 4, 5, 6, 2]
        //j = 2 [4, 5, 6, 2, 3]
        //j = 3 [5, 6, 2, 3, 4]
        for(int j =1; j <=k; j++){
          int first = nums[0];
           for(int i =0; i < nums.length-1; i++){
            nums[i]= nums[i+1];
          }
           nums[nums.length-1] = first;
        }
            System.out.println(Arrays.toString(nums));
    }

    //Move Zeros to end
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i =0; i < nums.length; i++){
        
        if(nums[i] != 0){
          //simple swap!!!
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        j++;
          
        }
      }
       System.out.println(Arrays.toString(nums));
    }

    //Find the Union
    public static void unionArray(int[] nums1, int[] nums2){
        HashSet <Integer> set = new HashSet<>();
        
        for(int num : nums1){
          set.add(num);
        }
         for(int num1 : nums2){
          set.add(num1);
        }
        
        int[] union = new int[set.size()];
        int index = 0;
        for(int num2 : set){
          union[index++] = num2;
          //index++;
        }
        System.out.println(Arrays.toString(union));
      }

    //Linear search
    public static void linearSearch(int[] nums, int target){
      for(int i =0; i < nums.length; i++){
        if(nums[i] == target){
          System.out.println("Found the number at "+i);
          return;
        }
      }
      System.out.println("Did not found the number");
    } 
    
    //Find the missing number
    public static void findMissingNumber(int[] arr, int n){
      int[] dummy = new int[n];
      int num = 1;
      for(int i =0; i < n; i++){
        dummy[i] = num;
        num++;
      }
      
      //  System.out.println(Arrays.toString(dummy));
      for(int j =0; j < n; j++){
        if(j >= arr.length || dummy[j] != arr[j]){
          System.out.println("The number is"+dummy[j]);
          return;
        }
      }
      System.out.println("No number is missing");
    }

    //Concecutive 1's
    public static void consecutiveOnes(int[] arr) {
      int count = 0;
      int max = 0;
  
      for (int i = 0; i < arr.length; i++) {
          if (arr[i] == 1) {
              count++;
              max = Math.max(max, count); // update max only when count increases
          } else {
              count = 0; // reset count when 0 is found
          }
      }
  
      System.out.println("Maximum consecutive 1s: " + max);
  }


//longest SubArray length
  public static void longestSubArraylength(int[] arr){
    int max = 0;
    for(int i =0; i < arr.length; i++){
      for(int j =0; j < arr.length; j++){
        int count = 0;
        boolean allPositive = true;
        for(int k = i; k<=j; k++){
         // System.out.print(arr[k]);
         if(arr[i] <= 0){
           allPositive = false;
           break;
         } 
          count++;
        }
        if(allPositive){
          max = Math.max(count, max);
        }
      }
    }
    System.out.println(max);
  }
  
    public static void main(String[] args) {
        
    }
}