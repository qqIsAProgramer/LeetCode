package com.qyl.排序;

/**
 * @Author: qyl
 * @Date: 2021/3/11 8:49
 * @Description:
 */
public class QuickSort {

    /**
     * 快排统一接口
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }

        int pivot = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, low);

        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 10, 2, 1, 6, 8};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
