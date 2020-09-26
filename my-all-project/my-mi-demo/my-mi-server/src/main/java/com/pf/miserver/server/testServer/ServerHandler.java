package com.pf.miserver.server.testServer;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/*
 * 服务端处理数据类
 * */
// SimpleChannelInboundHandler: 只处理入站消息(接受到的)
public class ServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    //CTRL+O: 重写父类方法
    //对数据进行处理
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        byte[] data=new byte[byteBuf.readableBytes()];//创建byte数组
        byteBuf.readBytes(data);//将数据读取到数组中
        //转String
        String str=new String(data,"utf-8");
        System.out.println("服务端收到数据:"+str);
        //返回数据给客户端     Ctrl+Alt+V :自动补全返回值
        ByteBuf byteBuf1 = Unpooled.copiedBuffer("我已经接受到数据".getBytes());//转byteBuf
        channelHandlerContext.writeAndFlush(byteBuf1);//发送给客户端
    }
    //捕获异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();//打印信息
        ctx.close();//关闭通道
    }
}