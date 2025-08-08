package Heaps;

import java.util.ArrayList;

public class Heaps {
    

    static ArrayList <Integer> list = new ArrayList<>();
    public static void add(int data){
        list.add(data);

        int x = list.size() - 1;
        int parentNode = (x-1)/2;

        while (list.get(x) < list.get(parentNode)) {
            int temp = list.get(x);
            list.set(x, list.get(parentNode));
            list.set(parentNode, temp);
        }
    }

    public static int peek(){
        return list.get(0); 
    }


    //removing of an element from heap has 3 steps:
    /*
     1. swap first and last element.
     2. remove my last element of the heap.
     3. restructure basically using heapify function()
     */


    public static int remove(){
        int data = list.get(0);
        //swap 1st with last
        int lastElement = list.size() - 1;
        int temp = list.get(0);
        list.set(temp, list.get(lastElement));
        list.set(lastElement, temp);

        //remove from the last of the arraylist
        list.remove(list.size() -1);
        //heapify

        heapify(0);
        return data;
    }


    public static void heapify(int index){
        int minIndex= index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(left < list.size() && list.get(left) < list.get(minIndex)){
            minIndex = left;
        }

        if(right < list.size() && list.get(right) < list.get(minIndex)){
            minIndex = right;
        }

        if(minIndex != index){ //checking if minIndex has changed or not!!!!
            int temp = list.get(index);
            list.set(index, list.get(minIndex));
            list.set(minIndex, temp);
            heapify(minIndex);
        }
    }

    public static void main(String[] args) {
        //Heaps h = new Heaps();
        add(3);
        add(4);
        add(5);
        add(8);
        
        

    }
}
