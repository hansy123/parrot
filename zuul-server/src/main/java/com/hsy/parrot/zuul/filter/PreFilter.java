package com.hsy.parrot.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:hsy
 * @description:
 * @date 2019/11/27 17:17
 */
@Slf4j
@Component
public class PreFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURI(), request.getRequestURL()));
        valiHeader(ctx, request);
        valiIp(request);

        log.info("ok");
        ctx.setResponseStatusCode(200);
        return null;
    }

    /**
     * 校验ip
     *
     * @param request
     */
    private void valiIp(HttpServletRequest request) {
        String ip = getIpAddress(request);
        log.info("ip:{}", ip);
        // 获取ip是否在黑名单中
        // 令牌算法，校验ip是否恶意访问 限流
    }

    /**
     * 校验请求头
     *
     * @param ctx
     * @param request
     */
    private void valiHeader(RequestContext ctx, HttpServletRequest request) {
        String token = request.getHeader("token");
        String contentType = request.getHeader("Content-Type");
        if (null == token) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
            }
        } else if (contentType == null || !contentType.equals("application/json")) {
            log.warn("Content-Type is empty or Illegal");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("Content-Type is empty or Illegal");
            } catch (Exception e) {
            }
        }
    }


    /**
     * 获取真实ip
     *
     * @param request
     * @return
     */
    private String getIpAddress(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
