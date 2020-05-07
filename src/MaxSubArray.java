/**
 * @author: heyong
 */

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//示例:
//
//输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//进阶:
//
//如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximum-subarray
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class MaxSubArray {

    private int solutionOne(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果前面的累加值是正数 当前值与其相加才会更大
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            // 判断当前累加值与历史最大值的大小 取最大值
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }

    private int solutionTwo(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 与方法一本质差别不大 取当前值和"当前值+当前和"中的大值并赋值给当前和
            currSum = Math.max(nums[i], currSum + nums[i]);
            // 取当前和和最大和中的大值 并赋值给最大和
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    private int solutionThree(int[] nums) {
        return solutionThreeHelper(nums, 0, nums.length - 1);
    }

    // 分治法
    private int solutionThreeHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        // 把数组分为三份：
        // 1.左边的连续数组
        // 2.右边的连续数组
        // 3.带中间值的连续数组
        int middle = (left + right) / 2;
        // 左边和右边又可以继续分
        int leftMaxSum = solutionThreeHelper(nums, left, middle);
        int rightMaxSum = solutionThreeHelper(nums, middle + 1, right);
        // 求带中间值的和
        int crossMaxSum = getCrossMaxSum(nums, left, middle, right);

        return Math.max(Math.max(leftMaxSum, rightMaxSum), crossMaxSum);
    }

    private int getCrossMaxSum(int[] nums, int left, int middle, int right) {
        int leftMaxSum = Integer.MIN_VALUE;
        int rightMaxSum = Integer.MIN_VALUE;
        int currSum = 0;
        // 从中间值往左边连续的最大和
        for (int i = middle; i >= left; i--) {
            currSum += nums[i];
            leftMaxSum = Math.max(currSum, leftMaxSum);
        }
        currSum = 0;
        // 从中间值+1往右边连续的最大和
        for (int i = middle + 1; i <= right; i++) {
            currSum += nums[i];
            rightMaxSum = Math.max(currSum, rightMaxSum);
        }
        // 两个最大和相加就是带中间值的连续数组的最大和
        return leftMaxSum + rightMaxSum;
    }


    public static void main(String[] args) {
        MaxSubArray instance = new MaxSubArray();
        int[] nums1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums3 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result1 = instance.solutionOne(nums1);
        int result2 = instance.solutionTwo(nums2);
        int result3 = instance.solutionThree(nums3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
