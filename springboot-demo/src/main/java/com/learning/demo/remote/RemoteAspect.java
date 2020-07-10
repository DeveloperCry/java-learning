package com.learning.demo.remote;

import com.learning.demo.remote.annotation.Remote;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;

@Aspect
@Component
public class RemoteAspect {

    @Before("@With(com.learning.demo.remote.annotation.Remote) && @annotation(org.springframework.web.bind.annotation.RequestMapping))")
    public Object before(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Remote remote = method.getAnnotation(Remote.class);
        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
        String[] url;
        String[] uri;
        if (remote != null) {
            url = remote.value();
        }

        if (requestMapping != null) {
            uri = requestMapping.value();
        }

        RestTemplate restTemplate = new RestTemplate();

        return null;

    }
}
