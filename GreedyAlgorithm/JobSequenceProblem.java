package GreedyAlgorithm;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class JobSequenceProblem {
    static class  Job {
        int deadline;
        int profit;
        int index;

        Job(int d, int p, int i){
            deadline = d;
            profit = p;
            index = i;
        }


        
    }

    public static void main(String[] args) {
        int[][] jobInfo = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i =0; i < jobInfo.length; i++){
            jobs.add(new Job(jobInfo[i][0], jobInfo[i][1], i));
        }
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); //descending order of profit!!

        ArrayList <Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i =0; i < jobs.size(); i++){
            Job current = jobs.get(i);
            if(current.deadline > time){
                seq.add(current.index);
                time++;
            }
        }
        System.out.println("Max - jobs "+seq.size());
    }


}
