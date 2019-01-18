package cn.neu;

import java.util.Arrays;

public interface ISort {
    static int[] sort(int[] arr) {
        int[] arrCpy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCpy);
        return arrCpy;
    }
}

class Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 5, 3, 6, 1, 9, 4};
        Util.println(ISort.sort(arr));
    }
}
