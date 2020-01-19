package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API获取类的信息（类的名字，属性，方法，构造器）。
 * @author dell
 *
 */

public class Re_info {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		String path="Reflection.User";
		try {
			Class clz=Class.forName(path);
			//System.out.println(clz);
			
			//获取类的名字
			System.out.println(clz.getName());//包名.类名
			System.out.println(clz.getSimpleName());//类名
			//相关属性信息
			Field[] field=clz.getFields();//只能获取public的field；
			System.out.println(field.length);
			Field[] fields=clz.getDeclaredFields();//可以获得所有的field
			System.out.println(fields.length);
			for(Field ff:fields) {
				System.out.println(ff);
			}
			Field f=clz.getDeclaredField("age");
			//方法信息
			Method[] method=clz.getMethods();//只能获取public的method
			System.out.println(method.length);
			Method[] methods=clz.getDeclaredMethods();//可以获得所有的method
			for(Method mm:methods) {
				System.out.println(mm);
			}
			Method m=clz.getDeclaredMethod("setName", String.class);//避免重载的问题，需要传递参数。	
			//构造器
			 Constructor[] constructors=clz.getDeclaredConstructors();
			 for(Constructor cc:constructors) {
				 System.out.println(cc);
			 }
			 System.out.println(clz.getDeclaredConstructor(null));
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
