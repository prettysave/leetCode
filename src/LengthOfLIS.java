/**
 * @author: heyong
 */

//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
//示例:
//
//输入: [10,9,2,5,3,7,101,18]
//输出: 4
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//说明:
//
//可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
//你算法的时间复杂度应该为 O(n2) 。
//进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        // 判空
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        // 以nums[i]结尾的最长上升子序列长度 注意：nums【i】必须被选取
        int dp[] = new int[length];
        // 初始化值为1
        dp[0] = 1;
        // 结果值 初始化为1
        int maxLength = 1;
        for (int i = 1; i < length; i++) {
            int currNum = nums[i];
            // 默认值为1
            dp[i] = 1;
            // 遍历num数组中 是否有比nums[i]小的值
            for (int j = 0; j < i; j++) {
                // 如果有比nums[i]小的值 则去其对应的dp值+1后与当前的dp[i]比较 取最大值
                if (nums[j] < currNum) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 得到目前dp数组中的最大值
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLIS instance = new LengthOfLIS();
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int result = instance.lengthOfLIS(nums);
        System.out.println(result);
    }
}
