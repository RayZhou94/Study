package per.sd.thread;
/**
 * 多线程 继承runnable接口
 * 静态代理Thread
 * @author shallowdream
 *
 */
class Target implements Runnable{
	
private int num = 40;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if (num <= 0) {
				break;
			}
			System.err.println(Thread.currentThread().getName() + "抢走了" + (num--));
		}
	}
	
}
public class TestThread {
	public static void main(String[] args) throws InterruptedException {
		Target target = new Target();
		Thread t1 = new Thread(target, "黄牛甲");
		Thread t2 = new Thread(target, "黄牛乙");
		Thread t3 = new Thread(target, "黄牛丙");
		t1.start();
		t2.start();
		t2.yield();
		t3.start();
		
	}
}
