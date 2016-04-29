package com.tutorialspoint.test;

public class ReverseLinkedList {
	public static void main(String args[]) {
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(4);
		LinkedListNode n5 = new LinkedListNode(5);
		LinkedListNode n6 = new LinkedListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n1 = reverseLinkedList(n1);
		System.out.println("After reversing: ");
		SortLinkedList.printList(n1);
		System.out.println("After reversing again recursively: ");
		n1 = recursiveReverseLinkedList(n1);
		SortLinkedList.printList(n1);
	}

	// reverse linked list
	public static LinkedListNode reverseLinkedList(LinkedListNode head) {
		LinkedListNode previousNode = null;
		LinkedListNode nextNode;
		while (null != head) {
			nextNode = head.next;
			head.next = previousNode;
			previousNode = head;
			head = nextNode;
		}
		return previousNode;
	}
	
	public static LinkedListNode recursiveReverseLinkedList(LinkedListNode head){
		
		if(null==head || null==head.next){
			return head;
		}
		
		LinkedListNode remainingNode=recursiveReverseLinkedList(head.next);
		
		head.next.next=head;
		head.next=null;
		
		return remainingNode;
	}
	
}
