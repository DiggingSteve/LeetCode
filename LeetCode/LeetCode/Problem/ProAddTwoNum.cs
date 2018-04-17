using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCode.Problem
{
    //    给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

    //你可以假设除了数字 0 之外，这两个数字都不会以零开头。

    //示例：

    //输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    //输出：7 -> 0 -> 8
    //原因：342 + 465 = 807
    public class ProAddTwoNum
    {

        /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */

        public class ListNode
        {
            public int val;
            public ListNode next;
            public ListNode(int x) { val = x; }
        }

        public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
        {
            ListNode head = new ListNode(0);
            ListNode curr = head;
            while (l1 != null || l2 != null)
            {
                int p1 = l1 != null ? l1.val : 0;
                int p2 = l2 != null ? l2.val : 0;
                int sum = (curr.val + p1 + p2) % 10;
                bool carryFlag = (curr.val + p1 + p2) >= 10;
                curr.val = sum;
                if (carryFlag)
                {
                    curr.next = new ListNode(1);
                    curr = curr.next;
                }
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
                if ((l1 != null || l2 != null) && !carryFlag) { curr.next = new ListNode(0); curr = curr.next; }

            }

            return head;
        }
    }
}
