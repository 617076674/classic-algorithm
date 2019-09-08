package knapsackproblem;

import java.util.Arrays;

/**
 * 0-1背包问题：
 *
 * 有一个背包，它的容量为capacity。现在有n种不同的物品，编号为0, ..., (n - 1)，其中每一件物品的重量为w(i)，价值为v(i)。问可以向
 * 这个背包中盛放哪些物品，使得在不超过背包容量的基础上，物品的总价值最大。
 */
public class KnapsackProblem1 {
    private static int[][] dp;

    public static int knapSack01(int[] w, int[] v, int capacity) {
        //考虑将第0个物品放进容量为capacity的背包里
        int n = w.length;
        dp = new int[n][capacity + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return bestValue(w, v, n - 1, capacity);
    }

    public static int knapSack01dp1(int[] w, int[] v, int capacity) {
        int n = w.length;
        int[][] dp = new int[n][capacity + 1];
        for (int i = 0; i < dp[0].length; i++) {
            if (i >= w[0]) {
                dp[0][i] = v[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }
        return dp[n - 1][capacity];
    }

    /**
     * 将[0, index]中的所有物品，装入容量为capacity的背包中，所能得到的最大价值。
     */
    private static int bestValue(int[] w, int[] v, int index, int capacity) {
        //如果索引无效或者背包容量不足，直接返回当前价值0
        if (index < 0 || capacity <= 0) {
            return 0;
        }
        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }
        //不放第index个物品
        int result = bestValue(w, v, index - 1, capacity);
        //放第index个物品
        if (w[index] <= capacity) {
            result = Math.max(result, v[index] + bestValue(w, v, index - 1, capacity - w[index]));
        }
        dp[index][capacity] = result;
        return result;
    }

    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2}, v = {12, 10, 20, 15};
        System.out.println(knapSack01dp1(w, v, 5));
    }
}
