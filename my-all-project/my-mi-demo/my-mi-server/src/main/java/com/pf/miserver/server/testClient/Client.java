package com.pf.miserver.server.testClient;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

//客户端
public class Client {

    public static void main(String[] args) throws Exception {
        //实际业务处理线程组
        EventLoopGroup workGroup = new NioEventLoopGroup();
        //创建客户端配置类
        Bootstrap bootstrap=new Bootstrap();
        //链式配置
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class) //指定客户端类型通道
                .handler(new ChannelInitializer<SocketChannel>() { //配置初始化
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ClientHandler());//绑定客户端数据处理对象
                    }
                });
        //与服务端连接,调用sync()方法来执行同步阻塞，直到连接完成
        ChannelFuture sync =bootstrap.connect("127.0.0.1",9527).sync();
        //向服务端发送数据   Unpooled: netty提供的工具类,可以将其他类型转为buf类型
        sync.channel().writeAndFlush(Unpooled.copiedBuffer("我是客户端".getBytes()));
        //开启同步阻塞监听,直到断开连接才关闭通道
        sync.channel().closeFuture().sync();
        workGroup.shutdownGracefully();
    }
}


