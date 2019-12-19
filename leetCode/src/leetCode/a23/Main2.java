package leetCode.a23;

/**
 * ���η�   
 * ����ʽ�Ľ�������Ե���������ϲ���ѭ�������һ�����������һ������ϲ�������һ������λ�ã�
 * ���ѭ����ֻ���������еĵ�һ������
 * @author lsir
 *
 */
public class Main2 {
	 public ListNode mergeKLists(ListNode[] lists) {
		 int len = lists.length;
		 if(len == 0) return null;
		 int mid = len/2;
		 while(mid>1) {
			 for(int i=0;i<mid;i++) {
				 lists[i] = mergeTwoList(lists[i], lists[len-i-1]);
			 }
			 len = (len+1)/2;
			 mid = len/2;
		 }
		 return lists[0];
	 }
	 
	 @SuppressWarnings("unused")
	public ListNode mergeTwoList(ListNode node1,ListNode node2) {
		 if(node1 == null) return node2;
		 if(node2 == null) return node1;
		 ListNode head = new ListNode(1);
		 ListNode p = head;
		 while(node1 != null && node2 != null) {
			 if(node1.val<=node2.val) {
				 p.next = node1;
				 node1 = node1.next;
			 }else {
				 p.next = node2;
				 node2 = node2.next;
			 }
			 p = p.next;
		 }
		 if(node1 != null) {
			 p.next = node1;
		 }
		 if(node2 != null) {
			 p.next = node2;
		 }
		 return head.next;
	 }
	        

}


