package weather;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 */
public class ReflectTest{

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("log.txt",true);
		try{
			Class clazz=Entity.class;
			Object entity= clazz.newInstance();

			//获取变量
			Field fieldPrivate=clazz.getDeclaredField("fieldPrivate"),
					fieldStaticPrivate=clazz.getDeclaredField("fieldStaticPrivate"),
					fieldPublic=clazz.getDeclaredField("fieldPublic"),
					fieldStaticPublic=clazz.getDeclaredField("fieldStaticPublic");

			//获取方法
			Method operateWithFieldPrivate=clazz.getDeclaredMethod("operateWithFieldPrivate"),
					operateWithFieldStaticPrivate=clazz.getDeclaredMethod("operateWithFieldStaticPrivate"),
					operateWithFieldPublic=clazz.getDeclaredMethod("operateWithFieldPublic"),
					operateWithFieldStaticPublic=clazz.getDeclaredMethod("operateWithFieldStaticPublic"),
					hasParameterMethod=clazz.getDeclaredMethod("hasParameterMethod",new Class[]{String.class,String.class}),
					hasChangeableParameterMethod=clazz.getDeclaredMethod("hasChangeableParameterMethod",Object[].class);

			//私有属性
			fieldPrivate.setAccessible(true);
			fieldPrivate.set(entity, "fieldPrivate's value");
			fos.write(String.valueOf(fieldPrivate.get(entity)).getBytes());
//			System.out.println(fieldPrivate.get(entity));

			//静态私有属性
			fieldStaticPrivate.setAccessible(true);
			fieldStaticPrivate.set(null, "fieldStaticPrivate's value");
			fos.write(String.valueOf(fieldStaticPrivate.get(null)).getBytes());
			System.out.println(fieldStaticPrivate.get(null));

			//公共属性
			fieldPublic.set(entity, "fieldPublic's value");
			fos.write(String.valueOf(fieldPrivate.get(entity)).getBytes());
			System.out.println(fieldPublic.get(entity));

			//公共静态属性
			fieldStaticPublic.set(null, "fieldStaticPublic's value");
			fos.write(String.valueOf(fieldStaticPublic.get(null)).getBytes());
			System.out.println(fieldStaticPublic.get(null));

			//私有方法
			operateWithFieldPrivate.setAccessible(true);
			fos.write(String.valueOf(operateWithFieldPrivate.invoke(entity)).getBytes());
			System.out.println(operateWithFieldPrivate.invoke(entity));

			//私有静态方法
			operateWithFieldStaticPrivate.setAccessible(true);
			fos.write(String.valueOf(operateWithFieldStaticPrivate.invoke(null)).getBytes());
			System.out.println(operateWithFieldStaticPrivate.invoke(null));

			//公共方法
			fos.write(String.valueOf(operateWithFieldPublic.invoke(entity)).getBytes());
			System.out.println(operateWithFieldPublic.invoke(entity));

			//公共静态方法
			fos.write(String.valueOf(operateWithFieldStaticPublic.invoke(null)).getBytes());
			System.out.println(operateWithFieldStaticPublic.invoke(null));

			fos.write(String.valueOf(hasParameterMethod.invoke(entity, new String[]{"param1","param2"})).getBytes());
			System.out.println(hasParameterMethod.invoke(entity, new String[]{"param1","param2"}));


			Object[] objects={"param1","param2","param3","param4"};
			fos.write(String.valueOf(hasChangeableParameterMethod.invoke(entity, new Object[]{objects})).getBytes());
			System.out.println(hasChangeableParameterMethod.invoke(entity, new Object[]{objects}));

			//带可变长度参数的方法2----------等同于数组
			Object arrayObj = Array.newInstance(Object.class, 4);
			Array.set(arrayObj, 0, "param1");
			Array.set(arrayObj, 1, "param2");
			Array.set(arrayObj, 2, "param3");
			Array.set(arrayObj, 3, "param4");
			fos.write(String.valueOf(hasChangeableParameterMethod.invoke(entity, arrayObj)).getBytes());
			System.out.println(hasChangeableParameterMethod.invoke(entity, arrayObj));

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			fos.close();
		}
	}

}
