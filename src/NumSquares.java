/**
 * @author: heyong
 */
//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
//        示例 1:
//
//        输入: n = 12
//        输出: 3
//        解释: 12 = 4 + 4 + 4.
//        示例 2:
//
//        输入: n = 13
//        输出: 2
//        解释: 13 = 4 + 9.
public class NumSquares {
    public int numSquares(int n) {
        // dp[i] 表示当n = i 时，最少的完全平方数
        int[] dp = new int[n + 1];
        // 遍历算所有小于n的dp[i]的值
        for (int i = 1; i <= n; i++) {
            // 初始值  最坏的情况是 n = 1+1+1+1(n个1相加)
            dp[i] = i;
            // n - 小于n的完全平方数 = 余数
            for (int j = 1; i - j * j >= 0; j++) {
                // 算余数的dp[余数]值 + 1 与当前的dp[i]值比较 取小值
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares instance = new NumSquares();
        int result = instance.numSquares(12);
        System.out.println(result);
    }
}
