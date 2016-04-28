package com.tutorialspoint.test;
class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
		next = null;
	}
}
public class SortLinkedList {
	public static ListNode insertionSortList(ListNode head){
		
		//if no node is passed or only one node is passed
		if(null==head || null==head.next)
			return head;
		
		//creating new node with the value passed
		ListNode newHead=new ListNode(head.val);
		ListNode pointer=head.next;
		
		//loop through each element in list
		while(null!=pointer){
			//insert the element to the new list
			ListNode innerPointer=newHead;
			ListNode next=pointer.next;
			if(pointer.val<=newHead.val){
				ListNode oldHead=newHead;
				newHead=pointer;
				newHead.next=oldHead;
			}else{
				 while(null!=innerPointer.next){
					 if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
							ListNode oldNext = innerPointer.next;
							innerPointer.next = pointer;
							pointer.next = oldNext;
						}
					 innerPointer = innerPointer.next;
				 }
				 if (innerPointer.next == null && pointer.val > innerPointer.val) {
						innerPointer.next = pointer;
						pointer.next = null;
					}
				
			}
			// finally
			pointer = next;
		}
		
		return newHead;
	}
	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
	public static void main(String[] args) {
		ListNode n1=new ListNode(4);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(1);
		ListNode n5=new ListNode(5);
		ListNode n6=new ListNode(6);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n1 = insertionSortList(n1);
		 
		printList(n1);
	}

}
