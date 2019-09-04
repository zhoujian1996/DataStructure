package com.monkey.list;

/**
* 
* @author Administrator
* @creation 2019��9��1��
*   ������	��������ʵ��
*/
public class MyLinkedList {
	
	//����ĳ���
	private int size;
	
	//�����ͷ���,ͷ���Ϊ�˷������
	private Node headNode;
	
	
	//������޲������캯��
	public MyLinkedList() {
		
		//ͷ���Ϊ��
		headNode = new Node();
		
		size = 0;
	}
	
	
	//�������β�����Ԫ��
	public void add(String element) {
		//����ӽڵ�
		Node newNode = new Node(element, null);
		//��ӵ�β��
		
		//������ȡβ���ڵ�
		Node currentNode = headNode;

		for(int i =0;i<size;i++){
			currentNode = currentNode.getNext();
		}
		//���½ڵ���β���ڵ�
		currentNode.setNext(newNode);
		size++;
	}
	
	//�������в���Ԫ��
	public void insert(int index,String element) {
		
		//������ڵ�֮ǰ��һ���ڵ� p 
		Node beforeNode = getNode(index-1);
		//System.out.println(beforeNode.getData());
		// s->next = p->next,�½ڵ�s
		Node newNode = new Node(element, beforeNode.getNext());
		//p-next = s
		beforeNode.setNext(newNode);
		
		size++;
	}
	
	
	//ɾ�������е�ĳ��λ��Ԫ��
	public void remove(int index) {
		//��ȡ֮ǰ��һ���ڵ�
		Node beforeNode = getNode(index-1);
		// p->next = p->next-next
		beforeNode.setNext(beforeNode.getNext().getNext());
		
	}
	
	
	//��ȡ������ĳ��λ��
	public Node getNode(int index) {
		
		//��ȡͷ��������Ԫ��,tempNodeΪ����
		Node tempNode = headNode;
		
		//˼��ΪʲôҪindex+1
		for(int i =0;i<index+1;i++) {
			tempNode = tempNode.getNext();
		}
		
		return tempNode;
		
	}
	
	//�������
	public void clearList() {
		
		Node currentNode = headNode;
		Node copyNode = headNode.getNext();
		
		while(headNode.getNext()!=null) {
			
		}
		
	}

	//��дtoString����
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		//�������ڵ�
		Node currentNode = headNode;
		
		while(currentNode!=null) {
			sb.append(currentNode.getData()+"--->");
			currentNode = currentNode.getNext();
		}
		return sb.toString();
	}
	
	
	
	
	
	

}
