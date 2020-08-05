import structure.Utils;

/**
 * @author: heyong
 */
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//示例:
//
//输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//说明:
//
//必须在原数组上操作，不能拷贝额外的数组。
//尽量减少操作次数。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/move-zeroes
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        // 遍历数组 把所有非零的数都填充到数组的前部分 以index分界
        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }
        // 数组下标从index开始的后半段 全部填充0
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {
        MoveZeroes instance = new MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        instance.moveZeroes(nums);
        Utils.printArray(nums, "");
    }
}
