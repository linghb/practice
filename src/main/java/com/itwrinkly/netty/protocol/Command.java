package com.itwrinkly.netty.protocol;

public interface Command {
    Byte LOGIN_REQ = 1;

    Byte LOGIN_RESP = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;
}
