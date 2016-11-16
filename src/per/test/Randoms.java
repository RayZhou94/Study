package per.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
/**
 * //DecimalFormat    df   = new DecimalFormat("######0.0");
 * @author shallowdream
 *
 */
public class Randoms {
	public static void main(String[] args) {
		print(0, 10, 5.5, 38.5);
		//shuiyundi2();
		//shuizhi(1, 9);
	}
	public static void shuizhi(double a, double b){
		Random random = new Random();
		for (int i = 0; i < 79; i++) {
			double num = a + random.nextDouble()*(b-a);
			DecimalFormat    df   = new DecimalFormat("######0.00");
			System.out.println(df.format(num));
		}
	}
	public static void shuiyundi2(){
		File file1 = new File("src/per/test/test1.txt");
		File file2 = new File("src/per/test/test2.txt");
		File file3 = new File("src/per/test/test3.txt");
		BufferedWriter osw1  = null;
		BufferedWriter osw2  = null;
		BufferedWriter osw3  = null;
		try {
			osw1 = new BufferedWriter(new FileWriter(file1,true));
			osw2 = new BufferedWriter(new FileWriter(file2,true));
			osw3 = new BufferedWriter(new FileWriter(file3,true));
			double a = 0.0;
			double b = 0.0;
			double c = 0.0;
			Random random = new Random();
			for (int i = 0; i < 128; i++) {
				a = 4000 + random.nextDouble()*2000;
				b = 3000 + random.nextDouble()*2000;
				c = 100 + random.nextDouble()*2000;
				DecimalFormat    df   = new DecimalFormat("######0.0");
				String aa = df.format(a);
				String bb = df.format(b);
				String cc = df.format(c);
				if (a > b && b > c) {
					osw1.write(aa + "\n");
					osw2.write(bb + "\n");
					osw3.write(cc + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (osw1 != null) {
				try {
					osw1.flush();
					osw1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (osw2 != null) {
				try {
					osw2.flush();
					osw2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (osw3 != null) {
				try {
					osw3.flush();
					osw3.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static double[] randoms(int a, int b, double c){
		double list[] = new double[24];
		double temp = 0;
		for (int i = 0; i < 23; i++) {
			Random random = new Random();
			double num = a + random.nextInt(b-a);
			boolean flag = random.nextBoolean();
			if (flag) {
				num += 0.5;
			}
			temp += num;
			list[i] = num;
		}
		list[23] = temp + c;
		return list;
	}
	public static void shuiyundi(){
		String [] list1 = new String[128];
		String [] list2 = new String[128];
		String [] list3 = new String[128];
		File file = new File("src/per/test/test.txt");
		BufferedWriter osw  = null;
		try {
			osw = new BufferedWriter(new FileWriter(file,true));
			double a = 0.0;
			double b = 0.0;
			double c = 0.0;
			Random random = new Random();
			for (int i = 0; i < 128; i++) {
				a = 4000 + random.nextDouble()*2000;
				b = 3000 + random.nextDouble()*2000;
				c = 100 + random.nextDouble()*2000;
				DecimalFormat    df   = new DecimalFormat("######0.0");
				String aa = df.format(a);
				String bb = df.format(b);
				String cc = df.format(c);
				if (a > b && b > c) {
//					list1[i] = aa + "\n";
//					list2[i] = bb + "\n";
//					list3[i] = cc + "\n";
				}
			}
			for (int i = 0; i < list1.length; i++) {
				System.out.println(list1[i]);
				//osw.write(list1[i]);
				//System.out.println(list1[i]);
			}
			osw.write("-----------------------------\n");
			for (int i = 0; i < list2.length; i++) {
				//osw.write(list2[i]);
			}
			osw.write("-----------------------------\n");
			for (int i = 0; i < list3.length; i++) {
				//osw.write(list3[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (osw != null) {
				try {
					osw.flush();
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void print(int a, int b, double c, double d){
		double num[] = randoms(a, b, c);
		while (num[23] - d > 1 || num[23] - d < -1) {
			num = randoms(a, b, c);
		}
		for (double e : num) {
			System.out.println(e);
		}
	}
}
