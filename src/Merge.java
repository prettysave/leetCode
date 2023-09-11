/**
 * LeetCode Logo
 * 面试经典 150 题
 * Plus 会员
 * 0
 * <p>
 * avatar
 * 88. 合并两个有序数组
 * 提示
 * 简单
 * 2.1K
 * 相关企业
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * <p>
 * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 */
public class Merge {

    /**
     * 双指针 正向 需要额外的空间
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void Solution1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int k = 0;

        int[] result = new int[m + n];

        // 两个指针都到头时 结束循环
        while (p1 < m || p2 < n) {
            int curr;
            if (p1 == m) {
                curr = nums2[p2++];
            } else if (p2 == n) {
                curr = nums1[p1++];
            } else if (nums1[p1] > nums2[p2]) {
                curr = nums2[p2++];
            } else {
                curr = nums1[p1++];
            }

            result[k++] = curr;
        }

        System.arraycopy(result, 0, nums1, 0, k);


    }

    /**
     * 双指针 逆向 不需要额外的空间
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void Solution2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int k = m + n - 1;

        // 两个指针都到头时 结束循环
        while (p1 >= 0 || p2 >= 0) {
            int curr;
            if (p1 == -1) {
                curr = nums2[p2--];
            } else if (p2 == -1) {
                curr = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                curr = nums2[p2--];
            } else {
                curr = nums1[p1--];
            }
            nums1[k--] = curr;
        }

    }


}
