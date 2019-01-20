package cn.neu;

import java.util.Arrays;

/**
 * @author JsZero
 * 插入排序
 * 时间复杂度：总是Ο(n^2)
 * 过程：
 * 将第一个元素视为已排序序列，第二个到最后一个元素为未排序序列，
 * 向后遍历，将每个元素插入到相应的位置上
 */
public class InsertionSort {
    public static int[] sort(int[] arr) {
        int[] arrRet = Arrays.copyOf(arr, arr.length);
        int len = arrRet.length;
        for (int i = 1; i < len; i++) {
            int tmp = arrRet[i]; // 用tmp来存储插入数字的原因是插入过程中数组中数字后移，会把原来的数字覆盖
            int j = i - 1;
            while (j >= 0 && arrRet[j] > tmp) {
                arrRet[j + 1] = arrRet[j];
                j--;
            }
            if (j == i - 1) {
                arr[j + 1] = tmp;
            }
        }
        return arrRet;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 5, 3, 6, 1, 9, 4};
        Util.println(arr);
        int[] arrRet = InsertionSort.sort(arr);
        Util.println(arrRet);
    }
}
