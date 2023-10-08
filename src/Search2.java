//81. 搜索旋转排序数组 II
//
//已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
//在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
//给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
//你必须尽可能减少整个操作步骤。
//
//示例 1：
//
//输入：nums = [2,5,6,0,0,1,2], target = 0
//输出：true
//
//示例 2：
//
//输入：nums = [2,5,6,0,0,1,2], target = 3
//输出：false
//
//提示：
//
//1 <= nums.length <= 5000
//-104 <= nums[i] <= 104
//题目数据保证 nums 在预先未知的某个下标上进行了旋转
//-104 <= target <= 104
public class Search2 {

    public boolean solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 如果是相等 无法判断左边还是右边有序
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            // 前半部分有序
            if (nums[left] < nums[mid]) {
                // target在有序区间内 取左边部分
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    // 不在有序区间内 取右边
                    // 右边可能有比左边区间最大值大的或者比最小值小的数
                    left = mid + 1;
                }
                // 后半部分有序
            } else {
                // target在有序区间内 取右边部分
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    // 不在有序区间内 取左边
                    // 左边可能有比右边区间最大值大的或者比最小值小的数
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2 single = new Search2();

        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        boolean result = single.solution(nums, 2);
        System.out.println(result);
    }

}
