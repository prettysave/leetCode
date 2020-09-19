/**
 * @author: heyong
 */
//在计算机界中，我们总是追求用有限的资源获取最大的收益。
//
//现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
//
//你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
//
//注意:
//
//给定 0 和 1 的数量都不会超过 100。
//给定字符串数组的长度不会超过 600。
//示例 1:
//
//输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//输出: 4
//
//解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
//示例 2:
//
//输入: Array = {"10", "0", "1"}, m = 1, n = 1
//输出: 2
//
//解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/ones-and-zeroes
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class FindMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            String str = strs[i - 1];
            int[] oneZeroCount = getOneZeroCount(str);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int zeroCount = oneZeroCount[0];
                    int oneCount = oneZeroCount[1];
                    if (j >= zeroCount && k >= oneCount) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeroCount][k - oneCount] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] oneZeroCount = getOneZeroCount(str);
            int zeroCount = oneZeroCount[0];
            int oneCount = oneZeroCount[1];
            // 注意这里是从后往前的
            // 因为dp数组后面的值是依赖前面的值 应该保证前面的值在后面的值计算完之后再做改动
            // 可以理解为前面的值是在字符串个数是当前个数-1的情况下的快照
            // 如果从前往后 因为前面的值已经是条件 "当前字符串个数"下的新值了 后面的值再依照的就不是在 "字符串个数是当前个数-1" 情况下的值了
            for (int i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] getOneZeroCount(String str) {
        int[] count = new int[2];
        for (char c : str.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "1", "0"};
        FindMaxForm instance = new FindMaxForm();
        int result = instance.findMaxForm(strs, 1, 1);
        int result2 = instance.findMaxForm2(strs, 1, 1);
        System.out.println(result);
        System.out.println(result2);
    }

}
