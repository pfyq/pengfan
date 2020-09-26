//package com.pf.miprototest.testProto.protoClient;
//
//import com.pf.miprototest.demo.SubscribeRespProto;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//
//public class ProtoClientHandler extends SimpleChannelInboundHandler<SubscribeRespProto.SubscribeResp> {
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, SubscribeRespProto.SubscribeResp msg) throws Exception {
//        System.out.println(msg.getSubReqID());
//        System.out.println(msg.getRespCode());
//        System.out.println(msg);
//    }
//
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        SubscribeRespProto.SubscribeResp subscribeResp = SubscribeRespProto.SubscribeResp.newBuilder()
//                .setDesc("zhihao.miao").setSubReqID(27).setRespCode(123456).build();
//        ctx.channel().writeAndFlush(subscribeResp);
//    }
//}
