package com.zj.list;

/**
* 
* @author Administrator
* @creation 2019年9月3日下午8:36:26

*   类描述	单向链表
*   主要方法：  向链表中增加数据， 按照索引位置增加，向链表的头部增加数据，向链表的尾部增加数据
*   		
*   	   删除链表中的数据：按照索引删除链表中的数据，删除链表中的头部数据，删除链表中的尾部数据
*	
*	几种思想：  (1)模块化的思想，把一些大的功能比较复杂的方法进行拆分，分为几个小的方法
*			 
*            (2) 工作指针后移的思想，遍历链表，从头部节点开始
*
*/
public class SlinkedList {
	
	//链表的长度
	private int length;
	
	//链表的头结点
	private Node first;
	
	//链表的尾节点
	private Node last;
	
	
	
	//链表的构造函数
	public SlinkedList() {
		super();
		
	}


	//链表的长度
	public int  length() {
		return length;
	}
	
	
	//链表是否为空
	public boolean isEmpty() {
		return length==0;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	//获取index处的Node，这个方法的复杂度为O(N) 查找index处的节点，这个方法比较重要
	public Node index(int index) {
		checkRange(index);
		//遍历链表
		Node currentNode = first;
		//遍历链表，注意 迭代的次数 为Index次
		for(int i =0;i<index;i++) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
		
	}
	
	
	//获取index节点处的数据的值
	public String getData(int index) {
		return index(index).getData();
	}
	
	//设置index节点处数据的值
	public void setDate(int index,String element) {
		index(index).setData(element);
	}
	
	//在index节点处插入值，这里就需要分析在头部插入值，在尾部插入值，在其他的位置插入值
	public void insert(int index,String element) {
		//健壮性检查
		checkRange(index);
		//向链表的首部添加节点
		if(index==0) {
			//方法的拆分
			push(element);
			if(length==1) {
				last = first;
			}
		//向链表的尾部添加节点
		}else if(index==length-1) {
			//方法的拆分
			add(element);
			if(length==1) {
				first = last;
			}
		//向链表的中间部分添加节点
		}else {
			//获取待插入节点之前的一个节点
			Node beforeNode = index(index-1);
			//待插入的新节点 
			Node newNode = new Node();
			//设置新节点的数据
			newNode.setData(element);
			//设置新节点的下一个节点
			newNode.setNext(beforeNode.getNext());
			//设置新节点的上一个节点
			beforeNode.setNext(newNode);
			length++;
		}
		
	}
	
	
	//在链表的头部插入值
	public void push(String element) {
		//创建新的节点
		Node newNode = new Node();
		//设置新节点的值
		newNode.setData(element);
		//因为在链表的头部插入值，所以新生成的节点下一个节点为 之前链表的第一个节点
		newNode.setNext(first);
		
		//设置新的节点为头部节点
		first = newNode;
		
		//链表的长度自增
		length++;
	}
	
	//在链表的尾部插入值
	public void add(String element) {
		//创建新的节点
		Node newNode = new Node();
		//设置新节点的值
		newNode.setData(element);
		//设置新节点的下一个值
		newNode.setNext(null);
		//将新节点添加到原来节点的尾部
		last.setNext(newNode);
		
		//将新节点生命为尾部节点
		last = newNode;
		
		length++;
		
	}
	
	
	//按照索引删除节点
	public void remove(int index) {
		checkRange(index);
		//删除头结点 
		if(index==0) {
			pop();
			
		//删除尾部及诶按
		}else if(index==length-1) {
			delete();
		}else {
			//获取待删除之前的节点s
			Node beforeNode = index(index-1);
			//将待删除之前的节点直接指向待删除节点之后的节点，这样就没哟指向待删除节点的指针
			beforeNode.setNext(beforeNode.getNext().getNext());
			length--;
		}
		
		
	}
	
	//删除链表中的第一个节点
	public void pop() {
		
		Node oldFirst = first;
		oldFirst = null;
		//将新的节点设置为原来第二个节点
		first = first.getNext();
		length--;
	}
	
	//删除链表的最后一个节点
	public void delete() {
		
		//获取倒数第二各节点
		Node newLast = index(length-2);
		
		System.out.println(newLast.getData());
		
		newLast.setNext(null);
		//将最后的一个节点设置为倒数第二个节点
		last = newLast;
		length--;
		
	}
	
	
	//清空链表
	public void clear() {
		Node currentNode = first;
		Node afterNode = first;
		for(int i =0;i<length;i++) {
			
			afterNode = afterNode.getNext();
			currentNode = null;
			currentNode = afterNode;
			
		}
		length = 0;
		first = last = null;
		
	}
	
	
	

	
	public void checkRange(int index) {
		if(index<0||index>length) {
			throw new IllegalArgumentException("索引跃进");
		}
		
	}
	
	
	

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		Node currentNode = first;
		//循环执行length次
		for(int i = 0;i<length;i++) {
			sb.append(currentNode.getData()+"->");
			currentNode = currentNode.getNext();
		}
	
		return sb.toString();
	}


	public static void main(String[] args) {
		SlinkedList list = new SlinkedList();
		
		list.insert(0,"0");
		System.out.println(list);
		
		
		list.insert(0,"111");
		System.out.println(list);
		
		list.add("2");
		list.add("3");
		list.add("4");
		System.out.println(list);
		
		
		list.push("55");
		list.push("44");
		list.push("22e");
		System.out.println(list);

		
		list.insert(1, "eeee");
		System.out.println(list);
		System.out.println(list.index(2).getData());
		
		
		
		list.remove(0);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		
		
		list.delete();
		System.out.println(list);
		
		list.remove(2);
		System.out.println(list);
		
		list.clear();
		System.out.println(list);
		

	}
	
	
	
	

}


class Node{
	
	//节点中的数据
	private String data;
	
	//节点的下一个节点
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
