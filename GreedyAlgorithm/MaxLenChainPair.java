package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaxLenChainPair {
    public static void main(String[] args) {
        int[] firstNum  = {5, 39, 5, 27, 50};
        int[] secNum = {24, 60, 28, 40, 90};

        int[][] pair = new int[secNum.length][3];
        for(int i =0; i < secNum.length; i++){
            pair[i][0] = i;
            pair[i][1]  = firstNum[i];
            pair[i][2] = secNum[i];
        }

        Arrays.sort(pair, Comparator.comparingDouble(o -> o[2]));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(pair[0][0]);
        int maxPairs = 1;
        int lastIndex = pair[0][2];
        for(int i =0; i < secNum.length; i++){
            if(pair[i][1] >= lastIndex){
                maxPairs++;
                list.add(pair[i][0]);
                lastIndex = pair[i][2];
            }
        }
        System.out.println(maxPairs);
    }
}
