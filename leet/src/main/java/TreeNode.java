

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:
 * @author: yaodui
 * @time: 2022/8/24 14:09
 */

public class TreeNode {
    public String val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(String x){
        val=x;
    }
    public TreeNode(){

    }

    @Override
    public String toString(){
        return "["+val+"]";
    }

    // 棧完成前序遍歷
    public void preOrder(TreeNode node){
        Stack<TreeNode>stack=new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode n= stack.pop();
            System.out.println(n.toString());
            if(n.right!=null){
                stack.push(n.right);
            }
            if(n.left!=null){
                stack.push(n.left);
            }
        }
    }

    //递归先序遍历
    public void preOrderRecursion(TreeNode node){
        if(node==null)return;
        System.out.println(node.toString());
        preOrderRecursion(node.left);
        preOrderRecursion(node.right);

    }
//中序遍历 左节点-根节点-右节点
    public void inorderTraversal(TreeNode node){
        Stack<TreeNode>q=new Stack<>();

        while (!q.isEmpty()||node!=null){
            //左节点入栈到底
            while(node!=null){
                q.push(node);
                node=node.left;
            }
            if (!q.isEmpty()){
                //开始出栈输出最先输出的是左节点然后栈顶则是左节点的根节点,此时需要查找有没有右节点 有则入栈
                node=q.pop();
                System.out.println(node.toString());
                node=node.right;
            }
        }
    }

    public void inorderRecursion(TreeNode node){
        if(node==null)
            return;
        inorderRecursion(node.left);
        System.out.println(node.toString());
        inorderRecursion(node.right);
    }

    public void postorderRecursion(TreeNode node){
        if(node==null)return;
        postorderRecursion(node.left);
        postorderRecursion(node.right);
        System.out.println(node.toString());
    }

    //后序遍历
    public void postorder(TreeNode node){
        Stack<TreeNode>q=new Stack<TreeNode>();
        q.push(node);
        TreeNode c=new TreeNode();
        while (!q.isEmpty()){
            c=q.peek();//访问栈顶
           if(c.left!=null&&node!=c.left&&node!=c.right){
               q.push(c.left);
           }
           else if(c.right!=null&&node!=c.right){
               q.push(c.right);
           }
           else {

               System.out.println(c.toString());
               q.pop();
               node=c;
           }
        }
    }

    public void bfs(TreeNode node){
        //需要用到队列 输出前将左右子节点加入队列
        if(node==null)
            return;
        LinkedList<TreeNode>list=new LinkedList<>();
        list.add(node);
        while (!list.isEmpty()){
            node=list.poll();
            System.out.println(node.toString());
            if(node.left!=null){
                list.add(node.left);
            }
            if(node.right!=null){
                list.add(node.right);
            }
        }

    }

    public int depth(TreeNode node){
        if(node==null)return 0;
        int leftDepth=depth(node.left);
        int rightDepth=depth(node.right);
        int c= Math.max(leftDepth,rightDepth)+1;
        return c;
    }
}
