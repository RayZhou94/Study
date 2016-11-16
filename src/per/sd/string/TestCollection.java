package per.sd.string;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestCollection extends Object implements Cloneable{
	private int i;
	public static void main(String[] args) throws CloneNotSupportedException {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(1, 1);
		Object map = (Object) hashMap.clone();
		System.out.println(map.hashCode()==hashMap.hashCode());
		System.out.println(map.toString() + "  " + hashMap.toString());
		System.out.println(hashMap.equals(map) + "  " + (map == hashMap));
		/**
		int [] a = {1,2,3};
		int [] b = a.clone();
		System.out.println(a.hashCode() == b.hashCode());
		System.out.println(a.toString() + "  " + b.toString());
		System.out.println(a.equals(b) + " " + (a==b));
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
		System.out.println(list.hashCode() + "  "+  list2.hashCode());
		System.out.println(list.equals(list2)+ "  " + (list == list2));
		**/
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
