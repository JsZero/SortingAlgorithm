package cn.neu;

import java.util.Arrays;

public class QuickSort implements ISort{

    public static int[] sort(int[] arr) {
        int[] arrCpy = Arrays.copyOf(arr, arr.length);
        return quickSort(arrCpy, 0, arrCpy.length - 1);
    }

    private static int[] quickSort(int[] arr, int start, int end) {

        if (start < end) {
            int index = partition(arr, start, end);
            quickSort(arr, start, index - 1);
            quickSort(arr, index + 1, end);
        }
        return arr;
    }

    private static int partition(int[] arr, int start, int end) {
        if (arr.length == 0 || start < 0 || end > arr.length)
            return -1;
        int index = (start + end) / 2;
        swap(arr, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (arr[index] < arr[end]) {
                small++;
                if (index > small) {
                    swap(arr, index, small);
                }
            }
        }
        small++;
        swap(arr, small, end);
        return small;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 5, 3, 6, 1, 9, 4};
        Util.println(arr);
        int[] arrRes = sort(arr);
        Util.println(arrRes);
    }
}
