package sort;

public class QuickSort {
    private QuickSort() {}

    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(nums, left, (int) (Math.random() * (right - left + 1)) + left);
        //[left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
        int lessThan = left, i = lessThan + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if (nums[i] == nums[left]) {
                i++;
            } else if (nums[i] < nums[left]) {
                lessThan++;
                swap(nums, lessThan, i);
                i++;
            } else {
                greaterThan--;
                swap(nums, i, greaterThan);
            }
        }
        swap(nums, left, lessThan);
        lessThan--;
        //[left, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        quickSort(nums, left, lessThan);
        quickSort(nums, greaterThan, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
