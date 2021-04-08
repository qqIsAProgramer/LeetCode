package com.qyl.排序;

/**
 * @Author: qyl
 * @Date: 2021/4/8 15:36
 */
public class SortUtil {

    /**
     * 快排优化版（快排 + 三数取中 + 插入排序）
     * 插入排序在元素个数较少时效率是最高的，可以设置一个阈值，当达到阈值就使用插入排序
     * 三数取中用来取主元，是为了更好的分区
     * @param nums 待排序的数组
     */
    public static void sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快排转为插排的阈值
     */
    private static final int INSERT_SORT_THRESHOLD = 6;

    private static void quickSort(int[] nums, int low, int high) {
        if (high - low <= INSERT_SORT_THRESHOLD) {
            insertSort(nums, low, high);
            return;
        }
        int i = partition(nums, low, high);
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        // 主元：三数取中
        // 保证 low mid high 三个元素保持有序
        int mid = low + (high - low) / 2;
        if (nums[low] > nums[high]) swap(nums, low, high);
        if (nums[low] > nums[mid]) swap(nums, low, mid);
        if (nums[mid] > nums[high]) swap(nums, mid, high);

        // 分区
        int pivot = nums[low];
        int i = low;
        while (low < high) {
            while (low < high && nums[high] >= pivot) high--;
            while (low < high && nums[low] <= pivot) low++;
            if (low < high) swap(nums, low, high);
        }
        swap(nums, i, low);
        return low;
    }

    /**
     * 插入排序
     * 由于插入排序在几乎有序的数组上表现良好，特别地，在短数组上的表现也很好
     * 因为短数组的特点是：每个元素离它最终排定的位置都不会太远
     * 为此，在小区间内执行排序任务的时候，可以转向使用插入排序
     */
    private static void insertSort(int[] nums, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
