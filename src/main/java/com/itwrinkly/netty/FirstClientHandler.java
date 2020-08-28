package com.itwrinkly.netty;

import com.itwrinkly.netty.protocol.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.UUID;

public class FirstClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + ": 客户端写出数据");
        // 1. 获取数据
//        ByteBuf buffer = getByteBuf(ctx);
        // 2. 写数据
//        ctx.channel().writeAndFlush(buffer);

        //创建登陆对象
        LogineReqPacket logineReqPacket = new LogineReqPacket();
        logineReqPacket.setUserId(UUID.randomUUID().toString());
        logineReqPacket.setUsername("linghb");
        logineReqPacket.setPassword("123");

        ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(logineReqPacket);
        ctx.channel().writeAndFlush(byteBuf);

    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        // 1. 获取二进制抽象 ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        // 2. 准备数据，指定字符串的字符集为 utf-8
        byte[] bytes = "你好，netty!".getBytes(Charset.forName("utf-8"));
        // 3. 填充数据到 ByteBuf
        buffer.writeBytes(bytes);
        return buffer;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf byteBuf = (ByteBuf) msg;
//        System.out.println(new Date() + ": 客户端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
        ByteBuf byteBuf = (ByteBuf) msg;

        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

        if (packet instanceof LoginRespPacket) {
            LoginRespPacket loginResponsePacket = (LoginRespPacket) packet;

            if (loginResponsePacket.isSuccess()) {
                LoginUtil.markAsLogin(ctx.channel());
                System.out.println(new Date() + ": 客户端登录成功");
            } else {
                System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
            }
        } else if (packet instanceof MessageResponsePacket) {
            MessageResponsePacket messageResponsePacket = (MessageResponsePacket) packet;
            System.out.println("收到服务端发过来的信息:" + messageResponsePacket.getMessage());
        }
    }
}
