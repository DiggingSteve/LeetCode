import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


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

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] days = new int[13];
        for (int i = 0; i < monthDays.length; i++) {
            days[i + 1] = monthDays[i] + days[i];// 将每个月转换成天数
        }
        int arrAliceDay = days[getMonth(arriveAlice)-1] + getDay(arriveAlice);

        int leaveAliceDay = days[getMonth(leaveAlice)-1] + getDay(leaveAlice);

        int arrBobDay = days[getMonth(arriveBob)-1] + getDay(arriveBob);

        int leaveBobDay = days[getMonth(leaveBob)-1] + getDay(leaveBob);

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
}
