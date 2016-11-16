package per.sd.string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashCodeDemo1 {

	private int a;
	public boolean equals(HashCodeDemo1 hash){
		if (this.a == hash.a) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		HashCodeDemo1 hash1 = new HashCodeDemo1();
		hash1.setA(1);
		HashCodeDemo1 hash2 = new HashCodeDemo1();
		hash2.setA(1);
		Set<HashCodeDemo1> set = new HashSet<>();
		set.add(hash1);
		set.add(hash2);
		System.out.println(set.size());
		Iterator<HashCodeDemo1> iterator = set.iterator();
		while (iterator.hasNext()) {
			HashCodeDemo1 hashCodeDemo1 = (HashCodeDemo1) iterator.next();
			System.out.println(hashCodeDemo1.a);
		}
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
}
