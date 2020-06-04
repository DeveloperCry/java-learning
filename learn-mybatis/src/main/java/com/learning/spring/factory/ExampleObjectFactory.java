/**
 * 
 */
package com.learning.spring.factory;

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import com.learning.spring.enity.User;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * @author Xiong.Liu
 *
 */
public class ExampleObjectFactory extends DefaultObjectFactory{
	
	private static final long serialVersionUID = 1L;

	public Object create(Class type) {
		
		if (type.equals(User.class)) {
			User user = (User)super.create(type);
			user.setAddress("Chengdu, China");
			return user;
		}
		return super.create(type);
	}
	
	//Will be called at initializing sesstion factoty.
	@Override
	public void setProperties(Properties properties) {
		
		for (Iterator iterator = properties.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			System.out.println(properties.getProperty(key));
		}
		
		super.setProperties(properties);
	}
	
	@Override
	public <T> boolean isCollection(Class<T> type) {
		return Collection.class.isAssignableFrom(type);
	}
}
