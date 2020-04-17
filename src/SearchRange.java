import structure.Utils;

/**
 * @Author: heyong
 * @Date: 2019-12-25 14:23
 * @Description:
 */
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//你的算法时间复杂度必须是 O(log n) 级别。
//
//如果数组中不存在目标值，返回 [-1, -1]。
//
//示例 1:
//
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//示例 2:
//
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        if (length == 1) {
            return nums[0] == target ? new int[]{0, 0} : result;
        }
        // 用一个布尔值来区分找左边界还是右边界
        search(nums, target, 0, length - 1, true, result);
        search(nums, target, 0, length - 1, false, result);
        return result;
    }

    public void search(int[] nums, int target, int left, int right, boolean isLeft, int[] result) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                search(nums, target, mid + 1, right, isLeft, result);
            } else if (nums[mid] > target) {
                search(nums, target, left, mid - 1, isLeft, result);
            } else {
                if (isLeft) {
                    // 左边界
                    result[0] = mid;
                    search(nums, target, left, mid - 1, isLeft, result);//
                } else {
                    // 右边界
                    result[1] = mid;
                    search(nums, target, mid + 1, right, isLeft, result);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        SearchRange demo = new SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int target2 = 6;
        int[] result1 = demo.searchRange(nums, target1);
        int[] result2 = demo.searchRange(nums, target2);
        Utils.printArray(result1, "result1");
        Utils.printArray(result2, "result2");

        String s = (String) null;
        System.out.println(s + ":!!!");
    }
}


