package per.sd.jvm;

import java.util.ArrayList;
/**
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:2245)
	at java.util.Arrays.copyOf(Arrays.java:2219)
	at java.util.ArrayList.grow(ArrayList.java:242)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:216)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:208)
	at java.util.ArrayList.add(ArrayList.java:440)
	at per.sd.jvm.JVM.main(JVM.java:9)
	
	ava project 可以右击工程 Run AS
	-->选最下面Run...-->
	Arguments-->在VM arguments里面填
	-	Xmx256m。这样就可以设置它运行时最大内存为256m
 * @author shallowdream
 *
 */
public class JVM {
	public static void main(String[] args) {
		test2();
	}
	public static void test2(){
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern()==str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern()==str2);
		String str3 = "计算机软件";
		String str4 = "计算机软件" + str1;
		System.out.println(str4==str3);
		System.out.println("计算机软件".intern()==str4);
	}
	public static void test1(){
		ArrayList<String> list = new ArrayList<>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
