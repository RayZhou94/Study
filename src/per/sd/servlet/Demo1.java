package per.sd.servlet;
/**
 * servlet工作步骤
 * 
 * 1、客户端先发送一个request请求
 * 2、servlet容器接受请求
 * 3、servlet容器创建httprequest对象将请求封装到这个对象中
 * 4、servlet容器创建httpresponse对象
 * 5、servlet容器调用service方法，并将httprequest对象和httpresponse对象作为参数传给httpservlet对象
 * 6、httpservlet对象调用httprequest对象的有关方法获取http请求信息
 * 7、httpservlet对象调用httpresponse对象的有关方法生成响应数据
 * 8、servlet容器把httpservlet对象的响应结果传给客户端
 * 
 * 
 * servlet 生命周期
 * Servlet的生命周期是由Servlet的容器来控制的，它可以分为3个阶段;初始化，运行，销毁。
 * init（）初始化
 * service（）服务
 * destroy（）销毁
 * 1、初始化阶段
 * servlet容器加载servlet类，并将其.class文件读取到内存中
 * servlet容器创建servletConfig对象。包含了servlet的初始化配置信息
 * servlet容器创建一个servlet对象
 * servlet容器调用servlet对象的init方法进行初始化。
 * 
 * 个人见解
 * servlet和servlet容器不是一个概念
 * servlet现在通常是我们自己写的java程序，而servlet容器是为了管理它们的
 * 现在的servlet程序通常继承自httpServlet抽象类，而这个抽象类又继承自GenericServlet抽象类，同样继承自servlet接口
 * 所以说是个servlet程序，或者servlet对象就是这么来的
 * 而Httpservletrequest是个接口，继承自ServletRequest接口
 * 
 * @author shallowdream
 *
 */
public class Demo1{
	public static void main(String[] args) {
		
	}
}
