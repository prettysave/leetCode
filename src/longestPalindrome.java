/**
 * @Author: heyong
 * @Date: 2019-11-21 15:00
 * @Description:
 */
public class longestPalindrome {
    //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    //
    //示例 1：
    //
    //输入: "babad"
    //输出: "bab"
    //注意: "aba" 也是一个有效答案。
    //示例 2：
    //
    //输入: "cbbd"
    //输出: "bb"
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/longest-palindromic-substring
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 1) {
            return "";
        }
        int left = 0;
        int right = 0;
        // 以字符串中的每个字符为中心节点 向两边延伸得到最长的回文串
        for (int i = 0; i < s.length() - 1; i++) {
            // 回文串字符个数为奇数
            int len1 = longestPalindromeHelper(s, i, i);
            // 回文串字符个数为偶数
            int len2 = longestPalindromeHelper(s, i, i + 1);
            // 判断奇数回文串和偶数回文串的大小 取大的
            int maxLen = Math.max(len1, len2);
            // 和历史得到的最大回文串长度比较 如果当前比历史的大 则更新对应的Index
            if (maxLen > right - left + 1) {
                left = i - (maxLen - 1) / 2;
                right = i + maxLen / 2;
            }
        }
        // 根据得到的左边index 和右边index截取字符串
        return s.substring(left, right + 1);
    }

    public static int longestPalindromeHelper(String s, int left, int right) {
        // 左边&右边都没有越界 并且 左边的字符与右边的字符相同
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 不满足上述条件 返回当前回文串的长度
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);

    }
}
