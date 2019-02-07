package cn.neu;

import java.util.Arrays;

/**
 * @author JsZero
 * 希尔排序
 * 思想：
 * 按照gap分组进行插入排序，变成半有序的数组，然后不断缩小gap直到1，
 * 排序成为最终有序数组
 */
public class ShellSort {
    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{91, 60, 96, 13, 35, 65, 46, 65, 10, 30, 20, 31, 77, 81, 22};
        Util.println(arr);
        int[] arrRes = sort(arr);
        Util.println(arrRes);
    }
}
