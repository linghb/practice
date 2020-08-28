package com.itwrinkly.netty.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.HashMap;
import java.util.Map;

import static com.itwrinkly.netty.protocol.Command.*;

public class PacketCodeC {

    private static final int MAGIC_NUMBER = 0x12345678;
    public static final PacketCodeC INSTANCE = new PacketCodeC();

    private final Map<Byte, Class<? extends Packet>> packetTypeMap;
    private final Map<Byte, Serializer> serializerMap;


    private PacketCodeC() {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(LOGIN_REQ, LogineReqPacket.class);
        packetTypeMap.put(LOGIN_RESP, LoginRespPacket.class);
        packetTypeMap.put(MESSAGE_REQUEST, MessageRequestPacket.class);
        packetTypeMap.put(MESSAGE_RESPONSE, MessageResponsePacket.class);

        serializerMap = new HashMap<>();
        Serializer serializer = new JSONSerializer();
                serializerMap.put(serializer.getSerializerAlgorithm(), serializer);
    }

    public ByteBuf encode(Packet packet) {
        //1. 创建ByteBuf
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        //2. 序列化 Java 对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        //3. 实际编码过程
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    public ByteBuf encode(ByteBuf byteBuf, Packet packet) {
        //1. 创建ByteBuf

        //2. 序列化 Java 对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        //3. 实际编码过程
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    public Packet decode(ByteBuf byteBuf) {
        //1. magic number
        byteBuf.skipBytes(4);
        //2. 版本号
        byteBuf.skipBytes(1);
        //3. 序列化算法
        byte serialAlgorithm = byteBuf.readByte();
        //4. 指令
        byte command = byteBuf.readByte();
        //5. 数据包长度
        int length = byteBuf.readInt();

        byte[] content = new byte[length];
        byteBuf.readBytes(content);

        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serialAlgorithm);

        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, content);
        }

        return null;
    }

    private Serializer getSerializer(byte serializeAlgorithm) {

        return serializerMap.get(serializeAlgorithm);
    }

    private Class<? extends Packet> getRequestType(byte command) {

        return packetTypeMap.get(command);
    }
}
