package sort.shellsort;

public class ShellSort {
    private ShellSort() {}

    public static void sort(int[] nums) {
        int n = nums.length;
        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = 0; i < n; i++) {
                int j = i, tmp = nums[i];
                while (j - h >= 0 && nums[j - h] > tmp) {
                    nums[j] = nums[j - h];
                    j -= h;
                }
                nums[j] = tmp;
            }
            h /= 3;
        }
    }
}
