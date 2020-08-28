package com.itwrinkly.netty.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.itwrinkly.netty.protocol.Command.MESSAGE_REQUEST;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}