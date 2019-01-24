package cn.neu;

import java.util.Arrays;

/**
 * @author JsZero
 * 堆排序
 * 时间复杂度：Ο(nlogn)
 * 过程：
 * 用大顶堆先进行排序一次，把最大放到完全二叉树的末尾，
 * 再将剩下的len-1部分进行排序，每次把最大的放到对应
 * 的位置，排序len-1次结束
 */
public class HeapSort {
    public static int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;

        //
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        return arr;
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{91, 60, 96, 13, 35, 65, 46, 65, 10, 30, 20, 31, 77, 81, 22};
        Util.println(arr);
        int[] arrRet = HeapSort.sort(arr);
        Util.println(arrRet);
    }
}
