

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: yaodui
 * @time: 2022/8/24 14:09
 */

public class TreeNode {
    public String value;
    public  int val;
    public TreeNode left;
    public TreeNode right;
    public  TreeNode next;

    public TreeNode(String x){
        value =x;
    }

    public TreeNode (int x){
        val=x;
    }
    public TreeNode(){

    }

    @Override
    public String toString(){
        return "["+ value +"]";
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
            if(list.isEmpty()){
                node.next=null;
            }
            if(node.left!=null){
                list.add(node.left);
                if(node.right!=null){
                    node.left.next=node.right;
                }
            }
            if(node.right!=null){
                list.add(node.right);
            }
        }

    }

    // lc填充每个节点的下一个右侧节点指针
    public TreeNode connect(TreeNode root) {
        if(root==null)
            return root;
        TreeNode temp=root;
        temp.next=null;
        //需要用到队列 输出前将左右子节点加入队列
        Queue<TreeNode> list=new LinkedList<>();
        list.add(root);
        TreeNode preNode=null;
        for(int i=0;i<list.size();i++) {

            TreeNode node=list.poll();
            if (preNode != null) {
                preNode.next = node;
            }
            preNode=node;
            if(node.left!=null){
                list.add(node.left);
            }
            if(node.right!=null){
                list.add(node.right);
            }
        }
        return root;
    }

    public int depth(TreeNode node){
        if(node==null)return 0;
        int leftDepth=depth(node.left);
        int rightDepth=depth(node.right);
        int c= Math.max(leftDepth,rightDepth)+1;
        return c;
    }

    //1026 节点与其祖先之间的最大差值
    // 思路 dfs查找父子之间最大 和最小节点 因为差值取绝对值 不需要父节点大于子节点
    int ans=0;
    public int maxAncestorDiff(TreeNode root) {

        dfs(root,root.val, root.val);

        return  ans;
    }

    private void dfs(TreeNode node,int maxNum,int minNum){
        if(node==null)return;
        if(node.val >maxNum){
            maxNum=node.val;
        }
        if(node.val<minNum){
            minNum=node.val;
        }
      ans=Math.max(ans,Math.abs(maxNum-minNum));
        dfs(node.left,maxNum,minNum);
        dfs(node.right,maxNum,minNum);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

      return   dfs(inorder,postorder);

    }
    public TreeNode dfs(int[] inorder,int[] postorder){

        int len2=postorder.length;
        TreeNode root=new TreeNode();
        if(inorder.length==0)return null;
        if(inorder.length==1){
            root.left=null;
            root.right=null;
            return  root;
        }

        root.val=postorder[len2-1];
        int index=0;
        while(inorder[index]!=root.val){
            index++;
        }
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inorderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, inorderLeft.length);
        int[] postorderRight = Arrays.copyOfRange(postorder, inorderLeft.length, postorder.length - 1);


        root.left = dfs(inorderLeft, postorderLeft);
        root.right = dfs(inorderRight, postorderRight);

        return root;



    }

    public TreeNode dfs2(int[] preorder,int[] inorder){

     // 先序遍历第一个就是根节点 紧随其后的是左节点 剩下是右子树 参考中序遍历 后序遍历做法 依旧对中序遍历做递归

        if(inorder.length==0)return null;
        int rootVal = preorder[0];
        //创建跟结点
        TreeNode root = new TreeNode(rootVal);
        int index=0;
        while(inorder[index]!=root.val){
            index++;
        }
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inorderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);

     int [] pre= Arrays.copyOfRange(preorder, 1, preorder.length);


        root.left = dfs2(pre, inorderLeft);
        root.right = dfs2(pre, inorderRight);

        return root;



    }

    //bfs 拼接字符串
    public String serialize(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<TreeNode>();
        if(root==null)return "#";
        StringBuilder res = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();//当前层大小
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if (node == null) {
                    res.append("#,");
                    continue;
                }
                //如果节点不为空，把当前节点的值加入到字符串中，
                //注意节点之间都是以逗号","分隔的，在下面把字符
                //串还原二叉树的时候也是以逗号","把字符串进行拆分
                res.append(node.val + ",");

                queue.add(node.left);


                queue.add(node.right);

            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "#")
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        //因为上面每个节点之间是以逗号","分隔的，所以这里
        //也要以逗号","来进行拆分
        String[] values = data.split(",");
        //上面使用的是BFS，所以第一个值就是根节点的值，这里创建根节点
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            //队列中节点出栈
            TreeNode parent = queue.poll();
            //因为在BFS中左右子节点是成对出现的，所以这里挨着的两个值一个是
            //左子节点的值一个是右子节点的值，当前值如果是"#"就表示这个子节点
            //是空的，如果不是"#"就表示不是空的
            if (!"#".equals(values[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            //上面如果不为空就是左子节点的值，这里是右子节点的值，注意这里有个i++，
            if (!"#".equals(values[++i])) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;


    }


}
