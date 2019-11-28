import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: heyong
 * @Date: 2019-11-28 14:14
 * @Description:
 */
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
//例如，给出 n = 3，生成结果为：
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/generate-parentheses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        // 必须以(开头
        generateParenthesisHelper("(", 1, 2 * n - 1, n - 1, results);
        return results;
    }

    public void generateParenthesisHelper(String str, int remainLeftCount, int remainCount, int n, List<String> results) {
        // 达到总长度
        if (remainCount == 0) {
            results.add(str);
        } else {
            // 已有的（数量小与N
            if (n > 0) {
                generateParenthesisHelper(str + "(", remainLeftCount + 1, remainCount - 1, n - 1, results);
            }
            // 为配对的（大于0
            if (remainLeftCount > 0) {
                generateParenthesisHelper(str + ")", remainLeftCount - 1, remainCount - 1, n, results);
            }
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis demo = new GenerateParenthesis();
        List<String> strings = demo.generateParenthesis(3);
        strings.forEach(System.out::println);

    }

}
