//package com.pf.miprototest.testProto.protoServer;
//
//import com.pf.miprototest.demo.SubscribeReqProto;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//
//public class ProtoServerHandler extends SimpleChannelInboundHandler<SubscribeReqProto.SubscribeReq> {
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, SubscribeReqProto.SubscribeReq msg) throws Exception {
//        System.out.println(msg.getSubReqID());
//        System.out.println(msg.getUserName());
//        System.out.println(msg);
//
//        SubscribeReqProto.SubscribeReq bank = SubscribeReqProto.SubscribeReq.newBuilder().setProductName("中国工商银行")
//                .setUserName("6222222200000000000").setSubReqID(56).build();
//
//        ctx.channel().writeAndFlush(bank);
//    }
//}
