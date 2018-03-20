package com.jakewoo.face.list;

import java.util.List;

/**
 * 链表反转
 */
public class ListInversion {

    /**
     * 链表节点定义
     */
    class ListNode{
        int data;
        ListNode next;
    }

    /**
     * 将链表进行反转
     * -- 递归方式
     *
     * 4->3->2->1
     * @param head
     * @return
     */
    public static ListNode listInversion(ListNode head){
        if (head== null || head.next == null){
            return head;
        }

        ListNode reHead = listInversion(head.next);// 3->2->1       //2->1  | reHead == 1

        head.next.next = head; // head == 2->1  | head.next.next = null | head.next = 1 | => 1->2
                                //3->2->null  | head.next.next = null  | => 1->2->3
        head.next = null;       // 断掉 2->1 的指向
                                // 断掉 3->2 的指向

        return reHead; //return 返回 , 进行 3.2.1 的反转
    }

    /**
     * 将链表进行反转
     * @param head
     * @return
     */
    public static ListNode listInversion4(ListNode head){
        ListNode reHead = null;
        while (head != null){
            //head == 4-3-2-1-null
                //head == 3-2-1-null
                    //head == 2-1-null
                        //1-null
            ListNode tmp = head.next;
            //tmp == 3-2-1-null
                //tmp == 2-1-null
                    //tmp == 1-null
                        //tmp == null
            head.next = reHead;
            //head.next == null         | head == 4
                //head.next == 4-null       | head == 3
                    //head.next == 3-4-null     |head == 2
                        //head.next == 2-3-4-null   |head == 1
            reHead = head;
            //reHead == 4-null
                //reHead == 3-4-null
                    //rehead == 2-3-4-null
                        //rehead == 1-2-3-4-null
            head = tmp;
            //head == 3-2-1-null
                //head == 2-1-null
                    //head == 1-null
                        //head == null
        }
        return reHead;
    }
}
