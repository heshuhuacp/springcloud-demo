package com.springcloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

public class ErrorFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 20;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        logger.error("this is a ErrorFilter:{}", throwable.getMessage());
        ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ctx.set("error.exception", throwable.getCause());
        ctx.setThrowable(throwable);
        return null;
    }
}
