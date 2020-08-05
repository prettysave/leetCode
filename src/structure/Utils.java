package structure;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static <E> void printArrayList(List<List<E>> result) {
        result.forEach(System.out::println);
    }

    public static String getDateString() {
        LocalDate startDate = LocalDate.of(2019, 9, 1);
        LocalDate endDate = LocalDate.of(2020, 5, 1);
        String str = "";
        while (startDate.isBefore(endDate)) {
            str += "p" + startDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + ",";
            startDate = startDate.plusDays(1);
        }
        return str;
    }

    public static void main(String[] args) {
        String dateString = Utils.getDateString();
        System.out.println(dateString);
    }
}
