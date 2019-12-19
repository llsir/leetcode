package leetCode.a23;

import java.util.PriorityQueue;

public class Main1 {
	 public ListNode mergeKLists(ListNode[] lists) {
	        if(lists == null || lists.length == 0 ) return null;
	        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode e1,ListNode e2)->{return e1.val-e2.val;});
	        for(ListNode node : lists){
	            if(node != null){
	                queue.add(node);
	            }
	        }
	        ListNode head = new ListNode(1);
	        ListNode p = head;
	        while(!queue.isEmpty()){
	            ListNode curent = queue.poll();
	            p.next = curent;
	            if(curent.next != null){
	                queue.add(curent.next);
	            }
	            p = p.next;
	        }
	        return head.next;
	    }
}

