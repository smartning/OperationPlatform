package com.op.core.rest;

import com.google.gson.JsonObject;
import com.netflix.loadbalancer.LoadBalancerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/16.
 ****************************************/
@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public class TestRest {
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private LoadBalancerContext loadBalancerContext;
    @Path("/info")
    @GET
    public String info(){
        int s=loadBalancerContext.getLoadBalancer().chooseServer("oauth").getPort();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("oauth", s);
        return jsonObject.toString();
    }
    @Path("/test")
    @GET
    public String test(){
        int s=loadBalancerContext.getLoadBalancer().chooseServer("proxy").getPort();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("proxy", s);
        return jsonObject.toString();
    }


}
