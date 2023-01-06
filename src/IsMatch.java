import java.text.ParseException;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3：
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        // 表示当S字符串为I长度，P字符串为J长度的时候 结果是true/false
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;

        // s为null的情况
        // *号允许前一个字符匹配0次 即可直接消除
        for (int k = 1; k <= pLength; k++) {
            if (cp[k - 1] == '*') {
                dp[0][k] = dp[0][k - 2];
            }
        }

        // TODO: 2023/1/6 有进一步压缩使用内存的空间
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {

                // 匹配的上 s、p 皆消除当前字符 结果就看剩下的字符是否匹配
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                    // 退出当前循环
                    continue;
                }

                // p当前字符为* 分情况处理
                if (cp[j - 1] == '*') {
                    // *前面的字符可以匹配上
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                        // 前一个字符匹配0次 p消除*与前一个字符
                        dp[i][j] = dp[i][j - 2]
                                // 前一个字符匹配1次及以上 消除i的当前字符
                                || dp[i - 1][j];
                        // 退出当前循环
                        continue;
                    }
                    // *前面的字符无法匹配上 只能匹配0次  p消除*与前一个字符
                    dp[i][j] = dp[i][j - 2];
                }
                // 默认是false 此处不需要再赋值为false
            }
        }
        return dp[sLength][pLength];
    }

    public static void main(String[] args) throws ParseException {

        IsMatch instance = new IsMatch();

        String s = "aa";
        String p = "a";
        boolean result = instance.isMatch(s, p);
        System.out.println(result);

        String s1 = "aa";
        String p1 = "a*";
        boolean result1 = instance.isMatch(s1, p1);
        System.out.println(result1);

        String s2 = "ab";
        String p2 = ".*";
        boolean result2 = instance.isMatch(s2, p2);
        System.out.println(result2);
    }

}
