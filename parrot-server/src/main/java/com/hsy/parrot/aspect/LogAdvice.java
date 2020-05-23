package com.hsy.parrot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author:hsy
 * @description: 用于给目标方法添加日志操作
 * @date 2020/1/15 10:56
 */
@Slf4j
public class LogAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StringBuilder parameters = new StringBuilder();
        String classWay;

        Method method = methodInvocation.getMethod();
        String methodName = method.getName();
        Class<?> declaringClass = method.getDeclaringClass();
        classWay = declaringClass.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> returnType = method.getReturnType();
        if (parameterTypes != null && parameterTypes.length > 0) {
            Arrays.stream(parameterTypes).forEach(x -> parameters.append(x + ", "));
        }
        log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ":" + classWay + "." + methodName + "(" + parameters.toString() + ") return:" + returnType.getName());
        Object o = methodInvocation.proceed();
        return o;
    }
}
