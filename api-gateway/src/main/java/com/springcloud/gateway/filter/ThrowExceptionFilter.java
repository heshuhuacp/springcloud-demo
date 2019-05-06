package com.springcloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ThrowExceptionFilter<doSomething> extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(
            ThrowExceptionFilter.class);

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

        logger.info("This is a pre filter, it will thorw a RuntimeException");
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            doSomething();
        } catch (Exception e) {
            throw new ZuulException(e.getCause(), 401 , e.getMessage());
        }
        return null;
    }

    private void doSomething(){

        throw new RuntimeException("Exists some errors");
    }
}
