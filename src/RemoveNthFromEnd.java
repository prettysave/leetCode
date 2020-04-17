import structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: heyong
 * @Date: 2019-11-26 13:19
 * @Description:
 */

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//示例：
//
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//说明：
//
//给定的 n 保证是有效的。
//
//进阶：
//
//你能尝试使用一趟扫描实现吗？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }

        List<ListNode> nodeList = new ArrayList<>();
        nodeList.add(head);
        ListNode next = head.next;
        while (next != null) {
            nodeList.add(next);
            next = next.next;
        }
        int index = nodeList.size() - n;
        if (index == 0) {
            if (nodeList.size() > 1 && nodeList.get(1) != null) {
                return nodeList.get(1);
            }
            return null;
        }
        ListNode leftNode = nodeList.get(index - 1);
        ListNode rightNode = null;
        if (nodeList.size() > index + 1) {
            rightNode = nodeList.get(index + 1);
        }
        leftNode.next = rightNode;

        return nodeList.get(0);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode listNode = removeNthFromEnd(node, 1);
    }

}
