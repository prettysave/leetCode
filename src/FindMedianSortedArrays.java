public class FindMedianSortedArrays {

    //给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    //
    //请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    //
    //你可以假设 nums1 和 nums2 不会同时为空。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int maxLeft;
        int minRight;
        if (m > n) {
            // 保证 m <= n
            return findMedianSortedArrays(B, A);
        }
        // 保证短的数组不会越界 因为m<=n
        int iMin = 0;
        int iMax = m;
        while (iMin <= iMax) {
            // 二分法寻找目标值
            int i = (iMin + iMax) / 2;
            // j在这种情况下会满足  偶数：(m - i) + (n - j)  = i + j 即 右边个数 = 左边个数 奇数：(m - i) + (n - j) + 1  = i + j 即 右边个数 + 1 = 左边个数
            int j = (m + n + 1) / 2 - i;
            // i 需要增大,i 右移 j左移
            if (j != 0 && i != m && B[j - 1] > A[i]) {
                iMin = i + 1;
                // i 需要减小，i左移，j右移
            } else if (i != 0 && j != n && A[i - 1] > B[j]) {
                iMax = i - 1;
                // 达到要求，并且将边界条件列出来单独考虑
            } else {
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                // 奇数时不需要考虑右边最小的值
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                //偶数返回结果
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

}
