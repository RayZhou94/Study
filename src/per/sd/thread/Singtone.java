package per.sd.thread;
/**
 * 懒汉模式（线程安全的）
 * @author shallowdream
 *
 */
class SingTone1{
	private static SingTone1 instance = new SingTone1();
	private SingTone1(){
		
	}
	public static SingTone1 getInstance(){
		return instance;
	}
}
//提高效率
class SingTone2{
	private static class Singtone3 {
		public static SingTone2 instance = new SingTone2();
	}
	private SingTone2(){
		
	}
	public static SingTone2 getInstance(){
		return Singtone3.instance;
	}
}
public class Singtone {
	public static void main(String[] args) {
		SingTone2 s1 = SingTone2.getInstance();
		SingTone2 s2 = SingTone2.getInstance();
		System.out.println(s1 + s1.getClass().getName());
		System.out.println(s2 + s2.getClass().getName());
	}
}
