package sort.mergesort;

public class MergeSort {
    private MergeSort() {}

    public static void sort(int[] nums) {
        int n = nums.length;
        for (int sz = 1; sz < n; sz *= 2) {
            for (int i = 0; i < n - sz; i += 2 * sz) {
                merge(nums, i, i + sz - 1, Math.min(i + 2 * sz - 1, n - 1));
            }
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] aux = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            aux[i - left] = nums[i];
        }
        int index1 = left, index2 = mid + 1;
        for (int i = left; i <= right; i++) {
            if (index1 > mid) {
                nums[i] = aux[index2 - left];
                index2++;
            } else if (index2 > right) {
                nums[i] = aux[index1 - left];
                index1++;
            } else if (aux[index1 - left] < aux[index2 - left]) {
                nums[i] = aux[index1 - left];
                index1++;
            } else {
                nums[i] = aux[index2 - left];
                index2++;
            }
        }
    }
}
