import structure.ListNode;

/**
 * @Auther: heyong
 * @Date: 2019-11-27 15:46
 * @Description:
 */

//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//示例：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 校验 如有有一个listNode为null 直接返回另一个
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l1NextNode = l1;
        ListNode l2NextNode = l2;
        ListNode result = new ListNode(-1);
        ListNode next = result;
        // 只要两个Node中有一个还有值即可进行
        while (l1NextNode != null || l2NextNode != null) {

            // 当有一个Node是Null的时候 把另外一个ListNode的剩余部分直接链上result 退出循环
            if (l1NextNode == null) {
                next.next = l2NextNode;
                break;
            }
            if (l2NextNode == null) {
                next.next = l1NextNode;
                break;
            }

            // 根据较小值构造一个新结点 并链到result上
            ListNode newNode = new ListNode(Math.min(l1NextNode.val, l2NextNode.val));
            next.next = newNode;
            next = next.next;

            // 被链上的Node后移
            if (l1NextNode.val > l2NextNode.val) {
                l2NextNode = l2NextNode.next;
            } else {
                l1NextNode = l1NextNode.next;
            }
        }

        //  结果是第二个
        return result.next;
    }
}
