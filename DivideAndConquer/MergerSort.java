package DivideAndConquer;

public class MergerSort {

    public void mergerSort(int[] arr, int start, int end){
        if(start < end){
            int mid = start + (end - start) /2;
            mergerSort(arr, start, mid);
            mergerSort(arr, mid + 1, end);
            merge(arr, start,mid, end);
        }
       
    }

    public void merge(int[] arr, int start, int mid, int end){
        int n1 = mid - start +1;
        int n2 = end - mid; 
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for(int i = 0; i < leftArr.length; i++){
            leftArr[i] = arr[start + i];
        }

        for(int j =0; j < rightArr.length; j++){
            rightArr[j] = arr[mid+1+j];
        }

        int i =0, j = 0;
        int k = start;
        while(i < n1 && j < n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[i];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 1, 2};
        MergerSort m = new MergerSort();
        m.mergerSort(null, 0, arr.length-1);
    }
}
