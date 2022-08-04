import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 示例2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        Integer[] integerArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integerArray[i] = nums[i];
        }
        Arrays.sort(integerArray, (x, y) -> {
            String sx = String.valueOf(x);
            String sy = String.valueOf(y);
            return (sy + sx).compareTo(sx + sy);
        });

        if (integerArray[0] == 0) {
            return "0";
        }

        return Arrays.stream(integerArray).map(String::valueOf)
                .collect(Collectors.joining());

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        LargestNumber instance = new LargestNumber();
        String result = instance.largestNumber(nums);
        System.out.println(result);
    }

}
