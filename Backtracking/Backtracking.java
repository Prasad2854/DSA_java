package Backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Backtracking {

    public void alterArray(int[] arr, int index, int value){
        if(index == arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        else{
            arr[index] = value;
            alterArray(arr, index+1, value+1);
            arr[index] = arr[index] - 2; // Backtracking step, always written after the function call()
        }
    }



    //finding the SUBSETS using backtracking
    public void subSets(String data, String str, int index){
        if(index == data.length()){
            if(str.length() == 0){
                System.out.println("null");
            }else{
                System.out.println(str);
            }
            return;
        } else{
            subSets(data,  str + data.charAt(index), index+1); //yes
            //no   -> this is a backtracking step which is executed after the return from the base case
            subSets(data, str, index+1);
        }
    }


    public void subsequences(String data, StringBuilder str, int index) {
        if (index == data.length()) {
            if (str.length() == 0) {
                System.out.println("empty");
            } else {
                System.out.println(str.toString());
            }
            return;
        } 
        subsequences(data, str.append(data.charAt(index)), index + 1);
        
        // backtrack step
        subsequences(data, str.deleteCharAt(str.length() - 1), index + 1);
    }

    public void stringPermutation(String str, String ans){
        if(str.length() == 0) {
            System.out.println(ans); 
            return;
        }

        else{
            for(int i= 0; i < str.length(); i++){
                char current = str.charAt(i);

                String newString = str.substring(0, i) + str.substring(i + 1);
                stringPermutation(newString, ans+current);

            }
        }
    }

    public void updateArray(int[] arr, int value, int index){
        if(index == arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[index] = value;
        alterArray(arr, index+1, value+1);
        arr[index] = arr[index] - 2;
    }

    int maxLength = Integer.MIN_VALUE;
    public void subSetLongest(String str, String sub, int index){
        String newString = removeDuplicates(str);

        if(newString.length() == index){
            if(sub == null){
                System.out.println("word is empty");
                return ;
            }else{
                maxLength =  Math.max(maxLength, sub.length());
                System.out.println(maxLength);
                return;
            }
        }
        subSetLongest(str, sub+str.charAt(index), index+1);
        subSetLongest(str, sub, index+1);
    }

    public  String removeDuplicates(String str){
        char[] strArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new LinkedHashSet<>();
        for(char a : strArr){
            set.add(a);
        }
        for(char c : set){
            sb.append(c);
        }
       return sb.toString();
    }

    public static void main(String[] args) {
        Backtracking b = new Backtracking();
        int[] arr= new int[5];
       String data = "abc";
    //    // b.alterArray(arr, 0, 1);
    //     //b.subSets(data, "", 0);
      //b.subsequences(data, new StringBuilder(" "), 0);
    //     b.stringPermutation(data, "");
       // b.alterArray(arr, 2, 1);
       String newData = "abcbbbpwsssscaab";
        b.subSetLongest(b.removeDuplicates(newData), "", 0);


    }
}
