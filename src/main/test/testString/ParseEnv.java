package testString;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseEnv {

	public static Map<String,String> EnvMap = new HashMap<String,String>();
	public static void ParseByRegEx(String str) {
		String string = str;
		String regex = "[a-z]+:";
		String regex1 = "[---]";
		Pattern pat = Pattern.compile(regex1);
		Matcher mat = pat.matcher(string);
		if (mat.find()) {
			for (int i = 0; i <= mat.groupCount(); i++) {
				System.out.println(mat.group(i));
			}
		}else{
			System.out.println("没有找到匹配的字符串");
		}
	}
	
	public static void  stringSplit(String s){
		String string = s;
		String[]ss=string.split("\n");
		for(int i=0;i<ss.length;i++){
			System.out.println(ss[i]);
			getDetails(ss[i]);
		}
	}
	public static void getDetails(String s){
		String string =s;
		String[]ss =string.split(":");
		if(ss.length==2){
			EnvMap.put(ss[0],ss[1]);
		}
	}
	
	public static void main(String args[]) throws IOException{
		StringBuilder stringneedparse = new StringBuilder();
	try {
		BufferedReader reader = new BufferedReader(new FileReader("/home/milliant/桌面/fileparse.txt"));
//		String temp = reader.readLine();
		String temp;
		while((temp =reader.readLine())!=null){
			stringneedparse.append(temp+"\n");
		}
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		System.out.println(stringneedparse);
		
		String str = stringneedparse.toString();
		int startId = 7;
		
		str = str.substring(startId);
		System.out.println("在字符串前面添加\"并将所有的\\n替换成\",\"后，结果为：");
		str = ("\"" + str).replaceAll("\n", "\",\"");
		System.out.println(str);
		System.out.println("接下来将: 替换成\":\"，结果为：");
		str = str.replaceAll(": ", "\":\"");
		System.out.println(str);
		str = str.substring(0, str.length() - 2);
		str = "{" + str + "}";	
		
		System.out.println("解析后的字符串是：\n"+str);
//		System.out.println("通过正则表达式解析的内容是：");
//		ParseEnv.ParseByRegEx(stringneedparse.toString());
		System.out.println("字符串分解的结果是：");
		stringSplit(stringneedparse.toString());
		System.out.println(EnvMap);
	}
}
