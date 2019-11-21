/**
 * @Auther: heyong
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
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = longestPalindromeHelper(s, i, i);
            int len2 = longestPalindromeHelper(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > right - left + 1) {
                left = i - (maxLen - 1) / 2;
                right = i + maxLen / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    public static int longestPalindromeHelper(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);

    }
}
