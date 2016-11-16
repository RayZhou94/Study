package per.sd.annotation;

import java.lang.reflect.Field;

public class AnnotationDemoImpl {
	public static void test(Class<?> class1){
		System.out.println(class1.getDeclaredFields().length);
	}
}
