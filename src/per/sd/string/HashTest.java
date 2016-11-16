package per.sd.string;

import java.util.HashSet;
import java.util.Set;

public class HashTest {
	private String x;
	private int i;  
	  
    public int getI() {  
        return i;  
    }  
  
    public void setI(int i) {  
        this.i = i;  
    }  
  
//    public int hashCode() {  
//        return i % 10;  
//    }  
  
    public final static void main(String[] args) {
//    	String s1 = "a";
//    	String b = "b";
//    	s1 += b;
//    	String s2 = new String("ab");
    	String s1 = new String();
    	String s2 = new String();
    	System.out.println(s1.equals(s2));
    	
    	HashTest aa = new HashTest();
    	HashTest bb = new HashTest();
    	System.out.println(aa.equals(bb));
    	/**
        HashTest a = new HashTest();  
        HashTest b = new HashTest();  
        a.setI(1);  
        b.setI(1);  
        Set<HashTest> set = new HashSet<HashTest>();  
        set.add(a);  
        set.add(b);  
        System.out.println(a.hashCode() + " " + b.hashCode());  
        System.out.println(a.equals(b));  
        System.out.println(set);
        */  
    }

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}  
}
