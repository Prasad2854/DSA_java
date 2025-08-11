package Striversheet;
import java.lang.reflect.Array;
import java.util.*;
public class ArrayEasy {
    //1
    public static int secondLargestElemt(int[] arr){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i =0; i < arr.length; i++){
            if(arr[i] > first){
                second = first;
                first = arr[i];
            }else if(arr[i] > second && arr[i] < first ){
                second = arr[i];
            }
        }
        return second == Integer.MIN_VALUE ?  -1: second;
    }
//2
    public static int thirdLargestElem(int[] arr){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for(int i =0;i < arr.length; i++){
            if(arr[i] > first){
                third = second;
                second = first;
                first = arr[i];
            }else if(arr[i] >second && arr[i] < first){
                third = second;
                second = arr[i];
            }else if(arr[i] >third && arr[i] < second){
                third = arr[i];
            }
        }

        return third == Integer.MIN_VALUE ? -1 : third;
    }
//3
     public static int maximumProductTriplet(int[] arr){
        //first three maximum nums
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        //now i want min element for the test cases which has negative values
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int num : arr){
            if(num > first){
                third = second;
                second = first;
                first = num;
            }else if(num > second){//no need to check for duplicacy!!
                third = second;
                second = num;
            }else if(num > third){  
                third = num;
            }
            //min value
            if(num < firstMin){
                secondMin = firstMin;
                firstMin = num;
            }else if(num < secondMin){
                secondMin = num;
            }
        }
        return Math.max(first * second * third, firstMin * secondMin*first );

     }

//4
     public static int maxConsecutiveOne(int[] arr){
        int maxCount = 1;
        int currentCount = 1;
        for(int i =1; i < arr.length; i++){ //always starts from 1
            if(arr[i-1]== arr[i]){
                currentCount++;
            }else{
                currentCount = 1;
            }
            maxCount = Math.max(maxCount, currentCount);
        }
        
        return maxCount;
     }


//5 
     public static void moveAllZerosToEnd(int[] arr){
        int index = 0;
        for(int i =0; i <arr.length; i++){
            if(arr[i] != 0){
                arr[index++] = arr[i];
              
            }
        }
        while (index < arr.length) {
            arr[index++] = 0;
         
        } 
        
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }  
     
     }

//6
     public static int[] reverseArrayInRange(int[] arr, int k){
        //int n = arr.length;
        for(int i =0; i < arr.length; i +=k){
            int start = i;
            int end = Math.min(i+k-1, arr.length -1); //** imp logic
            while(start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        for(int i =0;i < arr.length; i++){
            System.out.print(arr[i] +" ");
        }
        return arr;
     }

     //7 https://www.geeksforgeeks.org/dsa/array-rotation/
     //Approach 1
     public static void rotationOfArrayI(int[] arr, int d){
        for(int i =0; i < d; i++){
            int first = arr[0];
            for(int j = 0;j < arr.length-1; j++){
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = first;
        }
        for(int num :arr){
            System.out.print(num+" ");
        }
     }
     //Approach 2
     public static void rotationOfArrayII(int[] arr, int d){
        int n = arr.length;
        d = d % n;
        reverseRot(arr, 0, d-1);
        reverseRot(arr, d, n-1);
        reverseRot(arr, 0, n-1);
        
     }
     public static void reverseRot(int[] arr, int start, int end){
        while (start <end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end--;
        }
     }

     //8 https://www.geeksforgeeks.org/dsa/sort-array-wave-form-2/
     public static void waveForm(int[] arr){
        for(int i =0;i < arr.length ;i+=2){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        for(int num : arr){
            System.out.print(num+" ");
        }
     }

     //9 https://www.geeksforgeeks.org/dsa/adding-one-to-number-represented-as-array-of-digits/
     public static void plusOne(int[] arr){
        for(int i = arr.length - 1; i >=0; i--){
            if(arr[i] < 9){
                arr[i]++;
                return;
            }else{
                arr[i] = 0;
            }
        }
        int[] newArr = new int[arr.length+1];
        newArr[0] = 1;
        System.out.println(Arrays.toString(newArr));
     }


     //10 https://www.geeksforgeeks.org/dsa/best-time-to-buy-and-sell-stock/
     public static int stockBuy(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
    
        for (int price : arr) {
            if (price < minValue) {
                minValue = price; // update min
            }
            int profit = price - minValue; // possible profit
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    //11 https://www.geeksforgeeks.org/dsa/finding-sum-of-digits-of-a-number-until-sum-becomes-single-digit/
    public static int singleDigitSumI(int num){
        int sum = 0;
        //1234
        while (num > 0) {
            int rem = num % 10;
            sum = sum + rem;
            num = num /10;
        }
        if(sum > 9){
           return singleDigitSumI(sum);
        }else{
            return sum;

        }
    }
    //Approach 2
    public static int singleDigitSumII(int num) {
        while (num > 9) { // repeat until single digit
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    //12 https://www.geeksforgeeks.org/dsa/remove-element/
    public static int[] removeElemet(int[] arr, int ele){
        int index = 0;
        int count = 0;
        for(int i =0; i < arr.length; i++){
            if(arr[i] != ele){
                //3, 2, 2, 3
                count++;
                arr[index++] = arr[i];
            }
        }
        for(int j =0; j < arr.length; j++){
            if(index < arr.length && arr[j] == ele){
                arr[index++] = ele;
            }
        }
        System.out.println(count);
        return arr;
        
    }

    //13 https://www.geeksforgeeks.org/dsa/rearrange-array-alternating-positive-negative-items-o1-extra-space/
    public static int[] postiveNegativeArray(int[] arr){
        ArrayList<Integer> positiveList = new ArrayList<>();
        ArrayList<Integer> negativeList = new ArrayList<>();

        for(int num : arr){
            if(num >= 0){
                positiveList.add(num);
            }else{
                negativeList.add(num);
            }
        }

        int index = 0;
        int positiveIndex = 0;
        int negativeIndex = 0;
        boolean isPostive = true;
        while (positiveIndex < positiveList.size() && negativeIndex < negativeList.size()) {
            if(isPostive){
                arr[index++] = positiveList.get(positiveIndex++);
            }else{
                arr[index++] = negativeList.get(negativeIndex++);
            }
            isPostive = !isPostive;
        }

        //fill the rest of the remaining elements in the array
        while (positiveIndex < positiveList.size()) {
            arr[index++] = positiveList.get(positiveIndex++);
        }
        while (negativeIndex < negativeList.size()) {
            arr[index++] = negativeList.get(negativeIndex++);
        }
        return arr;
    }

    //14 https://www.geeksforgeeks.org/dsa/insert-an-adjacent-k-in-place-for-every-occurrence-of-it-in-the-array-keeping-the-size-of-the-array-intact/
    public static ArrayList<Integer> insertElemAdjacent(ArrayList<Integer> arr, int k){
        for(int i = 0;i < arr.size(); i++){
            if(arr.get(i) == k){
                //incrementing the index and adding the 'k' value at that particular index
                arr.add(i+1, k);
                i++;
            }
            //remove the last element 
            arr.remove(arr.size()  -1);
        }
        return arr;
    }

    public static void main(String[] args) {
         //int[] arr = ;
        // int num = 5674;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 0, 2, 3, 0, 4, 5, 0));

        System.out.println(insertElemAdjacent(list, 0));
    }
}
