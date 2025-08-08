package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {

    //3. Longest Substring Without Repeating Characters 
    // public int lengthOfLongestSubstring(String s) {
    //   HashSet<Character> set = new HashSet<>();
    //   int left =0;
    //   int right = 0;
    //   int maxLenght = 0;

    //   while(right < s.length()){
    //     char currentChar = s.charAt(right);
    //     if(!set.contains(currentChar)){
    //         set.add(currentChar);
    //         maxLenght = Math.max(maxLenght, right - left + 1);
    //         right++;
    //     }else{
    //         set.remove(s.charAt(left));
    //         left++;
    //     }
    //   }
    //   return maxLenght;
    // }



    // public static void convert(String s, int numRows){
    //       char[] a = s.toCharArray();
    //       //P A Y P A L I S H I R I N G
    //       char[][] strArr = new char[numRows][];
    //       for(int i =0; i < numRows; i++){
    //         for(int j = 0; j < strArr[i].length; i++){
    //           strArr[i][j] = a[i];
    //         }
    //       }

    //       for(int i =0; i < numRows; i++){
    //         for(int j =0; j < strArr[i].length; j++){
    //           System.out.print(strArr[i][j]+" ");
    //         }
    //         System.out.println();
    //       }
    // }

    public static boolean validpalindrome(String str){
        String original = str.replaceAll(" ", "").replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String newString = str.replaceAll(" ", "").replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(newString);
        newString = sb.reverse().toString();
        if(original.equals(newString)){
          return true;
        }else{
          return false;
        }
    }



    public static boolean wordBreak(String s, List<String> wordDict) {
      StringBuilder sb = new StringBuilder();
        for(int i =0; i < wordDict.size(); i++){
            int n = wordDict.get(i).length();
            for(int j =0; j < n; j++){
              if(s.charAt(j) == wordDict.get(i).charAt(j)){
                sb.append(s.charAt(j));
              }
            }
        }
        if(sb.toString().equals(s)){
          return true;
        }
        return false;
    }

    public static void main(String[] args) {
      //String s = "PAYPALISHIRING";
    // convert(s, 3);
      // String sen = "A man, a plan, a canal: Panama";
      // System.out.println(validpalindrome(sen));
      String s = "leetcode";
      ArrayList <String> list = new ArrayList<>();
      list.add("leet");
      list.add("code");
      System.out.println(wordBreak(s, list));
    }
}
