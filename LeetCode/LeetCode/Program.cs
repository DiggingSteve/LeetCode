using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GuidCollisionDetector
{
    class Program
    {
        public static int bitSquareSum(int n)
        {
            int sum = 0;
            while (n > 0)
            {
                int bit = n % 10;
                sum += bit * bit;
                n = n / 10;
            }
            return sum;
        }

        public static bool isHappy(int n)
        {
            int slow = n, fast = bitSquareSum(n);
            while (slow != fast)
            {
                slow = bitSquareSum(slow);
                fast = bitSquareSum(fast);
                fast = bitSquareSum(fast);
            }
            return slow == 1;
        }
        static void Main(string[] args)
        {
            isHappy(19);
        }
    }
}