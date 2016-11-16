package per.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {
	public static void main(String[] args) {
		//print();
		split("史河豫皖缓冲区 ");
	}
	public static void print(){
		String str = "红旗水库（长丰） 蔡塘水库 东山水库（含山） 境主庙水库 红旗水库（潜山） 长春水库 新安江水库 岳庄坝水库 化家湖水库 分水岭水库 练子山水库"
				+" 大井水库 墩子王水库 龙潭寺水库 老圈行水库 龙门寺水库 土桥水库 岱山水库 马厂水库 三湾水库 长丰大官塘水库 戎桥水库 昭关水库 长山水库 磨墩水库 张院水库"
				+" 张家湾水库 青阳东山水库 麻塘湖水库 金家岭水库 塘埂头水库 桑涧水库 定远解放水库 杜集水库 定远岱山水库 南店水库 平阳水库 仓东水库 红丰水库 岗王水库 小李水库 明城寺水库 陶老坝水库 魏老河水库 袁河西水库 管湾水库 花果水库 龙须湖水库 马鞍山水库 观音洞水库 毛坦水库 蝎子山水库 水门塘水库"
				+" 新集水库 定远蔡桥水库 安丰塘水库 屯仓水库 芝麻水库 城北水库 永丰水库（长丰） 城西水库 双河水库（长丰） 罗集水库 张桥水库（长丰） 众兴水库 赵店水库 下汤水库 牯牛背水库 毛尖山水库 卢村水库 方洲台水库 钓鱼水库 丰乐水库 樵子涧水库 大通水库 鹿塘水库 跃进水库 石坝水库 大涧口水库 青春水库 天子门水库"
				+" 大板水库 长江干流（安徽段） 新安江 焦岗湖 八里湖 石门湖 破罡湖 天河湖 枫沙湖 老汪湖 天井湖 沱湖 女山湖 花园湖 黄陂湖 石臼湖 高邮湖 武昌湖 瓦埠湖 高塘湖 白荡湖 陈瑶湖 巢湖 龙感湖 城西湖 大官湖 城东湖 泊湖 黄湖 四方湖 升金湖 香涧湖 龙子湖 南漪湖 菜子湖 洪泽湖 湖测试 七里湖 泥塘沟 怀洪新河 涡河 怀洪新河"
				+" 浍河 沙颖河 茨淮新河 尧渡河 黄湓河 横埠河 九华河 青通河 裕溪河 牛屯河 裕溪河 青弋江 荆山河 水阳江 青山河 濠河 黄浒河 得胜河 青山河 姑溪河 磨子潭水库 安乐水库 大通水库 淮河干流（安徽段） 曹集 淮河干流（安徽段） 陈村 淮河干流（安徽段） 南照集 淮河干流（安徽段） 汪集 淮河干流（安徽段） 正阳关 淮河干流（安徽段） 凤台"
				+" 淮河干流（安徽段） 淮南 淮河干流（安徽段） 蚌埠 淮河干流（安徽段） 花园湖 淮河干流（安徽段） 临潼关 淮河干流（安徽段） 五河 淮河干流（安徽段） 浮山 淮河干流（安徽段） 小柳巷 淮河干流（安徽段） 洪泽湖 八里湖 武昌湖 瓦埠湖 高塘湖 巢湖 城东湖 泊湖 四方湖 香涧湖 菜子湖 淮河干流（安徽段） 汪集 淮河干流（安徽段） 蚌埠 淮河干流（安徽段）"
				+" 凤台 淮河干流（安徽段） 蚌埠 淮河干流（安徽段） 淮南 淮河干流（安徽段） 蚌埠 淮河干流（安徽段） 五河 淮河干流（安徽段） 浮山 淮河干流（安徽段） 小柳巷 淮河干流（安徽段） 五河 淮河干流（安徽段） 八里湖 八里湖 石门湖 石门湖 天河湖 天河湖 龙感湖 龙感湖 大官湖 大官湖 龙感湖 龙感湖 湖测试 湖测试 大官湖 大官湖";
		for (String aaa : str.split(" ")) {
			split(aaa);
		}
	}
	public static void split(String str){
		File file = new File("C:\\Users\\shallowdream\\Desktop\\test3.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = "";
			boolean flag = false;
			while ((line = br.readLine())!=null) {
				Matcher matcher = Pattern.compile("\\d+.\\d+.\\d+\\t"+str+"$").matcher(line);
				Matcher matcher2 = Pattern.compile("\\d+.\\d+.\\d+\\t").matcher(line);
				if (matcher.find()) {
					flag = true;
				}else if (matcher2.find()) {
					flag = false;
				}
				if (flag) {
					System.out.println(line);
//					Matcher matcher3 = Pattern.compile(str+".*区$").matcher(line);
//					while (matcher3.find()) {
//						System.out.println(matcher3.group());
//					}
				}
			}
		} catch (Exception e) {
		}finally{
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
