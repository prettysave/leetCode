/**
 * @author: heyong
 */

//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
//示例 1:
//
//输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。
//示例 2:
//
//输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//说明: 你可以假设 n 不小于 2 且不大于 58。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/integer-break
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class IntegerBreak {

    public int integerBreak(int n) {
        // 定义DP数组 数组的定义为 ，i的最大乘积
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        // 循环从3开始 1、2在上面已经直接赋值了
        for (int i = 3; i <= n; i++) {
            // 初始赋值
            dp[i] = 0;
            // j=1时dp[1]=0且(i - j) * j)=i-1 所以肯定不取 所以直接从2开始
            for (int j = 2; j < i; j++) {
                // 当从i中拆解出一个j时得到的乘积有两种情况:
                // 1.(i-j)*j 2.j*(i-j的最大乘积值)
                // 每次得到两者中的最大值，再与历史的dp[i]比较 更新当前最大值
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }

    /**
     * 可以发现当n拆分成多个3+4/2的时候得到的乘积是最大的
     * 利用这个特点可以直接用数学方法求出最大乘积
     *
     * @param n
     * @return
     */
    public int method2(int n) {
        // 小于3时不适用
        if (n <= 3) {
            return n - 1;
        }
        // 对3整除 得到的值是3平方的依据
        int i = n / 3;
        // 得到余数
        int mod = n % 3;
        // 被3整除 直接把所有的3都相乘
        if (mod == 0) {
            return (int) Math.pow(3, i);
        } else if (mod == 1) {
            // 当余数是1时 3的i次方*1 = 3的i-1次方*3 < 3的i-1次方*（3+1=4）
            // 这里的意思是把余数1+到最后那个3上 即少做一次拆分
            return (int) Math.pow(3, i - 1) * 4;
        } else if (mod == 2) {
            // 当余数是2时 因为3+2=5<3*2=6 直接彻底拆分
            // 把所有的3都相乘 然后再*2
            return (int) Math.pow(3, i) * 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        IntegerBreak instance = new IntegerBreak();
        int result = instance.integerBreak(2);
        int result1 = instance.integerBreak(10);
        int result2 = instance.method2(2);
        int result3 = instance.method2(10);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
