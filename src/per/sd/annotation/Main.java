package per.sd.annotation;

class Test implements Runnable{

	private String str;
	Test(String str){
		this.str = str;
	}
	public void run() {
		char[] ch = str.toCharArray();
		for (char c : ch) {
			try {
				Thread.sleep(100);
				System.out.println(c);
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
public class Main {
	public static void main(String[] args) {
		Test test1 = new Test("adg");
		Test test2 = new Test("beh");
		Test test3 = new Test("cfi");
		test1.run();
	}
}
