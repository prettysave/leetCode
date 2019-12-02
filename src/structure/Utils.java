package structure;

/**
 * @Auther: heyong
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
}
