package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;


public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weigth = {10, 20, 30};
        int W = 50;

        double[][] ratio = new double[values.length][2];
        for(int i =0; i < ratio.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = values[i] / (double) weigth[i];
        }
        //ascending order using comparator 
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        //desending 

        int capacity = W;
        int finalValue = 0;
        for(int i = ratio.length -1; i >=0 ; i--){
            int index = (int) ratio[i][0];
            if(capacity >= weigth[index]){
                finalValue = finalValue + values[index];
                capacity = capacity - weigth[index];
            }else{
                finalValue = finalValue + (int)(ratio[i][1] * capacity);
                capacity = 0;
                break;                      
            }

        }
        System.out.println(finalValue);
    }
}
