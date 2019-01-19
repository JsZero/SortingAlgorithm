package cn.neu;

import java.util.Arrays;

/**
 * @author JsZero
 * 插入排序
 * 时间复杂度：总是Ο(n^2)
 * 过程：遍历length-1次，每次将未排序序列中最小的放到对应的位置上即可
 * 优点：除了不用额外的储存空间没啥好处
 */
public class SelectionSort {
    public static int[] sort(int[] arr) {
        int[] arrRet = Arrays.copyOf(arr, arr.length);
        int len = arrRet.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            int j = min + 1;
            while (j < len) {
                if (arrRet[min] > arrRet[j]) {
                    min = j;
                }
                j++;
            }
            if (min != i) {
                int tmp = arrRet[min];
                arrRet[min] = arrRet[i];
                arrRet[i] = tmp;
            }
        }
        return arrRet;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 5, 3, 6, 1, 9, 4};
        Util.println(arr);
        int[] arrRet = SelectionSort.sort(arr);
        Util.println(arrRet);
    }
}
