package sort;

public class MergeSort {
    private MergeSort() {}

    public static void sort(int[] nums) {
        int n = nums.length;
        for (int sz = 1; sz < n; sz *= 2) {
            for (int i = 0; i < n - sz; i += 2 * sz) {
                merge(nums, i, i + sz - 1, Math.min(n - 1, i + 2 * sz - 1));
            }
        }
    }

    //对nums数组中[left, mid]，[mid + 1, right]中的元素进行合并
    private static void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            tmp[i - left] = nums[i];
        }
        int index1 = left, index2 = mid + 1;
        for (int i = left; i <= right; i++) {
            if (index1 > mid) {
                nums[i] = tmp[index2 - left];
                index2++;
            } else if (index2 > right) {
                nums[i] = tmp[index1 - left];
                index1++;
            } else if (tmp[index1 - left] <= tmp[index2 - left]) {
                nums[i] = tmp[index1 - left];
                index1++;
            } else {
                nums[i] = tmp[index2 - left];
                index2++;
            }
        }
    }
}
