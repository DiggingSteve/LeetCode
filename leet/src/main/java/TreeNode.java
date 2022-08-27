

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
        if(node!=null){
            q.push(node);
        }
        while (!q.isEmpty()||node!=null){
            if(node!=null)q.push(node);
            if(node.left!=null){
                q.push(node.left);
                node=node.left;
            }
            if(!q.isEmpty()){
                node=q.pop();
                System.out.println(node.val);
                node=node.right;
            }
        }
    }
}
