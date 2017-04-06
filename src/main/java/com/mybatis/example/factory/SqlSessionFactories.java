package com.mybatis.example.factory;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactories {
	
	public static SqlSessionFactory sessionFactory = null;
	public final static String resource = "com/mybatis/example/conf/mybatis-config.xml";
	
	/**
	 * SqlSessionFactoryBuilder
	 *   This class can be instantiated, used and thrown away. There is no need to keep it around once you've created your SqlSessionFactory. 
	 *   Therefore the best scope for instances of SqlSessionFactoryBuilder is method scope (i.e. a local method variable). 
	 *   You can reuse the SqlSessionFactoryBuilder to build multiple SqlSessionFactory instances, but it's still best not to keep it around to ensure 
	 *   that all of the XML parsing resources are freed up for more important things.
	 * SqlSessionFactory
	 *   Once created, the SqlSessionFactory should exist for the duration of your application execution. 
	 *   There should be little or no reason to ever dispose of it or recreate it. 
	 *   It's a best practice to not rebuild the SqlSessionFactory multiple times in an application run. 
	 *   Doing so should be considered a “bad smell”. Therefore the best scope of SqlSessionFactory is application scope. 
	 *   This can be achieved a number of ways. The simplest is to use a Singleton pattern or Static Singleton pattern.
	 * SqlSession
	 *   Each thread should have its own instance of SqlSession. Instances of SqlSession are not to be shared and are not thread safe. 
	 *   Therefore the best scope is request or method scope. Never keep references to a SqlSession instance in a static field or even an instance field of a class. 
	 *   Never keep references to a SqlSession in any sort of managed scope, such as HttpSession of the Servlet framework. 
	 *   If you're using a web framework of any sort, consider the SqlSession to follow a similar scope to that of an HTTP request. 
	 *   In other words, upon receiving an HTTP request, you can open a SqlSession, then upon returning the response, you can close it. 
	 *   Closing the session is very important. You should always ensure that it's closed within a finally block. 
	 *   The following is the standard pattern for ensuring that SqlSessions are closed: 
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		InputStream inputStream = null;
		SqlSessionFactoryBuilder sessionFactoryBuilder = null;
		try {
			if (sessionFactory == null) {
				System.out.println("intital ..............");
				sessionFactoryBuilder = new SqlSessionFactoryBuilder();
				inputStream = Resources.getResourceAsStream(resource);
				sessionFactory = sessionFactoryBuilder.build(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
	
}
