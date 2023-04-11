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
        List<Integer>list=new ArrayList<>();
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
    private static  void testPalindrome(){
        String s="aacabkacaa";
        Palindrome p=new Palindrome();
        p.longestPalindrome(s);
    }
}
