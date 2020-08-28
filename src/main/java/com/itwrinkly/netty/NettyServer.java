package com.itwrinkly.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class NettyServer {
    public static void main(String[] args) {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup =  new NioEventLoopGroup();

        final AttributeKey childAttr =  AttributeKey.newInstance("child name");
        final AttributeKey serverAttr =  AttributeKey.newInstance("server name");
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(boosGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .attr(serverAttr, "netty_server")
                .childAttr(childAttr, "netty_child")
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        //指定连接数据读写逻辑
                        System.out.println("server attr:" + ch.attr(serverAttr).get());
                        System.out.println("child attr:" + ch.attr(childAttr).get());
                        ch.pipeline().addLast(new FirstServerHandler());
                    }
                });
        bind(serverBootstrap, 8000);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("端口" + port + "绑定成功");
                } else {
                    System.out.println("端口" + port + "绑定失败！");
                    bind(serverBootstrap, port + 1);
                }
            }
        });
    }
}
