import structure.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        // 初始状态
        ListNode node = new ListNode();
        node.next = head;

        ListNode cur = node;
        // 不为空则一直遍历
        while (cur.next != null && cur.next.next != null) {
            // 值相等
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;

                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                // 值不相等 不
                cur = cur.next;
            }
        }
        return node.next;
    }


}
