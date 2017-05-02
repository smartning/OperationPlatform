package com.op.user.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.op.user.action.factory.UserActionFactory;
import com.op.user.action.output.ResultMessage;
import com.op.user.action.output.SearchOutput;
import com.op.user.bean.entity.user.User;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserRest {
    /**
     * 创建一个用户
     * @param user
     * @return
     * @throws Exception
     */
    @POST
    public ResultMessage createUser(User user) throws Exception {
        return (ResultMessage) UserActionFactory.getCreateUserAction(user).execute();
    }

    /**
     * 根据用户ID删除用户
     * @param userId
     * @return
     * @throws Exception
     */
    @DELETE
    @Path("/{id}")
    public ResultMessage deleteByUserId(@PathParam("id") String userId) throws Exception {
        return (ResultMessage) UserActionFactory.getDeleteUserAction(userId).execute();
    }

    /**
     * 更新指定ID用户数据
     * @param user
     * @param userId
     * @return
     * @throws Exception
     */
    @PUT
    @Path("/{id}")
    public ResultMessage updateByUserId(User user,
                                        @PathParam("id") String userId) throws Exception {
        return (ResultMessage) UserActionFactory.getUpdateUserAction(userId, user).execute();
    }

    /**
     * 查询指定用户
     * @param userId
     * @return
     * @throws Exception
     */
    @GET
    @Path("/{id}")
    public SearchOutput getUserByUserId(@PathParam("id") String userId) throws Exception {
        return (SearchOutput) UserActionFactory.getSearchUserAction(userId, null).execute();
    }
}
