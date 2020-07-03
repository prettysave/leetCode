import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: heyong
 */
//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
//
//示例：
//
//输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"
//说明：
//
//如果 S 中不存这样的子串，则返回空字符串 ""。
//如果 S 中存在这样的子串，我们保证它是唯一的答案。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/minimum-window-substring
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class MinWindows {

    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        Map<Character, Integer> tMap = new HashMap<>(sLength);
        Map<Character, Integer> currMap = new HashMap<>(tLength);

        for (int i = 0; i < tLength; i++) {
            char tChar = t.charAt(i);
            tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
        }
        int currLeft = 0;
        int currRight = 0;
        int resultLeft = 0;
        int resultRight = 0;
        int minLength = Integer.MAX_VALUE;
        while (currRight < sLength) {
            char sChar = s.charAt(currRight);
            if (tMap.containsKey(sChar)) {
                currMap.put(sChar, currMap.getOrDefault(sChar, 0) + 1);
            }
            while (check(tMap, currMap) && currLeft <= currRight) {
                int currLength = currRight - currLeft + 1;
                // 如果找到更小的值 则更新result
                if (currLength <= minLength) {
                    minLength = currLength;
                    resultRight = currRight;
                    resultLeft = currLeft;
                }
                char leftChar = s.charAt(currLeft);
                if (tMap.containsKey(leftChar)) {
                    currMap.put(leftChar, currMap.getOrDefault(leftChar, 0) - 1);
                }
                currLeft++;
            }
            currRight++;
        }

        return minLength <= sLength ? s.substring(resultLeft, resultRight + 1) : "";
    }

//    private boolean check(Map<Character, Integer> tMap, Map<Character, Integer> currMap) {
//        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
//            Integer value = currMap.getOrDefault(entry.getKey(), 0);
//            // 发现有一个字符不满足条件 则返回false 不用继续检查
//            if (value < entry.getValue()) {
//                return false;
//            }
//        }
//        // 到这一步说明前面的检查都通过了
//        return true;
//    }

    public boolean check(Map<Character, Integer> tMap, Map<Character, Integer> currMap) {
        Iterator iter = tMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (currMap.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinWindows instance = new MinWindows();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = instance.minWindow(s, t);
        System.out.println(s1);
    }


}
