//package com.pf.miserver.server.testProto.protoClient;
//
//import io.netty.channel.ChannelHandlerContext;
//
//public class ProtoClientHandler extends SimpleChannelInboundHandler<DataInfo.ResponseBank> {
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.ResponseBank msg) throws Exception {
//        System.out.println(msg.getBankNo());
//        System.out.println(msg.getBankName());
//        System.out.println(msg.getMoney());
//    }
//
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        DataInfo.RequestUser user = DataInfo.RequestUser.newBuilder()
//                .setUserName("zhihao.miao").setAge(27).setPassword("123456").build();
//        ctx.channel().writeAndFlush(user);
//    }
//}
