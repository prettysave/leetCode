import java.util.HashSet;

/**
 * @author: heyong
 */

//给定一个非负整数数组，你最初位于数组的第一个位置。
//
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//判断你是否能够到达最后一个位置。
//
//示例 1:
//
//输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
//示例 2:
//
//输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/jump-game
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class CanJump {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 1) {
            return true;
        }
        // 维护一个最大可达index
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当i超过了之前的最大可达index 说明之前能跳的距离已经到头了 直接返回false
            if (maxIndex < i) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
            // 如果最大可达Index超过了数组长度 返回true
            if (maxIndex >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums2 = new int[]{3, 2, 1, 0, 4};
        int[] nums3 = new int[]{3, 0, 8, 2, 0, 0, 1};
        CanJump instance = new CanJump();
        boolean result = instance.canJump(nums);
        boolean result2 = instance.canJump(nums2);
        boolean result3 = instance.canJump(nums3);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}
