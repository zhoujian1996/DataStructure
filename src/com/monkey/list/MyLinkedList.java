package com.monkey.list;

/**
* 
* @author Administrator
* @creation 2019年9月1日
*   类描述	单向链表实现
*/
public class MyLinkedList {
	
	//链表的长度
	private int size;
	
	//链表的头结点,头结点为了方便操作
	private Node headNode;
	
	
	//链表的无参数构造函数
	public MyLinkedList() {
		
		//头结点为空
		headNode = new Node();
		
		size = 0;
	}
	
	
	//在链表的尾部添加元素
	public void add(String element) {
		//待添加节点
		Node newNode = new Node(element, null);
		//添加到尾部
		
		//遍历获取尾部节点
		Node currentNode = headNode;

		for(int i =0;i<size;i++){
			currentNode = currentNode.getNext();
		}
		//将新节点添到尾部节点
		currentNode.setNext(newNode);
		size++;
	}
	
	//在链表中插入元素
	public void insert(int index,String element) {
		
		//待插入节点之前的一个节点 p 
		Node beforeNode = getNode(index-1);
		//System.out.println(beforeNode.getData());
		// s->next = p->next,新节点s
		Node newNode = new Node(element, beforeNode.getNext());
		//p-next = s
		beforeNode.setNext(newNode);
		
		size++;
	}
	
	
	//删除链表中的某个位置元素
	public void remove(int index) {
		//获取之前的一个节点
		Node beforeNode = getNode(index-1);
		// p->next = p->next-next
		beforeNode.setNext(beforeNode.getNext().getNext());
		
	}
	
	
	//获取链表中某个位置
	public Node getNode(int index) {
		
		//获取头结点下面的元素,tempNode为遍历
		Node tempNode = headNode;
		
		//思考为什么要index+1
		for(int i =0;i<index+1;i++) {
			tempNode = tempNode.getNext();
		}
		
		return tempNode;
		
	}
	
	//清空链表
	public void clearList() {
		
		Node currentNode = headNode;
		Node copyNode = headNode.getNext();
		
		while(headNode.getNext()!=null) {
			
		}
		
	}

	//重写toString方法
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		//待遍历节点
		Node currentNode = headNode;
		
		while(currentNode!=null) {
			sb.append(currentNode.getData()+"--->");
			currentNode = currentNode.getNext();
		}
		return sb.toString();
	}
	
	
	
	
	
	

}
