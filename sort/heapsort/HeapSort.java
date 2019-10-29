package sort.heapsort;

public class HeapSort {
    private HeapSort() {}

    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            shiftdown(nums, i, n - 1);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(nums, i, 0);
            shiftdown(nums, 0, i - 1);
        }
    }

    private static void shiftdown(int[] nums, int index, int limit) {
        int j = 2 * index + 1;
        while (j <= limit) {
            if (j + 1 <= limit && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] <= nums[index]) {
                break;
            }
            swap(nums, index, j);
            index = j;
            j = 2 * index + 1;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
