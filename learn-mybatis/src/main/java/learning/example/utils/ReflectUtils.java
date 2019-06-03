/**
 * 
 */
package learning.example.utils;

import java.lang.reflect.Field;

/**
 * @author Xiong.Liu
 *
 */
public class ReflectUtils {
	/**
	 *  Get the specify property of specify object using reflect
	 * @param obj the taget object
	 * @param fieldName the taget property
	 * @return the value of taget property
	 */
	public static Object getFieldValue(Object obj, String fieldName) {
		Object result = null;
		Field field = ReflectUtils.getField(obj, fieldName);
		if (field != null) {
			field.setAccessible(true);
			try {
				result = field.get(obj);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException ex) {
				ex.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 *  Get the specify property in specify object using reflect
	 * @param obj the taget object
	 * @param fieldName the taget property
	 * @return the taget field
	 */
	public static Field getField(Object obj, String fieldName) {
		Field field = null;
		
		for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				break;
			} catch (NoSuchFieldException e) {
			}
		}
		
		return field;
	}
	
	/**
	 * Set the specify property in specify object using reflect
	 * @param object the taget object
	 * @param fieldName the taget property
	 * @param fieldValue the taget value
	 */
	public static void setFieldValue(Object object, String fieldName, String fieldValue) {
		Field field = ReflectUtils.getField(object, fieldName);
		if (field != null) {
			field.setAccessible(true);
			try {
				field.set(object, fieldValue);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
