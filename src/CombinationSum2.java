import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 * 示例1:
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例2:
 * <p>
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 提示:
 * <p>
 * 1 <=candidates.length <= 100
 * 1 <=candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSum2 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return result;
        }
        Arrays.sort(candidates);
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
                // 排序后一样的数字 只需要第一个参与组合
                if (i > startIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                // 把当前下标的值放到list中
                list.add(candidates[i]);
                // 一个数字只能出现一次 这里需要从下个下标开始递归
                combinationSumHelper(list, target - candidates[i], candidates, i + 1);
                // 递归之后要把前一个值删掉 相当于每循环一次 都用数组对应的下标值才占位尝试 尝试之后删除 下一个数继续这个流程
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSum2 instance = new CombinationSum2();
        List<List<Integer>> resultList = instance.combinationSum2(nums, target);
        resultList.forEach(System.out::println);
    }

}
