using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCode.Problem
{
  public  class ProTwoSum
    {
        public static int[] TwoSum(int[] nums, int target)
        {

            int x = 0, y = 1;
            if (nums.Length == 2) return new int[] { x, y };
            Dictionary<int, int> map = new Dictionary<int, int>();
            for (int i = 0; i < nums.Length; i++)
            {
                int minusNum = target - nums[i];
                if (!map.ContainsKey(minusNum))
                {
                    map.Add(minusNum, i);
                }
                if (map.ContainsKey(nums[i]) && i != map[nums[i]])
                {
                    x = i;
                    y = map[nums[i]];
                    break;
                }
            }


            return new int[] { x, y };
        }
    }
}
