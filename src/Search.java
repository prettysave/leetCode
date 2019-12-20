/**
 * @Auther: heyong
 * @Date: 2019-12-13 17:06
 * @Description:
 */

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
//你可以假设数组中不存在重复的元素。
//
//你的算法时间复杂度必须是 O(log n) 级别。
//
//示例 1:
//
//输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
//示例 2:
//
//输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Search {
    public int search(int[] nums, int target) {
        // 边际条件 直接返回
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        // 二分法
        // 二分之后  可以保证有一部分是单调递增的 旋转发生在另一部分
        // 根据中间值和最左值比较大小可以判断哪部分是单调递增的
        // 将目标值与递增的部分的两端比较 可以判断出是否在单调递增的部分
        // 如果在递增区间内 选择递增区间继续二分 如不在则选择另一区间二分
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midNum = nums[mid];
            int startNum = nums[start];
            int endNum = nums[end];
            // 与中间值相等 直接返回
            if (midNum == target) {
                return mid;
            }

            // 中间值大于左值 说明左半部分是递增的
            if (midNum >= startNum) {
                // 因为左半部分是单调递增的 如果目标值在左半部分的话则直接取左半部分继续二分
                if (target >= startNum && target <= midNum) {
                    end = mid - 1;
                // 目标值不在则放弃左半部分 继续二分
                } else {
                    start = mid + 1;
                }
                // 中间值小于左值 说明在左半部分发生旋转
            } else {
                // 因为左半部分发生旋转 即右半部分是单调递增的
                // 目标值在右半部分的话取右半部分继续二分
                if (target >= midNum && target <= endNum) {
                    start = mid + 1;
                // 目标值不在则放弃右半部分 继续二分
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        Search demo = new Search();
        int result1 = demo.search(nums, 0);
        int result2 = demo.search(nums, 3);

        System.out.println("result 1 :" + result1);
        System.out.println("result 2 :" + result2);
    }

}
