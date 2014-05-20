package com.arturmkrtchyan.jtftp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class TftpPacketEncoder extends MessageToByteEncoder<TftpPacket> {


    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, TftpPacket tftpPacket, ByteBuf byteBuf) throws Exception {
        //ToDo implement
    }

}
