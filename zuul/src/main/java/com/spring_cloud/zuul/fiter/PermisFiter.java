package com.spring_cloud.zuul.fiter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PermisFiter extends ZuulFilter {

    /**
     * 过滤器类型,权限判断设置为pre
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器优先级
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否要走这个过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 核心过滤器都写在这
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();//获取当前请求
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(!username.equals("dan") && !password.equals("123")){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.addZuulResponseHeader("context-type","text/html;charset=utf-8");
            context.setResponseBody("非法请求");

        }
        return null;
    }
}
