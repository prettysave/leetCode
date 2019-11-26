
import java.util.*;

/**
 * @Auther: heyong
 * @Date: 2019-11-25 18:50
 * @Description:
 */

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//示例:
//
//输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class LetterCombinations {

    private static final Map<Character, List<Character>> dictionaryMap = new HashMap<>();
    
    static {
        dictionaryMap.put('2', Arrays.asList('a', 'b', 'c'));
        dictionaryMap.put('3', Arrays.asList('d', 'e', 'f'));
        dictionaryMap.put('4', Arrays.asList('g', 'h', 'i'));
        dictionaryMap.put('5', Arrays.asList('j', 'k', 'l'));
        dictionaryMap.put('6', Arrays.asList('m', 'n', 'o'));
        dictionaryMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        dictionaryMap.put('8', Arrays.asList('t', 'u', 'v'));
        dictionaryMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits.length() != 0) {
            findCombination(digits, "", results);
        }
        return results;
    }

    // 递归拼接字符串
    public static void findCombination(String digits, String prefix, List<String> results) {
        char c = digits.charAt(0);
        String newDigits = digits.substring(1);
        List<Character> characters = dictionaryMap.get(c);
        for (char partChar : characters) {
            String newPrefix = prefix + partChar;
            if (newDigits.length() == 0) {
                results.add(newPrefix);
            } else {
                findCombination(newDigits, newPrefix, results);
            }
        }

    }

    public static void main(String[] args) {
        String str = "23";
        List<String> results = letterCombinations(str);
        results.forEach(System.out::println);
    }

}
