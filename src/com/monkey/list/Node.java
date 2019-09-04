package com.monkey.list;

/**
 * 
 * @author zhoujian
 *  创建时间：2019年8月24日 下午8:31:05
 *  单链表中的每个节点：节点是由存放数据的数据域和存放后继节点的指针域组成

 */
public class Node {
	
	
	private String data;
	private Node next;
	
	
	public Node(String data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}


	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
	
	
	
	
	
	
}
