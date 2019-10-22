package sort.quicksort;

public class QuickSort {
    private QuickSort() {}

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(nums, left, (int) (left + 1 + Math.random() * (right - left)));
        //     [left + 1, lessThan]     [lessThan + 1, i)     [greaterThan, right]
        int lessThan = left, i = left + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if (nums[i] == nums[left]) {
                i++;
            } else if (nums[i] < nums[left]) {
                lessThan++;
                swap(nums, i, lessThan);
                i++;
            } else {
                greaterThan--;
                swap(nums, i, greaterThan);
            }
        }
        swap(nums, left, lessThan);
        lessThan--;
        sort(nums, left, lessThan);
        sort(nums, greaterThan, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
