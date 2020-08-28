package com.itwrinkly.pipeline;

import com.itwrinkly.netty.protocol.LoginRespPacket;
import com.itwrinkly.netty.protocol.LoginUtil;
import com.itwrinkly.netty.protocol.LogineReqPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginRespPacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //创建登陆对象
        LogineReqPacket logineReqPacket = new LogineReqPacket();
        logineReqPacket.setUserId(UUID.randomUUID().toString());
        logineReqPacket.setUsername("linghb");
        logineReqPacket.setPassword("123");
        //ctx.channel().writeAndFlush(logineReqPacket);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRespPacket loginRespPacket) throws Exception {
        if (loginRespPacket.isSuccess()) {
            System.out.println(new Date() + ": 客户端登录成功");
            LoginUtil.markAsLogin(ctx.channel());
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因：" + loginRespPacket.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("LoginResponseHandler:客户端连接被关闭!");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("LoginResponseHandler:客户端连接channelUnregistered!");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("LoginResponseHandler:客户端连接handlerRemoved!");
    }
}
