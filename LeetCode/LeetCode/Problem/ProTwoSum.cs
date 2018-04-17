using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCode.Problem
{
    public class ProTwoSum
    {

        // 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

        // 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

        //示例:

        //给定 nums = [2, 7, 11, 15], target = 9

        //因为 nums[0] + nums[1] = 2 + 7 = 9
        //所以返回[0, 1]

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
