package com.itwrinkly.pipeline;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InBoundHandlerC extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InBoundHandlerC:" + msg);
//        ctx.writeAndFlush(msg);
        ctx.channel().writeAndFlush(msg);
    }
}
