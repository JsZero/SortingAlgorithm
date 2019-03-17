package cn.neu;

import java.util.Arrays;

public class Demo {
    public static int[] mergeSort(int[] source) {
        int[] arr = Arrays.copyOf(source, source.length);
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int j = left;
        int i = mid + 1;
        int tmpPos = 0;
        while (j <= mid && i <= right) {
            if (arr[j] < arr[i])
                tmp[tmpPos++] = arr[j++];
            else
                tmp[tmpPos++] = arr[i++];
        }
        while (j <= mid)
            tmp[tmpPos++] = arr[j++];
        while (i <= right)
            tmp[tmpPos++] = arr[i++];
//        System.arraycopy(tmp, 0, arr, left, tmp.length);
        if (tmp.length >= 0) System.arraycopy(tmp, 0, arr, left, tmp.length);
    }

    public static void main(String[] args) {
        int[] arr = {91, 60, 96, 13, 35, 65, 46, 65, 10, 30, 20, 31, 77, 81, 22};
        int[] res = mergeSort(arr);
        System.out.println(Arrays.toString(res));
    }
}
