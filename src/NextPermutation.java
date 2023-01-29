import java.util.Arrays;

/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        // 找到非递减排列
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 当前排列不是最大的排列
        if (i >= 0) {
            int j = nums.length - 1;
            // 从右边找到第一个比i小的数
            while (j > 0 & nums[i] >= nums[j]) {
                j--;
            }
            // 交换位置
            swap(nums, i, j);
        }
        // i 后面的排列按照字母排序得到最小排列
        Arrays.sort(nums, i + 1, nums.length);
    }


    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {

        NextPermutation instance = new NextPermutation();

        int[] nums = new int[]{1, 3, 2};
//        instance.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        //[4,2,0,3,0,2,2]
        int[] nums2 = new int[]{4, 2, 0, 2, 3, 2, 0};
        instance.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));


    }

}
