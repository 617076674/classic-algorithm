package sort;

public class InsertionSort {
    private InsertionSort() {}

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i, tmp = nums[i];
            while (j > 0 && tmp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
    }
}
