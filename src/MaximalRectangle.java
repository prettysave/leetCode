import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: heyong
 */
//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
//示例:
//
//输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximal-rectangle
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class MaximalRectangle {


    /**
     * 分别以二维数组的每一层做底 解"柱状图中最大的矩形" 求最大值
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        // 判空
        if (matrix.length == 0) {
            return 0;
        }
        // 每一层为底时的柱状图
        int[] heights = new int[matrix[0].length];
        int res = 0;
        // 没一层遍历 分别更新heights
        for (int i = 0; i < matrix.length; i++) {
            // 遍历当前层的值
            for (int j = 0; j < matrix[i].length; j++) {
                // 当前层为'1' 则在上一层的基础上 高度+1
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    // 当前层为'0' 因为已经无法和上层连续 估归零
                    heights[j] = 0;
                }
            }
            // 求出当前层的最大矩形 与历史值对比取最大值
            res = Math.max(res, getLargesRectangleArea(heights));
        }
        return res;
    }

    public int getLargesRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        // 后面的哨兵 当往栈中压如这个值的时候表明已经遍历到头 此时可以将栈中的数依次出栈
        newHeights[len + 1] = 0;
        len += 2;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);
        for (int i = 1; i < len; i++) {
            // 保证栈中元素 栈顶的比栈底的大
            while (newHeights[i] < newHeights[stack.peekLast()]) {
                // 当前元素比栈顶元素小时说明已经栈顶元素的右边界是当前元素
                // 计算栈顶元素的高的同时将栈顶元素推出
                int curHeight = newHeights[stack.pollLast()];
                //  栈中上面的数是大于等于下面的数的 新栈顶则是旧栈顶的左边界
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }

}
