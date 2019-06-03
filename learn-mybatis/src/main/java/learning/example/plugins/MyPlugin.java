/**
 * 
 */
package learning.example.plugins;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * @author Xiong.Liu
 *
 */
@Intercepts({@Signature(
		type = Executor.class,
		method = "update",
		args = {MappedStatement.class, Object.class})})
public class MyPlugin implements Interceptor {

	/* (non-Javadoc)
	 * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("This is intercept...................");
		return invocation.proceed();
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
	 */
	@Override
	public Object plugin(Object target) {
		System.out.println("This is plugin...................");
		return Plugin.wrap(target, this);
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
	 */
	@Override
	public void setProperties(Properties properties) {
		System.out.println("This is setProperties...................");
		String prop1 = properties.getProperty("prop1");
		String prop2 = properties.getProperty("prop2");
		System.out.println(prop1 + "------" + prop2);
		
	}

}
