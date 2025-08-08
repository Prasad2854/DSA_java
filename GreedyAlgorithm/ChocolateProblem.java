package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;



public class ChocolateProblem {
    public static void main(String[] args) {
        int n =4, m = 5; // for chess board the value of m & n will be 8
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};
        Arrays.sort(costVer, Comparator.reverseOrder());
        Arrays.sort(costHor, Comparator.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;//horizontal parts, vertical parts
        int cost = 0;
        while (h < costHor.length && v < costVer.length) {
            if(costVer[v] <= costHor[h]){
                cost = cost + (costHor[h] * vp);
                hp++;
                h++;
            }else{
                cost = cost + (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < costHor.length) {
            cost = cost + (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVer.length) {
            cost = cost + (costVer[v] * hp);
            vp++;
            v++;
        }
        System.out.println("Min cost : "+cost);
    }

}
