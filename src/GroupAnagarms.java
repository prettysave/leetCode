/**
 * @author: heyong
 */


import structure.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: heyong
 */
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//示例:
//
//输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//说明：
//
//所有输入均为小写字母。
//不考虑答案输出的顺序。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/group-anagrams
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class GroupAnagarms {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return Collections.emptyList();
        }
        Map<String, List<String>> strMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String originalStr = strs[i];
            char[] chars = originalStr.toCharArray();
            // 将字符数组自然排序 字母异位词的字符数组排序之后再组合的string是一样的
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            // 如果有Key就往value里加值 没有就新建list
            List<String> strList = strMap.get(str);
            if (strList != null) {
                strList.add(originalStr);
            } else {
                strMap.put(str, new ArrayList<>(Collections.singletonList(originalStr)));
            }
        }
        // 只取values就是结果集了
        return new ArrayList<>(strMap.values());
    }

    public static void main(String[] args) {
        GroupAnagarms demo = new GroupAnagarms();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = demo.groupAnagrams(strs);

        Utils.printArrayList(result);
    }

}
