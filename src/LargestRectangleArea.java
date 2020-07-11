import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: heyong
 */
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//求在该柱状图中，能够勾勒出来的矩形的最大面积。

//示例:
//
//输入: [2,1,5,6,2,3]
//输出: 10
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class LargestRectangleArea {

    // 暴力解法
    public int solution1(int[] heights) {
        int length = heights.length;
        if (heights.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            int currHeight = heights[i];
            int left = i;
            // 找左边不小于当前值的的数
            while (left > 0 && heights[left - 1] >= currHeight) {
                left--;
            }
            // 找右边不小于当前值的数
            int right = i;
            while (right < length - 1 && heights[right + 1] >= currHeight) {
                right++;
            }
            // 计算结果 取最大值
            res = Math.max(res, currHeight * (right - left + 1));
        }
        return res;
    }

    // 单调栈+哨兵
    public int solution2(int[] heights) {
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


    public static void main(String[] args) {
        LargestRectangleArea instance = new LargestRectangleArea();
        int[] heights = new int[]{3, 2, 1, 5, 6, 2, 3};
        int res1 = instance.solution1(heights);
        int res2 = instance.solution2(heights);
        System.out.println(res1);
        System.out.println(res2);
    }


}
