/**
 * 
 */
package learning.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Xiong.Liu
 *
 */
//@Aspect
@Component
public class SystemArchitecture {
	
	@Pointcut("within(com.spring.framework.example.web..*)")
	public void inWebLayer() {
		System.out.println("inWebLayer");
	}
	
	@Pointcut("within(com.spring.framework.example.service..*)")
	public void inServicdLayer() {
		System.out.println("inServicdLayer");
	}
	
	@Pointcut("within(com.spring.framework.example.dao..*)")
	public void inDataAccessLayer() {
		System.out.println("inDataAccessLayer");
	}
	
	@Pointcut("execution(* com.spring.framework.example.*.*(..))")
	public void businessService() {
		System.out.println("businessService");
	}
	
	@Pointcut("execution(* com.spring.framework.example.dao.*.*(..))")
	public void dataAccessOperation() {
		System.out.println("dataAccessOperation");
	}
}
