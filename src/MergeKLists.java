import structure.ListNode;
import structure.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: heyong
 * @Date: 2019-11-28 15:43
 * @Description:
 */

//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
//示例:
//
//输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> valList = new ArrayList<>();
        int i = 0;
        // 把K个链表的所有node都放到一个list里
        while (i < lists.length) {
            while (lists[i] != null) {
                valList.add(lists[i].val);
                lists[i] = lists[i].next;
            }
            i++;
        }
        // 给List排序
        Collections.sort(valList);

        ListNode result = new ListNode(-1);
        //遍历list构造链表
        ListNode next = result;
        for (int val : valList) {
            next.next = new ListNode(val);
            next = next.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        MergeKLists demo = new MergeKLists();
        ListNode[] nodes = new ListNode[3];

        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);
        nodes[0] = node;

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);
        nodes[1] = node1;

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(6);
        nodes[2] = node2;

        ListNode result = demo.mergeKLists(nodes);
        Utils.printListNode(result);

    }

}
