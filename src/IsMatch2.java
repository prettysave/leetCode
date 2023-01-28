import java.text.ParseException;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 */
public class IsMatch2 {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        // 表示当S字符串为I长度，P字符串为J长度的时候 结果是true/false
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;

        // s为null的情况
        // p存在不为*的字符 则后面的都为false
        for (int k = 1; k <= pLength; k++) {
            if (cp[k - 1] == '*') {
                dp[0][k] = true;
            } else {
                break;
            }

        }

        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                // 不使用这个星号，那么就会从dp[i][j−1] 转移而来
                // 使用这个星号，那么就会从dp[i−1][j] 转移而来
                if (cp[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    continue;
                }

                if (cp[j - 1] == '?' || cp[j - 1] == cs[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 默认是false 此处不需要再赋值为false
            }
        }
        return dp[sLength][pLength];
    }

    public static void main(String[] args) throws ParseException {

        IsMatch2 instance = new IsMatch2();

        String s = "aa";
        String p = "1";
        boolean result = instance.isMatch(s, p);
        System.out.println(result);

        String s1 = "aa";
        String p1 = "*";
        boolean result1 = instance.isMatch(s1, p1);
        System.out.println(result1);

        String s2 = "cb";
        String p2 = "?a";
        boolean result2 = instance.isMatch(s2, p2);
        System.out.println(result2);

        String s3 = "adceb";
        String p3 = "*a*b";
        boolean result3 = instance.isMatch(s3, p3);
        System.out.println(result3);

        String s4 = "acdcb";
        String p4 = "a*c?b";
        boolean result4 = instance.isMatch(s4, p4);
        System.out.println(result4);
    }

}
