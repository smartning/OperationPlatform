package com.op.core.rest;


import com.google.gson.JsonObject;
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
@Path("/info")
@Produces({MediaType.APPLICATION_JSON})
public class Info {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    @Path("/info")
    @GET
    public String info(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("oauth", loadBalancerClient.choose("oauth").getUri().toString());
        return jsonObject.toString();
    }
    @Path("/test")
    @GET
    public String test(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("proxy", loadBalancerClient.choose("proxy").getUri().toString());
        return jsonObject.toString();
    }
    
    
}
