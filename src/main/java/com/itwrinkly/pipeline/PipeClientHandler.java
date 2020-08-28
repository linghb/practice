package com.itwrinkly.pipeline;

import com.itwrinkly.netty.protocol.LogineReqPacket;
import com.itwrinkly.netty.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.UUID;

public class PipeClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //创建登陆对象
        LogineReqPacket logineReqPacket = new LogineReqPacket();
        logineReqPacket.setUserId(UUID.randomUUID().toString());
        logineReqPacket.setUsername("linghb");
        logineReqPacket.setPassword("123");

        ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(logineReqPacket);
        ctx.channel().writeAndFlush(byteBuf);
    }
}
