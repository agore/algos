import java.util.*;

public class Heap {
    

    public static void main(String[] argv) {

        int[] arr1 = new int[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        new Heap().maxHeapify(arr1, 1, arr1.length);
        System.out.println(Arrays.toString(arr1));
        assert Arrays.equals(arr1, new int[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1}) == true;

        int[] arr2 = new int[] {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        new Heap().buildMaxHeap(arr2);
        System.out.println(Arrays.toString(arr2));
        assert Arrays.equals(arr2, new int[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1});

        int[] arr3 = new int[] {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        new Heap().heapSort(arr3);
        System.out.println(Arrays.toString(arr3));
        assert Arrays.equals(arr3, new int[] {1, 2, 3, 4, 7, 8, 9, 10, 14, 16});


        int[] arr4 = new int[] {1, 1, 1, 1};
        new Heap().heapSort(arr4);
        System.out.println(Arrays.toString(arr4));
        assert Arrays.equals(arr4, new int[] {1, 1, 1, 1});
    }

    public void heapSort(int[] arr) {
        buildMaxHeap(arr);
        int heapLength = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, --heapLength);
        }
    }

    public void buildMaxHeap(int[] arr) {
        for (int i = (arr.length / 2) ; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }

    }
    
    public void maxHeapify(int[] arr, int index, int heapLength) {
        //final int heapLength = arr.length;
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
            swap(arr, index, largestIndex);
            maxHeapify(arr, largestIndex, heapLength);
        }
    }

    private void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    private int leftIndex(int index) {
        return (2 * index) + 1;
    }

    private int rightIndex(int index) {
        return (2 * index) + 2;
    }
}
