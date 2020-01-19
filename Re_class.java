package Reflection;
/**
 * 测试各种类型（class,interface,enum,Annotation,int[],String）java.lang.Class对象的获取方式。
 * @author dell
 *
 */
@SuppressWarnings("all")
public class Re_class {
	public static void main(String[] args) {
		String path="Reflection.User";
		try {
			//所有的类型都会对应一个Class对象。
			Class clz=Class.forName(path);
			//对象是表示或封装一些数据，一个类被加载互殴，JVM会创建一个对应该类的Class对象，类的整个结构信息
			//会被放到对应的Class对象中。这个Class对象就像一面镜子一样，可以通过这面镜子可以看到对应类的全部信息。
			System.out.println(clz);
			System.out.println(clz.hashCode());
			
			//同样一个类只对应一个Class对象。
			Class clzz=Class.forName(path);
			System.out.println(clzz.hashCode());
		    Class strClz=String.class;
		    Class strClzz=path.getClass();
		    System.out.println(strClz==strClzz);
		    Class intclz=int.class;
		    int[] arr01=new int[10];
		    int[] arr02=new int[20];
		    //所有一维数组的Class为同一个，无论长度。
		    System.out.println(arr01.getClass().hashCode());
		    System.out.println(arr02.getClass().hashCode());
		    int[][] arr=new int[3][4];
		    System.out.println(arr.getClass().hashCode());
		    double[] darr=new double[2];
		    System.out.println(darr.getClass().hashCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
