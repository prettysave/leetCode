public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();

        String[] strings = {"flower", "flow", "flight","fli","fl"};
        String[] strings1 = {"dog", "racecar", "car"};
        String[] strings2 = {"a","a"};
        String s = prefix.longestCommonPrefix(strings);
        String s1 = prefix.longestCommonPrefix(strings1);
        String s2 = prefix.longestCommonPrefix(strings2);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 遍历第一个字符串的每一个字符 与数组中其他字符每一个对应下标的字符比较
        // 当出现字符不相等或其他字符已经到头的情况下结束循环
        for (int i = 0; i < strs[0].length() ; i++){
            // 第一个字符在i index下的字符char
            char c = strs[0].charAt(i);
            // 遍历数组中其他的字符串 依次做判断
            for (int j = 1; j < strs.length; j ++) {
                // 当前字符串的长度与i相等时&&当前字符串在i下标位置与第一个字符串的i下标位置的字符不同
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    // 返回结果值 退出循环
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
