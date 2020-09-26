package com.pf.miserver.server.testClient;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

//客户端处理数据
public class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    //处理服务端返回的数据
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        byte[] data = new byte[byteBuf.readableBytes()];//byteBuf.readableBytes():获取可用的长度
        byteBuf.readBytes(data);//数据读取到数组中
        String string = new String(data,"utf-8");
        System.out.println("客户端接受到服务端返回的数据:"+string);
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();//打印信息
        ctx.close();//关闭通道
    }
}
