package com.zj.list;

/**
* 
* @author Administrator
* @creation 2019年9月3日下午7:22:14

*   类描述	 链表底层用数组实现，类似于ArrayList
*/
public class LinearList {
	
	//数组的长度
	private int size;
	//数组中元素的个数
	private int length;
	//底层数组
	private String[] arr;
	
	//含参数构造函数
	public LinearList(int size) {
		arr = new String[size];
		this.size = size; 
	}
	
	//无惨构造函数
	public LinearList() {
		//无参时指定数组的初始长度为1
		arr = new String[2];
		this.size = 2;
	}
	
	//像数组中添加元素，向末尾添加
	public void add(String element) {
		//当数组中的元素达到数组长度的一半时扩容
		if(length>size/2) {
			reSize(size+size/2);
			this.size = size+size/2;
		}
		//weilength个位置处赋值，因为索引从0开始，而Length时从1开始的
		arr[length] = element; 
		length++;
	}
	
	//向数组中添加元素，在指定索引位置处添加
	public void add(int index,String element) {
		checkRange(index);
		//当数组中的元素达到数组长度的一半时扩容
		if(length>size/2) {
			reSize(size+size/2);
			this.size = size+size/2;
		}
		
		//从index开始之后（包括的每一个元素朝后移动一位，从后面开始动）,需要移动length-index次
		for(int i = length;i>index;i--) {
			arr[i] = arr[i-1];
		}
		
		//在index处赋上新的值
		arr[index] = element;
		length++;
	}
	
	//删除list中的元素,把index开始（不包括index)的所有元素朝前面移动一位即可,覆盖掉Index处的值即可，需要移动length-index-1次
	public void remove(int index) {
		checkRange(index);
		for(int i =index+1;i<length;i++) {
			arr[i-1] = arr[i];
		}
		length--;
	}
	
	
	//清空list,循环遍历list，清空list
	public void clear() {
		for(int i =0;i<length;i++) {
			arr[i] = null;
		}
		this.length = 0;
	}
	
	
	//数组中元素的个数
	public int length() {
		return this.length;
	}
	
	
	//对象是否为空
	public boolean isEmpty() {
		return length==0?true:false;
	}
	
	//返回某个元素的索引值，
	public int index(String element) {
		
		//如果元素为空
		if(element==null) {
			//遍历数组中的元素
			for(int i =0;i<length;i++) {
				if(arr[i]==null) {
					return i;
				}
			}
			
		}else {
			//遍历数组中的元素
			for(int i =0;i<length;i++) {
				if(arr[i].equals(element)) {
					return i;
				}
			}
		}
		return -1;
		
	}
	
	
	//list是否包含某个元素
	public boolean contains(String element) {
		return index(element)!=-1;
	}
	
	
	
	
	
	//封装健壮性检测函数，判断是索引是否越界
	public void checkRange(int index) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("索引越界"+index);
		}
	}
	
	//封装健壮性检测函数，调整数组的长度
	public void reSize(int size) {
		String[] newArr = new String[size];
		//复制数组
		for(int i =0;i<length;i++) {
			newArr[i] = arr[i];
		}
		//将arr指向新的数组
		arr = newArr;
		
		
		
	}

	
	//重写toString方法
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i =0;i<length;i++) {
			sb.append(arr[i]+",");
		}
		sb.append("]");
		return sb.toString();
	
	}
	
	
	
	
	public static void main(String[] args) {
		LinearList  list = new LinearList();
		
		//向list中添加元素
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		System.out.println(list);
		
		
		//按照索引超list中添加元素
		list.add(1,"0");
		list.add(2,"333");
		System.out.println(list);
		
		
		//按照索引删除list
		list.remove(0);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		
		
		//list的长度
		System.out.println(list.length());
		
		//list是否为空
		System.out.println(list.isEmpty());
		
		
		//list是否包含某个元素
		System.out.println(list.index("22"));
		
		//list是否包含某个元素
		System.out.println(list.contains("22"));
		
		
		System.out.println(list.contains("0"));

		//清空list
		list.clear();
		System.out.println(list);
		
		//list是否为空
		System.out.println(list.isEmpty());
		
		
	}
	
	
	
	
	

}
