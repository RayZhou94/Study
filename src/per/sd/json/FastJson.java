package per.sd.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import per.sd.colection.Colection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

/**
 * 阿里的json解析速度很快格式要求严格
 * @author shallowdream
 *
 */
public class FastJson {
	public static void demo1(){
		Teacher teacher = new Teacher();
		
		teacher.setName("何小英");
		teacher.setAge(23);
		teacher.setSex("男");
		teacher.setAddress("安徽省");
		teacher.setDate(new Date());
		
		List<Teacher> list = new  ArrayList<>();
		list.add(teacher);
		
		Teacher teacher2 = new Teacher();
		teacher2.setName("何小英");
		teacher2.setAge(23);
		teacher2.setSex("男");
		teacher2.setAddress("杭州");
		teacher2.setDate(new Date());
		
		list.add(teacher2);
		//SimplePropertyPreFilter filter = new SimplePropertyPreFilter(teacher.getClass(),"age");
		String st = JSON.toJSONString(list,true);
		
		//System.out.println(st);
		List<Teacher> list2 = JSON.parseObject(st,new TypeReference<List<Teacher>>(){});
		for (Teacher teacher3 : list2) {
			System.out.println(teacher3.getAddress());
		}	
//		String str = "何处繁华笙歌落";
//		System.out.println(JSON.toJSONString(str));
	}
	
	public static void demo2(){
		Teacher teacher = new Teacher();
		teacher.setName("何小英");
		teacher.setAge(23);
		teacher.setSex("男");
		teacher.setAddress("安徽省");
		teacher.setDate(new Date());
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(teacher.getClass());
		//过滤掉
		filter.getExcludes().add("sex");
		//保留下
		filter.getIncludes().addAll(Arrays.asList("age","address","sex"));
		System.out.println(JSON.toJSONString(teacher,filter));
	}
	public static void main(String[] args) {
		demo2();
	}
}
