package com.itwrinkly.netty.protocol;

import lombok.Data;

@Data
public class LoginRespPacket extends Packet {
    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESP;
    }
}
