import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * @description:
 * @author: yaodui
 * @time: 2022/8/23 17:32
 */

public class Leet {
    public static void main(String[] args) {
        testPreOrder();
    }

    @Test
    private static void testPreOrder() {
        TreeNode root = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        List<Integer> list = new ArrayList<>();
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        //root.preOrder(root);
        // root.inorderTraversal(root);
        //root.postorderRecursion(root);
        // root.postorder(root);
        root.depth(root);
    }

    @Test
    private static void testmaxAncestorDiff() {
        TreeNode root = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);


        List<Integer> list = new ArrayList<>();
        root.left = b;
        root.right = c;


        //root.preOrder(root);
        // root.inorderTraversal(root);
        //root.postorderRecursion(root);
        // root.postorder(root);
        // root.depth(root);
        root.connect(root);
    }

    private void testNumIsLands() {
        NumIslands t = new NumIslands();
        char[][] arr = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        t.bfsnumIsIslands(arr);
    }

    @Test
    private static void testPalindrome() {
        String s = "aacabkacaa";
        Palindrome p = new Palindrome();
        p.isPalindrome(9999);
    }

    @Test
    private static void testCamel() {
        String[] queries = new String[]{"FooBar"};
        String p = "FoBaT";
        TwoPointer t = new TwoPointer();
        t.camelMatch(queries, p);
    }

    @Test
    private static void test() {
        String arriveAlice = "10-01";
        String leaveAlice = "10-31";
        String arriveBob = "11-01";
        String leaveBob = "12-31";
        countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
    }

    @Test
    public  static  void testBuildTree(){
        TreeNode t=new TreeNode();

        int[] a1=new int[]{3,9,20,15,7};
        int [] a2=new int[]{9,3,15,20,7};
        t.dfs2(a1,a2);
    }

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] days = new int[13];
        for (int i = 0; i < monthDays.length; i++) {
            days[i + 1] = monthDays[i] + days[i];// 将每个月转换成天数
        }
        int arrAliceDay = days[getMonth(arriveAlice) - 1] + getDay(arriveAlice);

        int leaveAliceDay = days[getMonth(leaveAlice) - 1] + getDay(leaveAlice);

        int arrBobDay = days[getMonth(arriveBob) - 1] + getDay(arriveBob);

        int leaveBobDay = days[getMonth(leaveBob) - 1] + getDay(leaveBob);

        if (leaveAliceDay < arrBobDay || leaveBobDay < arrAliceDay) return 0;
        return Math.min(leaveAliceDay, leaveBobDay) - Math.max(arrAliceDay, arrBobDay);


    }

    private static int getMonth(String date) {
        int d = Integer.parseInt(date.substring(0, 2));
        return d;
    }

    private static int getDay(String date) {
        int d = Integer.parseInt(date.substring(3, 5));
        return d;
    }

    @Test
    public static  void testLongestValidParentheses(){
       longestValidParentheses("");
    }
    public static int longestValidParentheses(String s) {
        s="()()())";
        int maxCount = 0;

        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if(stack.isEmpty()){
                    stack.push(i);// 空栈记录右括号
                }
                else {
                    if(arr[stack.peek()]=='('){
                        stack.pop();
                    }
                    else {
                        stack.push(i);
                    }

                    //每次触发更新长度都是右括号触发的 当前索引减去上一个没匹配的括号 可能是左也可能是右括号 极端情况下
                    //
                        maxCount=Math.max(i-(stack.isEmpty()?-1: stack.peek()),maxCount);



                }
            }

        }
        return maxCount;
    }

    //leet 300 最长递增序列
    //给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //
    //子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    //
    // 
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/longest-increasing-subsequence
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)return 0;
        int n=nums.length;
        int result=0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        //定义dp[i]是以nums[i]结尾的最长子序列的长度
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                   dp[i]=Math.max(dp[i],dp[j]+1);
                }

            }
            if (dp[i] > result) result = dp[i]; // 取长的子序列
        }
        return  result;
    }

    @Test
    public void  testGraph(){
        Vertex a=new Vertex(0);
        Vertex b=new Vertex(1);
        Vertex c=new Vertex(2);
        Vertex d=new Vertex(3);
        Vertex e=new Vertex(4);
        Vertex f=new Vertex(5);
        Vertex vertices[]=new Vertex[]{a,b,c,d,e,f};
        Graph g=new Graph(vertices);
        g.addEdge(a,b);
        g.addEdge(a,c);
        g.addEdge(b,d);
        g.addEdge(c,e);
        g.addEdge(d,f);
       // g.addEdge(b,f);
        g.addEdge(e,f);
//        g.showGraph();
//
//        g.dfs(a);

        g.bfsFindPath(a,d);
        g.bfsFindPath(a,b);
        g.bfsFindPath(a,f);

    }
}
