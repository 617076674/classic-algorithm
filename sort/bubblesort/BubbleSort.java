package sort.bubblesort;

public class BubbleSort {
    private BubbleSort() {}

    public static void sort(int[] nums) {
        int n = nums.length, k;
        do {
            k = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i - 1, i);
                    k = i;
                }
            }
            n = k;
        } while (n > 0);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
