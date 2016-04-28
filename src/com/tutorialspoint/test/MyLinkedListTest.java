package com.tutorialspoint.test;

public class MyLinkedListTest {

	public static void main(String[] args) {
		BookLinkedList bookLinkedList=new BookLinkedList();
		BookLinkedList.Node head=bookLinkedList.getHead();
		Page page=null;
		for(int i=1;i<10;i++){
			page=new Page();
			page.setPageNo(i);
			page.setPageContent("page content"+i);
			page.setPageSignature("page signature"+i);
			bookLinkedList.add(new BookLinkedList.Node(page));
		}
		BookLinkedList.Node current=head;
		int length=0;
		BookLinkedList.Node middle=head;
		//loop until reached last node i.e next points to null
		while(null!=current.getNext()){
			length++;
			//traverse after two iterations
			if(0==length%2){
				middle=middle.getNext();
			}
			//traverse to next node
			current=current.getNext();
		}
		if(1==length%2){
			middle=middle.getNext();
		}
		System.out.println("length of LinkedList: " + length);
	    System.out.println("middle element of LinkedList : " + middle.getPage().toString());
	}

}

class BookLinkedList {
	private Node head;
	private Node tail;

	public BookLinkedList() {
		Page page = new Page();
		page.setPageNo(0);
		this.head = new Node(page);
		tail=head;
	}

	public Node getHead() {
		return head;
	}

	public void add(Node node) {
		tail.next = node;
		tail = node;
	}

	public static class Node {
		private Node next;
		private Page page;

		public Node(Page page) {
			this.page=page;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Page getPage() {
			return page;
		}

		public void setPage(Page page) {
			this.page = page;
		}

	}
}

class Page {
	private int pageNo;
	private String pageContent;
	private String pageSignature;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageContent() {
		return pageContent;
	}

	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}

	public String getPageSignature() {
		return pageSignature;
	}

	public void setPageSignature(String pageSignature) {
		this.pageSignature = pageSignature;
	}

	@Override
	public String toString() {
		StringBuilder strb=new StringBuilder();
		strb.append("Page No: " + pageNo);
		strb.append(" Page Content: "+ pageContent );
		strb.append(" Page Signature: " + pageSignature);
		return strb.toString();
	}
}
