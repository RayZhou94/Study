package per.sd.thread;
/**
 * 死锁
 * @author shallowdream
 *
 */
public class Synchronized {
	public static void main(String[] args) {
		Object m = new Object();
		Object g = new Object();
		Demo1 demo1 = new Demo1(m, g);
		Demo2 demo2 = new Demo2(m, g);
		Thread t1 = new Thread(demo1);
		Thread t3 = new Thread(demo1);
		Thread t2 = new Thread(demo2);
		t1.start();
		System.out.println(t1.getId() + "  " + t1.getContextClassLoader() + "  " + t1.getName());
		t2.start();
		System.out.println(t2.getId() + "  " + t2.getContextClassLoader() + "  " + t2.getClass());
		t3.start();
		System.out.println(t3.getId() + "  " + t3.getContextClassLoader() + "  " + t3.getClass());
	}
}
class Demo1 implements Runnable{
Object money;
Object goods;
	Demo1(Object money, Object goods){
		this.money = money;
		this.goods = goods;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (money) {
			synchronized (goods) {
				System.out.println("一手交钱" + Thread.currentThread().getName());
			}
		}
	}
	
}
class Demo2 implements Runnable{
Object money;
Object goods;
Demo2(Object money, Object goods){
	this.money = money;
	this.goods = goods;
}
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (goods) {
			synchronized (money) {
				System.out.println("一手交货" + Thread.currentThread().getName());
			}
		}
	}
	
}

