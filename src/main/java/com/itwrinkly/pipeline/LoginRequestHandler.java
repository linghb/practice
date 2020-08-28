package com.itwrinkly.pipeline;

import com.itwrinkly.netty.protocol.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LogineReqPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogineReqPacket logineReqPacket) throws Exception {
        System.out.println(new Date() + ": 收到客户端登录请求……");
        LoginRespPacket loginRespPacket = new LoginRespPacket();
        if (valid(logineReqPacket)) {
            loginRespPacket.setSuccess(true);
            System.out.println(new Date() + ": 登录成功!");
            LoginUtil.markAsLogin(ctx.channel());
        } else {
            loginRespPacket.setReason("账号密码校验失败");
            loginRespPacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }
        ctx.channel().writeAndFlush(loginRespPacket);
    }

    private boolean valid(LogineReqPacket logineReqPacket) {
        return true;
    }
}
