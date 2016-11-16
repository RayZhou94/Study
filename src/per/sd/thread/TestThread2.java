package per.sd.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程安全的单例模式（饿汉模式）
 * 1、设置私有构造函数（不能被实例化）
 * 2、创建静态属性，静态方法获取实例对象
 * 3、通过判断实例对象是否存在来决定是否创建对象
 * 4、添加锁synchronized
 */
class Jvm{
	private static Jvm instance;
	private Jvm(){
		
	}
	//线程安全但效率较低如 abc 线程进入前均需等待
	public synchronized static Jvm getInstance1(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == instance) {
			instance = new Jvm();
		}
		return instance;
	}
	//线程安全，效率较高 abc 线程进入前需先判断，不空直接返回实例，空才需保护
	public static Jvm getInstance2(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == instance) {//-------------------------阻止非空实例线程进入锁
			synchronized (Jvm.class) {
				if (null == instance) {
					instance = new Jvm();
				}
			}
		}
		return instance;
	}
	public static Jvm getInstance3(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == instance) {
			instance = new Jvm();
		}
		return instance;
	}
}
class ThreadJvm implements Runnable {
	public void run() {
		System.err.println(Jvm.getInstance3());
	}
}

class ThreadJvm2 implements Callable<Jvm> {
	@Override
	public Jvm call() throws Exception {
		return Jvm.getInstance2();
	}
}
public class TestThread2 {
	public static void main(String[] args) {
		try {
			new TestThread2().test2();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void test1(){
		ThreadJvm threadJvm = new ThreadJvm();
		Thread t1 = new Thread(threadJvm);
		Thread t2 = new Thread(threadJvm);
		t1.start();
		t2.start();
	}
	public void test2() throws InterruptedException, ExecutionException{
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		ThreadJvm2 t1 = new ThreadJvm2();
		ThreadJvm2 t2 = new ThreadJvm2();
		//获取值
		Future<Jvm> future1 = executorService.submit(t1);
		Future<Jvm> future2 = executorService.submit(t2);
		Jvm jvm1 = future1.get();
		Jvm jvm2 = future2.get();
		System.err.println(jvm1 + " " +jvm2+ "  " + (jvm1==jvm2));
	}
}
