package com.op.es.action.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import java.io.IOException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/17.
 ****************************************/
@Provider
public class OpResponseFilter implements ContainerResponseFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpResponseFilter.class);
    @Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        LOGGER.info("response sttaus is " + responseContext.getStatus());
    }
}