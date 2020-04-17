import java.util.LinkedList;

/**
 * @Author: heyong
 * @Date: 2019-12-02 12:45
 * @Description:
 */
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
//示例 1:
//
//输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//示例 2:
//
//输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-valid-parentheses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class LongestValidParentheses {

    // 用栈存下标 当出现')'的时候即去掉栈顶层的值
    public int longestValidParentheses(String s) {
        LinkedList<Integer> list = new LinkedList<>();
        int maxCount = 0;
        // 默认值-1 表示下标
        list.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 出现')'表示当前轮次匹配成功 去掉栈中的顶层元素
            if ('(' != c) {
                list.pop();
                // 如果栈已经为空 表示已经完成了一段有效的括号的匹配
                // 此时把当前下标放到栈中 相当于一开始的-1
                if (list.isEmpty()) {
                    list.push(i);
                } else {
                    // 如果栈没有空 则用当前的下标减上一次有效的括号的左侧下标 即栈中的顶层元素
                    // 得到这一匹配轮次的有效值 与历史值比较 取最大值
                    maxCount = Math.max(maxCount, i - list.peek());
                }
            } else {
                // 如果是'（'表示这一轮次未匹配 把当前下标放到栈中
                list.push(i);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        LongestValidParentheses demo = new LongestValidParentheses();
        int i = demo.longestValidParentheses("()(()");
        System.out.println(i);
    }
}
