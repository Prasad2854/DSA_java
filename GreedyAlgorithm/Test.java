/*
 * Given a strings and an array of strings words, return the number of words(i] that is a subsequence of s.
3 A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
5 For example, "ace" is a subsequence of "abcde".
8 Example 1:
10 Input: s = "abcde", words = ["a", "bb", "acd", "ace")
11 Output: 3|
12 Explanation:
There are three strings in words that are a subsequence of s: "a", "acd", "ace".
13 Example 2:
15 Input: s = "dsahjpjauf", words = ["ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"]
lo Vutout:
 */


package GreedyAlgorithm;

import java.util.ArrayList;

public class Test {

    // Main method to count how many words are subsequences of s
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;

        for (String word : words) {
            if (isSubsequence(word, s)) {
                count++;
            }
        }

        return count;
    }

    // Check if 'word' is a subsequence of 's'
    public boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;

        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == word.length();
    }

    public static void main(String[] args) {
        Test t = new Test();

        // Example 1
        String s1 = "abcde";
        String[] words1 = {"a", "bb", "acd", "ace"};
        System.out.println("Output: " + t.numMatchingSubseq(s1, words1)); // 3

        // Example 2
        String s2 = "dsahjpjauf";
        String[] words2 = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        System.out.println("Output: " + t.numMatchingSubseq(s2, words2)); // 2
    }
}