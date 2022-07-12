import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class SubSets {
    List<List<Integer>> finalResult = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(0, nums);
        return finalResult;
    }

    public void helper(int curr, int[] nums) {
// 先把当前子集加入到结果集
        finalResult.add(new ArrayList<>(result));
//        循环分别加入后面的结点
        for (int i = curr; i < nums.length; i++) {
//            当前结点加入到子集中
            result.add(nums[i]);
//            继续下一步递归
            helper(i + 1, nums);
//            在子集中剪掉当前循环的结点 （1，2）-> (1) ->(1,3)
            result.remove(result.size() - 1);
        }
    }


    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = subSets.subsets(nums);
        subsets.forEach(result -> System.out.println(result.toString()));
    }

}
