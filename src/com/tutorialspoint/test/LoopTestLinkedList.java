package com.tutorialspoint.test;

public class LoopTestLinkedList {

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(4);
		LinkedListNode n5 = new LinkedListNode(5);
		LinkedListNode n6 = new LinkedListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		n5.next = n6;
		System.out.println("checking for loop in linked list: " + loopTest(n1));
		LinkedListNode loopNode = findFirstLoopNode(n1);
		System.out.println("checking for first loop: " + loopNode.val);

	}

	public static boolean loopTest(LinkedListNode head) {
		LinkedListNode fastPtr = head;
		LinkedListNode slowPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr)
				return true;
		}
		return false;
	}

	public static LinkedListNode findFirstLoopNode(LinkedListNode head) {
		LinkedListNode fastPtr = head;
		LinkedListNode slowPtr = head;
		boolean loopExists = false;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr) {
				loopExists = true;
				break;
			}

		}
		if (loopExists) {
			slowPtr = head;

			while (slowPtr != fastPtr) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}

		} else {
			System.out.println("Loop does not exists");
			slowPtr = null;
		}
		return slowPtr;
	}

}
