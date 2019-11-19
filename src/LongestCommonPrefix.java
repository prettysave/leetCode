public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();

        String[] strings = {"flower", "flow", "flight"};
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
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
