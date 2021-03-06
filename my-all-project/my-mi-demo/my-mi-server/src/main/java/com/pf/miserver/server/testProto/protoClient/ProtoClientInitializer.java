//package com.pf.miserver.server.testProto.protoClient;
//
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelPipeline;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.handler.codec.protobuf.ProtobufDecoder;
//import io.netty.handler.codec.protobuf.ProtobufEncoder;
//import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
//import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
//
//public class ProtoClientInitializer extends ChannelInitializer<SocketChannel> {
//
//    @Override
//    protected void initChannel(SocketChannel ch) throws Exception {
//        ChannelPipeline pipeline = ch.pipeline();
//
//        //解码器，通过Google Protocol Buffers序列化框架动态的切割接收到的ByteBuf
//        pipeline.addLast(new ProtobufVarint32FrameDecoder());
//        //将接收到的二进制文件解码成具体的实例，这边接收到的是服务端的ResponseBank对象实列
//        pipeline.addLast(new ProtobufDecoder(DataInfo.ResponseBank.getDefaultInstance()));
//        //Google Protocol Buffers编码器
//        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
//        //Google Protocol Buffers编码器
//        pipeline.addLast(new ProtobufEncoder());
//
//        pipeline.addLast(new ProtoClientHandler());
//    }
//
//}
