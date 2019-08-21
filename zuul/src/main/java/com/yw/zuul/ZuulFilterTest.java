package com.yw.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.jboss.logging.Logger;

import javax.servlet.http.HttpServletRequest;

public class ZuulFilterTest extends ZuulFilter {
    private final org.jboss.logging.Logger log = Logger.getLogger(getClass());

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String code = request.getParameter("code");
        if (code == null) {
            log.warn("==code is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("==code is ok");
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public String filterType() {
        return "pre";
    }

}