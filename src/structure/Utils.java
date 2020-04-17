package structure;

import java.util.List;

/**
 * @Author: heyong
 * @Date: 2019-11-29 15:51
 * @Description:
 */
public class Utils {

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void printArray(int[] nums, String name) {
        System.out.println(name + "的值：");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void printArrayList(List<List<Integer>> result) {
        result.forEach(list -> {
            System.out.println(list);
        });
    }
}
