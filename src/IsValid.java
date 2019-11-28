import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Auther: heyong
 * @Date: 2019-11-27 12:27
 * @Description:
 */

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。
//
//示例 1:
//
//输入: "()"
//输出: true
//示例 2:
//
//输入: "()[]{}"
//输出: true
//示例 3:
//
//输入: "(]"
//输出: false
//示例 4:
//
//输入: "([)]"
//输出: false
//示例 5:
//
//输入: "{[]}"
//输出: true
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/valid-parentheses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class IsValid {

    private static final Map<Character, Character> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put(']', '[');
        dictionaryMap.put('}', '{');
        dictionaryMap.put(')', '(');
    }

    // 用栈存取的方法
    public boolean isValid(String s) {
        int length = s.length();

        if (length == 0) {
            return true;
        }
        if (length % 2 == 1) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList();
        for (int i = 0; i < length; i++) {
            if (stack.size() > length / 2) {
                return false;
            }
            char element = s.charAt(i);
            if (dictionaryMap.containsKey(element)) {
                char topElement = stack.isEmpty() ? ' ' : stack.pop();
                if (!dictionaryMap.get(element).equals(topElement)) {
                    return false;
                }
            } else {
                stack.push(element);
            }
        }
        return stack.isEmpty();
    }

    // 字符串替换（很慢）
    public boolean isValid1(String s) {
        int length = s.length();

        if (length == 0) {
            return true;
        }
        if (length % 2 == 1) {
            return false;
        }
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            if (s.contains("()")) {
                s = s.replaceAll("\\(\\)", "");
            }
            if (s.contains("[]")) {
                s = s.replaceAll("\\[]", "");
            }
            if (s.contains("{}")) {
                s = s.replaceAll("\\{}", "");
            }
        }

        return "".equals(s);
    }

    public static void main(String[] args) {
        IsValid demo = new IsValid();

        String str = "()[]{}";
        String str1 = "(([]){})";
        boolean result = demo.isValid1(str);
        System.out.println(result);
        boolean result1 = demo.isValid1(str1);
        System.out.println(result1);
    }

}
