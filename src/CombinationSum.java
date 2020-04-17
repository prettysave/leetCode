import java.util.ArrayList;
import java.util.List;

/**
 * @Author: heyong
 * @Date: 2020/4/14 14:35
 * @Description:
 */
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的数字可以无限制重复被选取。
//
//说明：
//
//所有数字（包括 target）都是正整数。
//解集不能包含重复的组合。 
//示例 1:
//
//输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
//示例 2:
//
//输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/combination-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0 || target < 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        combinationSumHelper(list, target, candidates, 0);
        return result;
    }

    private void combinationSumHelper(List<Integer> list, int target, int[] candidates, int startIndex) {
        if (target < 0) {
            return;
        }
        // 结束递归条件 list中已经是一个结果
        if (target == 0) {
            result.add(new ArrayList<>(list));
        } else {
            // 从数组后面的数继续递归
            for (int i = startIndex; i < candidates.length; i++) {
                // 把当前下标的值放到list中
                list.add(candidates[i]);
                combinationSumHelper(list, target - candidates[i], candidates, i);
                // 递归之后要把前一个值删掉 相当于每循环一次 都用数组对应的下标值才占位尝试 尝试之后删除 下一个数继续这个流程
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum demo = new CombinationSum();

        int[] candidates = new int[]{2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> result = demo.combinationSum(candidates, target1);
        System.out.println(result);
    }
}
