package com.op.message.rest;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.op.message.library.rabbit.Queue.SenderName;
import com.op.message.library.rabbit.sender.Sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.Map;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/31.
 ****************************************/
@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public class QueueRest {
    @Autowired
    @Qualifier(SenderName.LOG_SENDER)
    public Sender logSender;

    @POST
    @Path("/log/async")
    public String asyncLog(Map<String, Object> body) {
        JsonObject object = new JsonObject();
        try {
            logSender.send(JSON.toJSONString(body));
        } catch (Throwable e) {
            object.addProperty("success", false);
            return object.toString();
        }
        object.addProperty("success", true);
        return object.toString();
    }
}
