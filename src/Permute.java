/**
 * @Author: heyong
 * @Date: 2020/4/16 11:52
 * @Description:
 */

import structure.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permute {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Collections.emptyList();
        }
        permuteHelper(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void permuteHelper(int[] nums, List<Integer> list, boolean[] used) {
        // 退出递归的条件 list中已经是一个结果了
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 循环取值
        for (int i = 0; i < nums.length; i++) {
            // nums中的每个值都有个对应的used[i]表示在当前的分支中是否已经用了，没用就放到当前的分支里,已经用了就跳过
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                // 继续递归 切分支
                permuteHelper(nums, list, used);
                // 删除最后的节点 自然最后的节点在当前分支的使用情况就是未使用了
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permute demo = new Permute();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = demo.permute(nums);
        Utils.printArrayList(result);
    }
}
