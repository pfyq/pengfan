package com.pf.miserver.server.testServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

    public static void main(String[] args) {
        //创建两个线程组
        EventLoopGroup connectGroup = new NioEventLoopGroup();//接受客户端连接
        EventLoopGroup workGroup = new NioEventLoopGroup();//处理实际业务操作
        try {//创建server配置类
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(connectGroup,workGroup)//支持链式编程,进行配置
                    //指定使用NioServerSocketChannel这种类型(服务端)的通道
                    .channel(NioServerSocketChannel.class)
                    //ChannelInitializer:服务器Channel通道初始化设置的抽象类
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override    //初始化操作:编解码,绑定处理逻辑等
                        protected void initChannel(SocketChannel channel) throws Exception {
                            //使用 childHandler 去绑定具体的 事件处理器
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new ServerHandler());//绑定服务端数据处理
                        }
                    });
            //绑定端口,调用sync()方法来执行同步阻塞，直到绑定完成
            ChannelFuture sync = bootstrap.bind(9527).sync();
            //获取该Channel的CloseFuture，并且阻塞当前线程直到绑定的端口关闭才会执行关闭通道
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关闭线程组
            connectGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

}
