package per.test;


class A{
//	A(){
//		System.out.println("this is A...");
//	}
}
public class Main extends Thread{
	private int i;
	public Main(int i) {
		this.i = i;
	}
	static int b = 100;
	public synchronized void m1() throws InterruptedException{
		this.sleep(200);
		b = 1000;
		//System.out.println(b);
	}
	public synchronized void m2() throws InterruptedException{
		this.sleep(100);
		b = 2000;
		//System.out.println(b);
	}
	public void run() {
		try {
			m1();
			System.err.println(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Main main1 = new Main(1);
		Main main2 = new Main(2);
		Main main3 = new Main(3);
		Main main4 = new Main(4);
		Main main5 = new Main(5);
		Main main6 = new Main(6);
		main1.start();
		main2.start();
		main3.start();
		main4.start();
		main5.start();
		main6.start();
	}
	
	public void print(){
		
	}
}
