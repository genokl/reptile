package cn.zgyt.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class CommonUtil {

	
	public static Object formJsonToObject(Map m,Class clazz) {
		String json = new Gson().toJson(m);
		return new Gson().fromJson(json, clazz);
	}
	
	public static String getJsonStr(String key,Object value) {
		Gson g=new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(key, value);
		return g.toJson(map);
	}
	
	public static String getFormatJsonStr(Object value) {
		GsonBuilder gsonBuilder = new GsonBuilder();  
		gsonBuilder.setDateFormat("dd/MM/yyyy");  
		Gson g = gsonBuilder.create();
		return g.toJson(value);
	}
	
	/**
	 * 获取范围随机数[m,n]
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static Integer loadRandomNum(Integer m, Integer n) {
		return m + (int) (Math.random() * (n + 1 - m));
	}
	
	/**
	 * 四舍五入
	 * 
	 * @param m
	 * @param type 1进一法
	 */
	public static Double roundNum(Double m, Integer type) {
		if (type == 1) {
			String ss = m.toString();
			int s1 = Integer.valueOf(ss.substring(0, 1)) + 1;
			int length = ss.split("\\.")[0].length();
			Double s2 = s1 * (Math.pow(10, length - 1));
			return s2;
		}
		return m;
	}

	/**
	 * 检查字符串是否为空, 为空则返回true 反之返回false
	 * @param param
	 * @return
	 */
	public static boolean checkFull(String param) {
		return ((null == param || "".equals(param.trim()) || "null".equals(param.trim())) ? true : false);
	}

	public static String getStringFromStream(HttpServletRequest req) {
		ServletInputStream is;
		try {
			is = req.getInputStream();
			int nRead = 1;
			int nTotalRead = 0;
			byte[] bytes = new byte[10240];
			while (nRead > 0) {
				nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);
				if (nRead > 0)
					nTotalRead = nTotalRead + nRead;
			}
			String str = new String(bytes, 0, nTotalRead, "utf-8");
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	
	public static void main(String[] args) {
		double a = 745*20;
		double b=a;
//		for (int i = 0; i < 9; i++) {
//			System.out.println(i);
//			a=a*0.9;
//			b+=a;
//			System.out.println(b);
//		}
		double c = (a*Math.pow(0.9, 9)+a)*10/2;
		System.out.println(c);
	}

	public static boolean isNumber(String sortStr) {
		for(int i=sortStr.length();--i>=0;){
		      int chr=sortStr.charAt(i);
		      System.out.println(chr);
		      if(chr<48 || chr>57) {
		        if(chr != 46)
		    	  return false;
		      }
		   }
		return true;
	}
}
