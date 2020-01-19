package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射API动态操作：构造器，属性，方法
 * @author dell
 *
 */

public class Re_Use {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		String path="Reflection.User";
		try {
			Class<User> clz=(Class<User>)Class.forName(path);
			//通过反射API调用构造调用方法，构造对象
			User u=clz.newInstance();//调用了User的无参构造。
			
			Constructor<User> c=clz.getDeclaredConstructor(int.class,String.class,int.class);
			User user=c.newInstance(1001,"小花",18);//指定实参
			System.out.println(user.getName());
			
			//通过反射API动态调用普通方法
			User u3=clz.newInstance();
			Method method=clz.getDeclaredMethod("setName", String.class);
			method.invoke(u3, "小草");//u3.setName("小草")
			System.out.println(u3.getName());
			
			//通过反射API获取属性
			User u4=clz.newInstance();
			Field f=clz.getDeclaredField("name");
			f.setAccessible(true);//这个属性不需要安全检查，可以直接访问私有属性
			f.set(u4, "小树");//通过反射直接写属性
			System.out.println(f.get(u4));//通过反射直接读属性
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
