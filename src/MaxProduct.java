/**
 * @author: heyong
 */
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 
//
//示例 1:
//
//输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//示例 2:
//
//输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximum-product-subarray
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        // 判空
        if (length == 0) {
            return 0;
        }
        int[][] dp = new int[length][2];
        // 最大值
        dp[0][0] = nums[0];
        // 最小值
        dp[0][1] = nums[0];
        for (int i = 1; i < length; i++) {
            int curr = nums[i];
            if (curr > 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * curr, curr);
                dp[i][1] = Math.min(dp[i - 1][1] * curr, curr);
            } else {
                dp[i][0] = Math.max(dp[i - 1][1] * curr, curr);
                dp[i][1] = Math.min(dp[i - 1][0] * curr, curr);
            }
        }
        // 遍历
        int result = nums[0];
        for (int i = 0; i < length; i++) {
            result = Math.max(result, dp[i][0]);
        }
        return result;
    }


}
