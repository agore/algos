import java.util.*;

public class Heap {
    

    public static void main(String[] argv) {

        int[] arr1 = new int[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        new Heap().maxHeapify(arr1, 1);
        System.out.println(Arrays.toString(arr1));
        assert Arrays.equals(arr1, new int[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1}) == true;


    }

    public void buildMaxHeap(int[] arr) {
        for (int i = (arr.length / 2) ; i >= 0; i--) {
            maxHeapify(arr, i);
        }

    }
    
    public void maxHeapify(int[] arr, int index) {
        final int heapLength = arr.length;
        int l = leftIndex(index);
        int r = rightIndex(index);
        int largestIndex = index;

        if (l < heapLength && arr[index] < arr[l]) {
            largestIndex = l;
        } else {
            largestIndex = index;
        }

        if (r < heapLength && arr[largestIndex] < arr[r]) {
            largestIndex = r;
        }

        if (largestIndex != index) {
            int temp = arr[index];
            arr[index] = arr[largestIndex];
            arr[largestIndex] = temp;

            maxHeapify(arr, largestIndex);
        }
    }

    private int leftIndex(int index) {
        return (2 * index) + 1;
    }

    private int rightIndex(int index) {
        return (2 * index) + 2;
    }
}
