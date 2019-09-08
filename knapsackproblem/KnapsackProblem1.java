package knapsackproblem;

/**
 * 0-1背包问题：
 *
 * 给定n个重量为w1、w2、w3、...、wn，价值为v1、v2、v3、...、vn的物品和容量为capacity的背包，求这些物品中最有价值的子集，
 * 使得在满足背包容量的前提下，包内的总价值最大。
 *
 * 0-1背包问题指的是每个物品只能使用一次。
 */
public class KnapsackProblem1 {
    public static int knapSack(int[] w, int[] v, int capacity) {
        return knapSack(w, v, w.length - 1, capacity);
    }

    /**
     * 现在我们考虑是否放置第index个物品
     */
    private static int knapSack(int[] w, int[] v, int index, int capacity) {
        //如果索引无效或者背包容量不足，直接返回当前价值0
        if (index < 0 || capacity <= 0) {
            return 0;
        }
        //不放第index个物品
        int result = knapSack(w, v, index - 1, capacity);
        //放第index个物品
        if (w[index] <= capacity) {
            result = Math.max(result, v[index] + knapSack(w, v, index - 1, capacity - w[index]));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2}, v = {12, 10, 20, 15};
        System.out.println(knapSack(w, v, 5));
    }
}
