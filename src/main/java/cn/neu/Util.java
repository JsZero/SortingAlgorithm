package cn.neu;

public class Util {
    public static void println(int[] arr) {
        int i = 0;
        for (i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[i]);
    }
}
