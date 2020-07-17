import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author: heyong
 */
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
//说明：
//
//拆分时可以重复使用字典中的单词。
//你可以假设字典中没有重复的单词。
//示例 1：
//
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//示例 2：
//
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//示例 3：
//
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/word-break
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        // 单词的集合 用来判断字符串中剩余部门是否
        HashSet<String> wordSet = new HashSet<>(wordDict);
        // 字符串开头-每个index的截取部分是否满足条件
        boolean[] dp = new boolean[s.length() + 1];
        // 初始值 设置为true
        dp[0] = true;
        // 依次截取字符串 判断是否满足 "给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词"
        for (int i = 0; i <= s.length(); i++) {
            // j把字符s.substring(o, i)拆成s.substring(0, j)和s.substring(j, i)两部分
            // dp[j]表示s.substring(0, j)是否满足拆分条件
            for (int j = 0; j < i; j++) {
                // dp[j]满足条件 && 拆分剩下的字符串也在列表中
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    // 说明s.substring(o, i)字符串是可以拆分的 dp[i]设值后可以停止循环
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> strings = Arrays.asList("leet", "code");
        WordBreak instance = new WordBreak();
        boolean result = instance.wordBreak(s, strings);
        System.out.println(result);
    }

}
