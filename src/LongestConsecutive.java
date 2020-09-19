import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: heyong
 */
//给定一个未排序的整数数组，找出最长连续序列的长度。
//
//要求算法的时间复杂度为 O(n)。
//
//示例:
//
//输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        int result = 0;
        for (int num : numSet) {
            // 确定连续序列中最小的值
            if (!numSet.contains(num - 1)) {
                int curr = num;
                int currResult = 1;
                // 判断set中是否有与当前值连续（比curr大1）的数 有则继续循环下去
                while (numSet.contains(curr + 1)) {
                    curr++;
                    currResult++;
                }
                // 无法继续连续 得到新的result 与历史result比较 取最大值
                result = Math.max(result, currResult);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestConsecutive instance = new LongestConsecutive();
        int[] array = new int[]{100, 4, 200, 1, 3, 2};
        int result = instance.longestConsecutive(array);
        System.out.println(result);
    }
}
