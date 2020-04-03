function wechatInit(data) {
  wx.config({
      debug: false,
      appId: data.param.appId,
      timestamp: data.param.timestamp,
      nonceStr: data.param.nonceStr,
      signature: data.param.signature,
      jsApiList: [
          'onMenuShareTimeline',
          'onMenuShareAppMessage',
          'onMenuShareQQ',
          'onMenuShareWeibo',
          'onMenuShareQZone',
          'chooseWXPay'
      ]
  });

  // wx.config({
  //     debug: false,
  //     appId: 'wx2628296949615039',
  //     timestamp: '1573090942',
  //     nonceStr: '1ad776d8-17c4-4528-85f3-48cfa080d196',
  //     signature: '9ddb2f554452c205e4638d2eafefee952eabed6b',
  //     jsApiList: [
  //         'onMenuShareTimeline',
  //         'onMenuShareAppMessage',
  //         'onMenuShareQQ',
  //         'onMenuShareWeibo',
  //         'onMenuShareQZone'
  //     ]
  // });


  // wx.ready(function () {   //需在用户可能点击分享按钮前就先调用
  //     wx.onMenuShareAppMessage({
  //         title: '你个二百五', // 分享标题
  //         desc: '你自个儿想想为甚', // 分享描述
  //         link: data.url, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
  //         imgUrl: 'http://localhost:8089/upload/d8ab4c41-0459-4c96-8fbb-0df03e14899d20180702085349%E9%BB%91%E9%A9%AC%E6%8E%A8%E8%8D%90171x232.jpg', // 分享图标
  //         success: function () {
  //             // 设置成功
  //             alert("分享成功了!");
  //         }
  //     })
  // });


//     wx.ready(function () {
//         wx.checkJsApi({
//             jsApiList: [
//                 'onMenuShareTimeline',
//                 'onMenuShareAppMessage',
//                 'onMenuShareQQ',
//                 'onMenuShareWeibo',
//                 'onMenuShareQZone'
//             ]
//         });
//         wx.checkJsApi({
//             jsApiList: [
//                 'onMenuShareTimeline',
//                 'onMenuShareAppMessage',
//                 'onMenuShareQQ',
//                 'onMenuShareWeibo',
//                 'onMenuShareQZone'
//             ]
//         });
//         /*分享到朋友圈*/
// //         wx.onMenuShareTimeline({
// //             title: '计划书', // 分享标题
// //             desc: '保险让生活更美好！', // 分享描述
// //             link: '${fenxurl}', // 分享链接
// //             imgUrl: '${params.urlg}/PF_IDENTIFY/Cacheable/image/business/plan-cover/product_img.png', // 分享图标
// //             success: function () {
// // // 用户确认分享后执行的回调函数
// //             },
// //             cancel: function () {
// // // 用户取消分享后执行的回调函数
// //             }
// //         });
//         /*分享给朋友*/
//         wx.onMenuShareAppMessage({
//             title: '计划书', // 分享标题
//             desc: '保险让生活更美好！', // 分享描述
//             link: '${fenxurl}', // 分享链接
//             imgUrl: '${params.urlg}/PF_IDENTIFY/Cacheable/image/business/plan-cover/product_img.png', // 分享图标
//             type: 'link', // 分享类型,music、video或link，不填默认为link
//             dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
//             success: function () {
// // 用户确认分享后执行的回调函数
//                 alert("您已分享");
//             },
//             cancel: function () {
// // 用户取消分享后执行的回调函数
//                 alert('您已取消分享');
//             }
//         });
//         wx.onMenuShareQQ({
//             title: '计划书', // 分享标题
//             desc: '保险让生活更美好！', // 分享描述
//             link: '${fenxurl}', // 分享链接
//             imgUrl: '${params.urlg}/PF_IDENTIFY/Cacheable/image/business/plan-cover/product_img.png', // 分享图标
//             success: function () {
// // 用户确认分享后执行的回调函数
//             },
//             cancel: function () {
// // 用户取消分享后执行的回调函数
//             }
//         });
//         wx.onMenuShareWeibo({
//             title: '计划书', // 分享标题
//             desc: '保险让生活更美好！', // 分享描述
//             link: '${fenxurl}', // 分享链接
//             imgUrl: '${params.urlg}/PF_IDENTIFY/Cacheable/image/business/plan-cover/product_img.png', // 分享图标
//             success: function () {
// // 用户确认分享后执行的回调函数
//             },
//             cancel: function () {
// // 用户取消分享后执行的回调函数
//             }
//         });
//         wx.onMenuShareQZone({
//             title: '计划书', // 分享标题
//             desc: '保险让生活更美好！', // 分享描述
//             link: '${fenxurl}', // 分享链接
//             imgUrl: '${params.urlg}/PF_IDENTIFY/Cacheable/image/business/plan-cover/product_img.png', // 分享图标
//             success: function () {
// // 用户确认分享后执行的回调函数
//             },
//             cancel: function () {
// // 用户取消分享后执行的回调函数
//             }
//         });
//     });

}



export {
  wechatInit
}