package per.sd.colection;
import java.text.BreakIterator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
/**
 * 编写linkedlist
 * 双向链表，需要三个变量first （头结点） last（尾节点） size
 */
import java.util.LinkedList;

public class Demo1 {
	private Node first;
	private Node last;
	private int size;
	
	Demo1(){
		size = 0;
	}
	public int size(){
		return size;
	}
	
	/**
	 * 为了提高查找效率，可以先判断index与size/2的大小，来决定从后向前查找还是从前向后查找
	 * @param index
	 * @return
	 */
	public Object get(int index){
		Node temp = null;
		if (index >= 0 && index <size) {
			//   >> 表示有符号右移 每移一位数值减半
			if (index < (size >> 1)) {
				temp = first;
				for (int i = 0; i < index; i++) {
					temp = temp.getNext();
				}
			}else {
				temp = last;
				for (int i = size-1; i > index; i--) {
					temp = temp.getPrevious();
				}
			}
			
		}
		
		return temp.getObj();
	}
	public Object get2(int index){
		Node temp = null;
		if (index >= 0 && index <size) {
			temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
		}
		return temp.getObj();
	}
	public void add(Object obj){
		Node node = new Node();
		if (null == first) {
			node.setObj(obj);
			first = node;
			last = first;
		}else {
			node.setObj(obj);
			node.setPrevious(last);
			last.setNext(node);
			last = node;
		}
		size++;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static void main(String[] args) {
		/*Demo1 demo1 = new Demo1();
		for (int i = 0; i < 100; i++) {
			demo1.add(i + "a");
		}
		
		long t1 = System.nanoTime();
		for (int i = 0; i < demo1.size(); i++) {
			demo1.get(i);
		}
		long t2 = System.nanoTime();
		System.err.println("get1()耗时为 ：" + (t2 - t1));
		long t3 = System.nanoTime();
		for (int i = 0; i < demo1.size(); i++) {
			demo1.get2(i);
		}
		long t4 = System.nanoTime();
		System.err.println("get2()耗时为 ：" + (t4 - t3));*/
		
		
//		System.err.println(demo1.size());
//		System.err.println(demo1.get(1));
//		HashMap<String, Object> map = new HashMap<>();
//		Test test = new Test("hehe");LinkedList
//		map.put("test", test);Set, HashSet
//		System.err.println(map.get("test"));
//		map.clear();
//		System.err.println(test.name);
//		Hashtable<Integer,Integer> hashtable;
//		int a = 2;
//		for (foo1(1);a < 10;) {
//			//a++;
//		}
		int b = Demo1.class.hashCode();
		int a = "123".hashCode();
		System.out.println(b);
	}
	public static void foo1(int a){
		System.err.println(a+"ddddddddddddddddddddddddddddddddddddddddddddddd");
	}
	public static void foo2(int a){
		System.err.println(a);
	}
}
class Test{
	String name;
	String age;
}