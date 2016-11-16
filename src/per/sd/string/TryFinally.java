package per.sd.string;

/**
 * finally 在return之后执行但是在return结束程序之前
 * @author shallowdream
 *
 */
public class TryFinally {
	private int i = 0;
	public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        System.out.println(new TryFinally().test());
        //System.err.println(new TryFinally().a());
    }
    @SuppressWarnings("finally")
	int test()  
    {  
        try  
        {  
            return i;  
        }  
        finally  
        {  
            return ++i;  
        }
    }  
      
    int func1()  
    {  
        System.out.println("func1");  
        return i;  
    }  
    void func2()  
    {  
        System.out.println("func2");
        i=3;
        //return 2;  
    } 
}
