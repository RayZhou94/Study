package per.sd.annotation;

public class TestDemo1 {
	
	@AnnotationDemo1(value=3)
	private TestDemo1 demo1;
	
	@AnnotationDemo1
	private String str;
	
	public static void main(String[] args) {
		AnnotationDemoImpl.test(TestDemo1.class);
		
	}
	public static void demo1(){
		
	}
}
