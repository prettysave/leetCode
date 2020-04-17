import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: heyong
 * @Date: 2019-11-22 18:03
 * @Description:
 */

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/3sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class ThreeSum {
    // 暴力法 超时了
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0 && !isExist(result, Arrays.asList(nums[i], nums[j], nums[k]))) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    public static boolean isExist(List<List<Integer>> result, List<Integer> group) {
        for (List<Integer> partResult : result) {
            List<Integer> copyResult = new ArrayList<>(partResult);
            boolean exist = true;
            for (Integer num : group) {
                if (!copyResult.contains(num)) {
                    exist = false;
                    break;
                } else {
                    copyResult.remove(num);
                }
            }
            if (exist) {
                return true;
            }
        }
        return false;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 数据校验
        if (nums.length < 3) {
            return result;
        }
        // 将数组排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 后续的值都为正数 三个正数相加不可能为0 到此结束
            if (nums[i] > 0) {
                break;
            }
            // 当前值和前一个值相同的情况下 当前值的结果集是前一个值的子集
            // 即前一个值最多比当前值多一个 {nums[i-1],nums[i], -(nums[i-1]+nums[i])}
            // 所以可以直接跳过 又因为数组是排序之后的 自然也就避免了结果集重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针 一个头 一个尾
            int left = i + 1;
            int right = nums.length - 1;
            // 两指针没有相撞
            while (left < right) {
                // 1 当前值与后一个值相等 因为n是从后往前的指针，与上类似 去重 跳过
                // 2 三数相加 结果>0 舍弃最大值 最大值往前移 变小
                if ((right < nums.length - 1 && nums[right] == nums[right + 1]) || nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                    // 1 去重
                    // 2 结果<0 舍弃中间值 中间值后移 变大 （不能舍弃最小值，因为最小值是根结点，根据最小值从左往右扫的数组）
                } else if ((left > i + 1 && nums[left] == nums[left - 1]) || nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    // 得到三元组
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left++]);
                    list.add(nums[right--]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> result = threeSum(nums);
        List<List<Integer>> result = threeSum1(nums);
        result.forEach(group -> {
            group.forEach(num -> {
                System.out.print(num + " ");
            });
            System.out.println();
        });
    }
}
