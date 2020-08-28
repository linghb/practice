package com.itwrinkly.netty.protocol;

import lombok.Data;

import static com.itwrinkly.netty.protocol.Command.MESSAGE_RESPONSE;

@Data
public class MessageResponsePacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {

        return MESSAGE_RESPONSE;
    }
}