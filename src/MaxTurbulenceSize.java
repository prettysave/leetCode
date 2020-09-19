/**
 * @author: heyong
 */
//当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
//
//若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
//或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
//也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
//
//返回 A 的最大湍流子数组的长度。
//
// 
//
//示例 1：
//
//输入：[9,4,2,10,7,8,8,1,9]
//输出：5
//解释：(A[1] > A[2] < A[3] > A[4] < A[5])
//示例 2：
//
//输入：[4,8,12,16]
//输出：2
//示例 3：
//
//输入：[100]
//输出：1
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class MaxTurbulenceSize {

    public int maxTurbulenceSize(int[] A) {
        int length = A.length;
        int result = 1;
        // 校验输入数组的长度
        if (length < 2) {
            return result;
        }
        int[] dp = new int[length];
        // 初始化dp数组中的值
        dp[0] = 1;
        if (A[0] != A[1]) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        if (length == 2) {
            return dp[1];
        }
        // 从下标为2的元素开始遍历
        for (int i = 2; i < length; i++) {
            int currNum = A[i];
            int previousNum = A[i - 1];
            int previousPlusNum = A[i - 2];
            // 先赋初始值
            if (currNum == previousNum) {
                dp[i] = 1;
            } else {
                dp[i] = 2;
            }
            // 判断以当前元素结尾的连续子数组是否满足"湍流数组"的定义
            if (helper(currNum, previousNum, previousPlusNum)) {
                // 满足则取前一个dp值 + 1
                dp[i] = dp[i - 1] + 1;
            }
            // 判断最大值
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    // 湍流数组定义满足的判断
    private boolean helper(int currNum, int previousNum, int previousPlusNum) {
        return (currNum > previousNum && previousPlusNum > previousNum) ||
                (currNum < previousNum && previousPlusNum < previousNum);
    }

    public static void main(String[] args) {
        int[] ints = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int[] ints2 = {1, 0, 0};
        MaxTurbulenceSize instance = new MaxTurbulenceSize();
        int result = instance.maxTurbulenceSize(ints);
        int result2 = instance.maxTurbulenceSize(ints2);
        System.out.println(result);
        System.out.println(result2);
    }

}
