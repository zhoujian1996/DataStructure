package com.monkey.list;
/**
 * 
 * @author zhoujian
 *  ����ʱ�䣺2019��8��24�� ����8:33:19
 *  
 *  ��������
 *  
 *  //˼�룺����ָ�����
 */
public class LinkedList {

	//����ĳ���
	private int size;
	
	//����ͷ�ڵ�
	private Node headNode;
	
	//��ʼ������
	public LinkedList() {
		super();
		this.size = 0;
		//ͷ���:����ͷ�ڵ㣬���ڵ�һ��Ԫ�ؽڵ�ǰ�����ɾ����һ�ڵ�������ͺ������ڵ�Ĳ���ͬһ��
		headNode = new Node();
	}



	//��ȡ�����еĵ�i���ڵ�
	public Node get(int index){
		//currentNode Ϊ����ָ��,�ӵ�һ���ڵ㿪ʼ
		Node currentNode = headNode;
		//��׳���ж�
		if(index<0||index>size){
			throw new IllegalArgumentException("��������");
		}else{
			//��������
			for(int i =0;i<index-1;i++){
				currentNode = currentNode.getNext();
			}
			
		}
		return currentNode;
		
	}
	
	//������Ĳ���
	public void insert(int index,String data){
		if(index<0||index>size){
			throw new IllegalArgumentException("��������");
			
		}else if (index==0){
			
			//ͷ�ڵ�
			Node newNode = new Node(data, null);
			headNode = newNode ;
			
		}
		else{
		
			
			Node beforeNode =get(index);
		
			//s->next = p-��next
			Node newNode = new Node(data,beforeNode.getNext()); 
			
			// p->next =s 
			beforeNode.setNext(newNode);
			
			
		}
		size++;
	}

	
	
	//������ĩβ���Ԫ��
	public void add(String data){
		Node lastNode = get(size);
		
		Node newNode = new Node(data,null);
		lastNode.setNext(newNode);
		size++;
	}
	
	
	//ɾ��Ԫ��
	public void delete(int index){
		
		if(index<0||index>size){
			throw new IllegalArgumentException("��������");
		}else{
			
			//����ɾ�������������� ����Ϊ0 �Ĵ��Ż�
			Node beforeNode = get(index-1);
			
			beforeNode.setNext(beforeNode.getNext().getNext());
			size--;
		}
		
	}
	
	
	

	//��дtoString��������
	@Override
	public String toString() {
		//��ƴ�ӵ��ַ���
		StringBuilder sb = new StringBuilder();
		//����ָ��
		Node currentNode = headNode;
		//��������
		for(int i =0;i<size;i++){
			sb.append(currentNode.getData()+",");
			
			currentNode = currentNode.getNext();
		}
		return sb.toString();
	}
	
	
	
	
	
	
	
	
}
