/**
 * @Auther heyong@huikeyun.com
 * @Date 2021/3/10
 */

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import sun.jvm.hotspot.utilities.Assert;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */
public class Calculate {
    public int getResult(String str) {
        Stack<Integer> number = new Stack<>();
        Stack<Character> symbol = new Stack<>();
        List<Character> symbolList = Arrays.asList('+', '-', '(', ')');


        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 为空结束本次循环
            if (c == ' ') {
                continue;
            }
            // 运算符
            if (symbolList.contains(c)) {
                if (symbol.size() == 0) {
                    symbol.push(c);
                    continue;
                }
                if (')' == c) {
                    Character topSymbol = symbol.pop();
                    char c1 = '(';
                    if (c1 != topSymbol) {
                        // 再推一个出来
                        symbol.pop();
                        Integer topNum = number.pop();
                        Integer bottomNum = number.pop();
                        number.push(helper(bottomNum, topNum, topSymbol));
                    }
                } else {
                    symbol.push(c);
                }
                // 数字
            } else {
                // char转成数字
                int currNum = c - '0';
                if (symbol.size() == 0 || '(' == symbol.peek()) {
                    number.push(currNum);
                    continue;
                }
                Character topSymbol = symbol.pop();
                Integer topNum = number.pop();
                number.push(helper(topNum, currNum, topSymbol));
            }
        }
        while (symbol.size() != 0) {
            Integer topNum = number.pop();
            Integer bottomNum = number.pop();
            number.push(helper(bottomNum, topNum, symbol.pop()));
        }
        return number.pop();
    }

    private int helper(int num1, int num2, char symbol) {
        if ('-' == symbol) {
            return num1 - num2;
        } else {
            return num1 + num2;
        }
    }

    public static void main(String[] args) {
        Calculate instance = new Calculate();
        int result = instance.getResult("(1+(4+5+2)-3)+(6+8)");
        Assert.that(result == 23, "error");
    }

}
