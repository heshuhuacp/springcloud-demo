package com.springcloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";//前置过滤
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request =  ctx.getRequest();

        logger.info("send {} request to {}", request.getMethod()
                ,request.getRequestURI().toString());

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null){
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
        }
        logger.info("access token ok");
        return null;
    }
}
