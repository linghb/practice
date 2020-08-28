package com.itwrinkly.netty.protocol;

import lombok.Data;

@Data
public abstract class Packet {
    /**
     * 协议版本号
     */
    private Byte version = 1;

    /**
     * 指令
     */
    public abstract Byte getCommand();
}
