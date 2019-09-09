package knapsack;

public class Main {
    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2}, v = {12, 10, 20, 15};
        System.out.println(Knapsack01.knapSack01dp2(w, v, 5));
    }
}
