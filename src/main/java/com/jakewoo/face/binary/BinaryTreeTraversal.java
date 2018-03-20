package com.jakewoo.face.binary;



import java.util.Stack;

/**
 * 二叉树遍历
 * 先序遍历
 * 后序遍历
 * 中序遍历
 *
 * 递归遍历
 * 非递归遍历
 */
public class BinaryTreeTraversal {

    class BTree{
        BTree leftBTree;
        BTree rightBTree;
        Integer data;
    }

    /**
     * 先序遍历
     * @param bTree
     */
    public static void preTraversal4Recursion(BTree bTree){
        if (bTree == null){
            return ;
        }

        System.out.println(bTree.data);
        if(bTree.leftBTree != null){
            preTraversal4Recursion(bTree.leftBTree);
        }
        if (bTree.rightBTree != null){
            preTraversal4Recursion(bTree.rightBTree);
        }
    }

    /**
     * 后序遍历
     * @param bTree
     */
    public static void epilogueTraversal4Recursion(BTree bTree){
        if (bTree == null){
            return ;
        }

        if(bTree.leftBTree != null){
            epilogueTraversal4Recursion(bTree.leftBTree);
        }
        if (bTree.rightBTree != null){
            epilogueTraversal4Recursion(bTree.rightBTree);
        }
        System.out.println(bTree.data);
    }

    /**
     * 中序遍历
     * @param bTree
     */
    public static void infixTraversal4Recursion(BTree bTree){
        if (bTree == null){
            return ;
        }

        if(bTree.leftBTree != null){
            infixTraversal4Recursion(bTree.leftBTree);
        }
        System.out.println(bTree.data);
        if (bTree.rightBTree != null){
            infixTraversal4Recursion(bTree.rightBTree);
        }
    }

    /**
     * 先序遍历,非递归实现
     * @param bTree
     */
    public static  void  preTraversal(BTree bTree){
        Stack<BTree> stack = new Stack();
        while (bTree != null || !stack.empty()){
            //将所有节点的左边的子节点全部放入堆中
            while (bTree != null){
                //先打印当前数据
                System.out.println(bTree.data);
                //当前节点放入堆中
                stack.push(bTree);
                //获取当前节点的左边的节点
                bTree = bTree.leftBTree;
            }
            //左边的遍历完了 遍历右边的.
            if (!stack.empty()){
                bTree = stack.pop();
                bTree = bTree.rightBTree;
            }
        }
    }

    /**
     * 后序遍历
     * @param bTree
     */
    public static void epilogueTraversal(BTree bTree){

        Stack<BTree> stack = new Stack<BTree>();
        Stack<Integer> flagStack = new Stack<Integer>();
        /*
                3
              __|__
             |     |
             5     7
         */

        Integer flag = 1;//是否可以打印的标记
        while (bTree != null && !stack.empty()){
            while (bTree != null){
                //当前节点放入堆中
                stack.push(bTree);          //3,0  |5,0     //7,0
                //设置打印标记为0 标示当前节点不能打印
                flagStack.push(0);
                //获取当前节点的左节点,重新进行判断.直到最后左边没有节点
                bTree = bTree.leftBTree;
            }
            //判断是否可以打印
            while (!stack.empty() && flagStack.peek().equals(flag)){        //5,1       //3,1 |7,0      //3,1 |7,1
                flagStack.pop();
                System.out.println(stack.pop().data);       //sout(5) //3,0     //sout(7) //3,1 //sout(3)
            }
            //从第一个 while 循环过来,表示这个最左边的节点没有左边子节点了,
            if (!stack.empty()){
                flagStack.pop();
                flagStack.push(1);
                //看下节点有没有右节点
                bTree = stack.peek();       //5,1       //3,1       //7,1
                bTree = bTree.rightBTree;       //7,
            }
        }
    }

    /**
     * 中序遍历,非递归实现
     *  -- 左边的打完了打中间的.
     * @param bTree
     */
    public static  void  infixTraversal(BTree bTree){
        Stack<BTree> stack = new Stack();
        while (bTree != null || !stack.empty()){

            while (bTree != null){
                //先把当前节点存起来.
                stack.push(bTree);
                //然后获取当前节点的左节点.再存起来
                bTree = bTree.leftBTree;
            }
            if (!stack.empty()){
                //获取最后一个节点.
                bTree = stack.pop();
                //打印它
                System.out.println(bTree.data);
                //再尝试获取这个节点的右节点.然后再走上边的循环
                bTree = bTree.rightBTree;
            }
        }
    }
}
