import java.util.HashSet;
import java.util.Set;
import structure.ListNode;

/**
 * @author: heyong
 */
//给定一个链表，判断链表中是否有环。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
// 
//
//示例 1：
//
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
//示例 2：
//
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
//示例 3：
//
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
//
//
// 
//
//进阶：
//
//你能用 O(1)（即，常量）内存解决此问题吗？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/linked-list-cycle
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode next = head;
        while (next != null) {
            if (nodeSet.contains(next)) {
                return true;
            }
            nodeSet.add(next);
            next = next.next;
        }
        return false;
    }

    public boolean solution2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (slowNode != null && fastNode != null && fastNode.next != null) {
            if (slowNode == fastNode) {
                return true;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return false;
    }


}
