package com.itwrinkly.netty;

import com.itwrinkly.netty.protocol.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

public class FirstServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server active");
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf requestByteBuf = (ByteBuf) msg;
        System.out.println(new Date() + ": 服务端读到数据 -> " + requestByteBuf.toString(Charset.forName("utf-8")));
//        ByteBuf out = getByteBuf(ctx);
//        ctx.channel().writeAndFlush(out);

        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);

        if (packet instanceof LogineReqPacket) {
            // 登录流程
            LogineReqPacket loginRequestPacket = (LogineReqPacket) packet;

            LoginRespPacket loginRespPacket = new LoginRespPacket();
            loginRespPacket.setVersion(packet.getVersion());
            if (valid(loginRequestPacket)) {
                loginRespPacket.setSuccess(true);
                System.out.println(new Date() + ": 登录成功!");
            } else {
                loginRespPacket.setReason("账号密码校验失败");
                loginRespPacket.setSuccess(false);
                System.out.println(new Date() + ": 登录失败!");
            }
            // 登录响应
            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(loginRespPacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        } else if (packet instanceof MessageRequestPacket) {
            // 处理消息
            MessageRequestPacket messageRequestPacket = ((MessageRequestPacket) packet);
            System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());

            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(messageResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "你好，欢迎关注我的微信公众号，《IT中年男》!".getBytes(Charset.forName("utf-8"));
        ByteBuf byteBuf = ctx.alloc().buffer();
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    private boolean valid(LogineReqPacket loginRequestPacket) {
        return true;
    }
}
