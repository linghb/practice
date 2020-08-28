package com.itwrinkly.pipeline;

import com.itwrinkly.netty.FirstClientHandler;
import com.itwrinkly.netty.protocol.LoginUtil;
import com.itwrinkly.netty.protocol.MessageRequestPacket;
import com.itwrinkly.netty.protocol.PacketCodeC;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NettyPipeLineClient {
    public static final int MAX_RETRY = 3;
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup workPipeGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            final AttributeKey clientAttr =  AttributeKey.newInstance("client name");
            bootstrap
                    //指定线程模型
                    .group(workPipeGroup)
                    //指定IO类型为NIO
                    .channel(NioSocketChannel.class)
                    //IO处理逻辑
                    .handler(new ChannelInitializer<NioSocketChannel>() {

                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            //指定连接数据读写逻辑
                            System.out.println("client atrr:" + ch.attr(clientAttr).get());
                            ch.pipeline().addLast(new PipeClientHandler());

//                            ch.pipeline().addLast(new PacketDecoder());
//                            ch.pipeline().addLast(new LoginResponseHandler());
//                            ch.pipeline().addLast(new MessageResponseHandler());
//                            ch.pipeline().addLast(new PacketEncoder());
                        }
                    })
                    .attr(clientAttr, "client");
            //建立连接
            connect(bootstrap, "localhost", 8081, MAX_RETRY);
            //bootstrap.connect("localhost", 8000).sync();

        } finally {
            //workGroup.shutdownGracefully();
        }

    }

    public static void connect(Bootstrap bootstrap, String host, int port , int retry) {
        bootstrap.connect("localhost", 8081).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功!");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        new Thread(() -> {
            while (!Thread.interrupted()) {
//                if (LoginUtil.hasLogin(channel)) {
                    System.out.println("输入消息发送至服务端: ");
                    Scanner sc = new Scanner(System.in);
                    String line = sc.nextLine();

                    channel.writeAndFlush(new MessageRequestPacket(line));
//                }
            }
        }).start();
    }
}
