package cn.neu;

import java.util.Arrays;

/**
 * @author shaoqi.jia
 * 快速排序
 * 平均时间复杂度：Ο(nlogn)
 * 最坏的时间复杂度：Ο(n^2)
 * 思想：在冒泡的基础上采用递归的分治法
 * 优点：
 * 快速，虽然时间复杂度最坏情况为 Ο(n^2) ，但是在
 * 大多数情况下都比平均时间复杂度为 Ο(nlogn) 的排序算法要好，
 * 原因是平摊期望时间是 O(nlogn)，且 O(nlogn) 记号中隐含
 * 的常数因子很小，比复杂度稳定等于 O(nlogn) 的归并排序要小
 * 很多。所以，对绝大多数顺序性较弱的随机数列而言，快速排序总
 * 是优于归并排序。
 */
public class QuickSort implements ISort {

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
