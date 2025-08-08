package Arrays.GreedyAlgorithm;
import java.util.*;

public class AssignCookies {
    public static int returnMaxCookies(int[] childrenNumber, int[] sizeCookie){
        int n = childrenNumber.length;
        int m = sizeCookie.length;

        int child = 0;//cookie size array pointer
        int cookie = 0; //children array pointer

        Arrays.sort(childrenNumber);
        Arrays.sort(sizeCookie);

        while(child < n && cookie < m ){
            if(childrenNumber[child] <= sizeCookie[cookie]){
                child = child + 1;
            }
            cookie = cookie + 1;
        }
        return child;
    }


    public static void main(String[] args) {
        int[] greed = {1, 5, 3, 3, 4};
        int[] size = {4, 2, 1, 3, 1, 3};

        System.err.println(returnMaxCookies(greed, size));
    }
}
