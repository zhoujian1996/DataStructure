package com.monkey.test;

import com.monkey.list.LinkedList;
import com.monkey.list.MyLinkedList;

/**
 * 
 * @author zhoujian
 *  ����ʱ�䣺2019��8��24�� ����8:52:09
 *  ���Ե�������
 */
public class TestLinkedList {

	public static void main(String[] args) {
		
		MyLinkedList  list = new MyLinkedList();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		System.out.println(list);

		list.insert(1, "111");
		System.out.println(list);

		list.insert(2, "211");
		System.out.println(list);

		list.insert(0, "0");
		System.out.println(list);
		
		
		list.remove(2);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		
		
		

	}

}
