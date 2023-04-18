import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class TwoPointer {
    // 11题 盛最多水的容器
//    给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//    返回容器可以储存的最大水量。
//
//    说明：你不能倾斜容器。
//
//             
//
//    示例 1：
//
//
//
//    输入：[1,8,6,2,5,4,8,3,7]
//    输出：49
//    解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode.cn/problems/container-with-most-water
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int maxArea(int[] height) {
        int maxArea = 0;
        int preR = height.length - 1;
        for (int l = 0; l < height.length; l++) {
            for (int r = preR; r > 0; r--) {

                int x = r - l;
                int y = Math.min(height[r], height[l]);
                int area = x * y;
                if (maxArea < area) {
                    maxArea = area;


                }
                if (y == height[l]) {
                    preR = r;
                    break;
                }
            }

        }
        return maxArea;
    }

//   1023 驼峰式匹配 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
//
//    给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
//

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean>result=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            String str=queries[i];
            boolean isCamel=isMatch(str,pattern);
            result.add(isCamel);
        }
        return result;
    }

    private Boolean isMatch(String str,String pattern){
        char[] strArr= str.toCharArray();
        char[] pArr=pattern.toCharArray();
        boolean isLastPMatch=false;
        int i=0,j=0;
        for(;i<strArr.length;i++){
            char s=strArr[i];
            boolean isUpper=Character.isUpperCase(s);
            if(j== pArr.length){
                if(isUpper)return  false;
                continue;
            }
            char p=pArr[j];

            if(s==p){
                isLastPMatch=true;
                j++;
            }
            else isLastPMatch=false;
            if(isUpper&&s!=p)return false;
        }
        if(j<pArr.length-1)return false;
        return  isLastPMatch;
    }
}
