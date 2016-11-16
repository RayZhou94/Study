package per.sd.jvm;

public class Demo1 {
	private static Demo1 demo1 = null;
	public void isAlive(){
		System.out.println("yes,i am still alive...");
	}
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed!");
		demo1 = this;
	}
	public static void main(String[] args) throws InterruptedException {
		demo1 = new Demo1();
		demo1 = null;
		System.gc();
		Thread.sleep(500);
		if (null != demo1) {
			demo1.isAlive();
		}else {
			System.out.println("no, i am dead...");
		}
		
		demo1 = null;
		System.gc();
		Thread.sleep(500);
		if (null != demo1) {
			demo1.isAlive();
		}else {
			System.out.println("no, i am dead...");
		}
	}
}
