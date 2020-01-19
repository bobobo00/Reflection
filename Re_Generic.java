package Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;



/**
 * ͨ�������ȡ������Ϣ
 * @author dell
 *
 */
public class Re_Generic {
	
	public void test01(Map<String,User> map,List<User> list){
		System.out.println("test01()");
	}
	
	public Map<Integer,User> test02(){
		System.out.println("test02()");
		return null;
	}
	
	public static void main(String[] args) {
		try {
			//���ָ����������������Ϣ
			Method m = Re_Generic.class.getMethod("test01", Map.class,List.class);
			Type[] t = m.getGenericParameterTypes();
			for (Type paramType : t) {
				System.out.println("#"+paramType);
				if(paramType instanceof ParameterizedType){
					Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
					for (Type genericType : genericTypes) {
						System.out.println("�������ͣ�"+genericType);
					}
				}
			}
			
			//���ָ����������ֵ������Ϣ
			Method m2 = Re_Generic.class.getMethod("test02", null);
			Type returnType = m2.getGenericReturnType();
			System.out.println("#"+returnType);
			if(returnType instanceof ParameterizedType){
					Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
					for (Type genericType : genericTypes) {
						System.out.println("����ֵ���������ͣ�"+genericType);
					}
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}