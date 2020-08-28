package com.itwrinkly.netty.protocol;

import lombok.Data;

@Data
public class LogineReqPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQ;
    }
}
