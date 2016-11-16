package per.sd.string;

/**
 * Stringbuffer/StringBuilder只在堆中创建一个实例，stringBuilder是非线程安全的而
 * StringBuffer是线程安全的但是StringBuilder效率更高
 * @author shallowdream
 *
 */
public class StringTest {
	public static void main(String[] args) {
		//---------------------------------------------------------
		long t1 = System.nanoTime();
		String s1 = new String();
		for (int i = 0; i < 1000; i++) {
			s1 += i;
		}
		long t2 = System.nanoTime();
		System.out.println("String耗时为: " + (t2 - t1));
		//----------------------------------------------------------
		long t3 = System.nanoTime();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			stringBuilder.append(i);
		}
		long t4 = System.nanoTime();
		System.out.println("StringBuilder耗时为: " + (t4 - t3));
		//-----------------------------------------------------------
		long t5 = System.nanoTime();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 1000; i++) {
			stringBuffer.append(i);
		}
		long t6 = System.nanoTime();
		System.out.println("StringBuffer耗时为: " + (t6-t5));
	}
}
