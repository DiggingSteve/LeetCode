using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LeetCode.Problem;

namespace LeetCode
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = new ProAddTwoNum();
            var l1 = new ProAddTwoNum.ListNode(1) { next = new ProAddTwoNum.ListNode(8) { next = new ProAddTwoNum.ListNode(3) } };
            var l2 = new ProAddTwoNum.ListNode(0);
            a.AddTwoNumbers(l1, l2);
        }
    }
}
