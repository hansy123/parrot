package com.hsy.parrot.aspect;

import com.hsy.parrot.annotation.RequireLog;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author:hsy
 * @description:
 * @date 2020/1/15 10:59
 */
@Component
public class LogAdvisor extends StaticMethodMatcherPointcutAdvisor {

    public LogAdvisor(){
        setAdvice(new LogAdvice());
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {

        try {
            Method targetMethod = targetClass.getMethod(method.getName(), method.getParameterTypes());
            return targetMethod.isAnnotationPresent(RequireLog.class);
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}
