package com.monkey.list;
/**
 * 
 * @author zhoujian
 *  创建时间：2019年8月24日 下午8:33:19
 *  
 *  单向链表
 *  
 *  //思想：工作指针后移
 */
public class LinkedList {

	//链表的长度
	private int size;
	
	//链表头节点
	private Node headNode;
	
	//初始化链表
	public LinkedList() {
		super();
		this.size = 0;
		//头结点:有了头节点，对在第一个元素节点前插入和删除第一节点其操作就和其他节点的操作同一了
		headNode = new Node();
	}



	//获取链表中的第i个节点
	public Node get(int index){
		//currentNode 为工作指针,从第一个节点开始
		Node currentNode = headNode;
		//健壮性判断
		if(index<0||index>size){
			throw new IllegalArgumentException("索引错误");
		}else{
			//遍历链表
			for(int i =0;i<index-1;i++){
				currentNode = currentNode.getNext();
			}
			
		}
		return currentNode;
		
	}
	
	//单链表的插入
	public void insert(int index,String data){
		if(index<0||index>size){
			throw new IllegalArgumentException("索引错误");
			
		}else if (index==0){
			
			//头节点
			Node newNode = new Node(data, null);
			headNode = newNode ;
			
		}
		else{
		
			
			Node beforeNode =get(index);
		
			//s->next = p-》next
			Node newNode = new Node(data,beforeNode.getNext()); 
			
			// p->next =s 
			beforeNode.setNext(newNode);
			
			
		}
		size++;
	}

	
	
	//在链表末尾添加元素
	public void add(String data){
		Node lastNode = get(size);
		
		Node newNode = new Node(data,null);
		lastNode.setNext(newNode);
		size++;
	}
	
	
	//删除元素
	public void delete(int index){
		
		if(index<0||index>size){
			throw new IllegalArgumentException("索引错误");
		}else{
			
			//这种删除方法不适用于 索引为0 的待优化
			Node beforeNode = get(index-1);
			
			beforeNode.setNext(beforeNode.getNext().getNext());
			size--;
		}
		
	}
	
	
	

	//重写toString（）方法
	@Override
	public String toString() {
		//待拼接的字符串
		StringBuilder sb = new StringBuilder();
		//工作指针
		Node currentNode = headNode;
		//遍历链表
		for(int i =0;i<size;i++){
			sb.append(currentNode.getData()+",");
			
			currentNode = currentNode.getNext();
		}
		return sb.toString();
	}
	
	
	
	
	
	
	
	
}
