package com.monkey.list;

/**
 * 
 * @author zhoujian
 *  ����ʱ�䣺2019��8��24�� ����8:31:05
 *  �������е�ÿ���ڵ㣺�ڵ����ɴ�����ݵ�������ʹ�ź�̽ڵ��ָ�������

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
