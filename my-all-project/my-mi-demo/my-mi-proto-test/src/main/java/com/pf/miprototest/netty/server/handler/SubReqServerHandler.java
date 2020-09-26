//package com.pf.miprototest.netty.server.handler;
//
//
//import com.pf.miprototest.demo.SubscribeReqProto;
//import com.pf.miprototest.demo.SubscribeRespProto;
//import io.netty.channel.ChannelHandlerAdapter;
//import io.netty.channel.ChannelHandlerContext;
//
//public class SubReqServerHandler extends ChannelHandlerAdapter {
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        ctx.close();
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        //已经自动解码成序列化类
//        SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq) msg;
//        if("xiaobai".equalsIgnoreCase(req.getUserName())) {
//            System.out.println("Service accept client subscribe req : [" );
//            System.out.println(req.toString());
//            System.out.println("]");
//            ctx.writeAndFlush(resp(req.getSubReqID()));
//        }
//    }
//
//    private SubscribeRespProto.SubscribeResp resp(int subReqID) {
//        SubscribeRespProto.SubscribeResp.Builder builder = SubscribeRespProto.SubscribeResp.newBuilder();
//        builder.setSubReqID(subReqID);
//        builder.setRespCode(0);
//        builder.setDesc("Successfully Got Offer!Get Working At Jan.7th!");
//        return builder.build();
//    }
//}
