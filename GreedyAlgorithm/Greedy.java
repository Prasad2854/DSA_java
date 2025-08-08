package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Greedy {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end= {2, 4, 6, 7, 9, 9};
        
        int[][] sortArray = new int[start.length][3];
        for(int i =0; i < sortArray.length; i++){
            sortArray[i][0] = i;
            sortArray[i][1] = start[i];
            sortArray[i][2] = end[i];
        }

        //sort the end task array 
        Arrays.sort(sortArray, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> ans =  new ArrayList<>();
        
        int maxActivities = 1;
        int lastIndex = sortArray[0][2];
        ans.add(sortArray[0][0]);
        for(int i =1; i < end.length; i++){
            //start is greater or equal to the lastEnd index (main logic!!)
            if(sortArray[i][1] >= lastIndex){
                maxActivities++;
                ans.add(sortArray[i][0]);
                lastIndex = sortArray[i][2];
            }
        }
        System.out.println(maxActivities);
        for(int i =0; i < ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }

    }
    
}