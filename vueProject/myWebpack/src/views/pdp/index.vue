<template>
  <div
    class="pdp_index"
    :style="{
    backgroundImage: 'url('+require('../../assets/images/bg.jpg')+')',
    height: '100vh',
    backgroundSize: '100% 100%',
    color: '#FFFFFF'
    }"
  >
    <!-- <img src="@/assets/images/bg.jpg"> -->
    <div class="tit clearfix">
      <img src="@/../static/images/tit_father.png" />
    </div>
    <div class="js_bg">
      <img src="@/../static/images/father.png" class="js" />
      <img src="@/../static/images/zsp_bg.png" class="zsp_bg" />
      <img src="@/../static/images/zs_mother.png" class="zsp" />
    </div>
    <div class="cpsr clearfix" style="margin-top: 1rem;">
      <input type="number" name="phone" pattern="[0-9]*" placeholder="宝爸/宝妈手机号" id="phonenum" value />

      <template v-if="!hasBind">
        <div class="clearfix" style="position: relative;">
          <input
            type="text"
            name="code"
            placeholder="短信验证码"
            style="margin-left: 1rem;"
            id="studentname"
            value
          />
          <span class="code" v-show="!validateCodeState" @click="validateCode">获取验证码</span>
          <span class="code time" v-show="validateCodeState">获取验证码</span>
        </div>
      </template>

      <!--onclick="window.location.href='prof.html'"-->
      <img
        src="@/../static/images/bt_1.png"
        @click="startCp"
        style="width: 3rem; display: block; margin: 0rem auto;"
      />
    </div>

    <input type="hidden" id="parenttype" name="parenttype" value="father" />
  </div>
</template>

<script>
// import "../../assets/js/jquery.min.js";
// import $ from "jquery";
require("../../assets/js/jquery.min.js");
import wx from "weixin-js-sdk";
import { realconsole } from "../../assets/js/weixin.js";
import {
  getQueryString,
  processUrl,
  responseDeal
} from "../../assets/js/funUtil.js";
import { getToken, setToken } from "../../assets/js/util.js";
import qs from "qs";
import app from "@/util/app.js";

export default {
  name: "pdp",
  data() {
    return {
      img: {
        backgroundImage: "url(" + require("../../assets/images/bg.jpg") + ")",
        height: "100vh",
        backgroundSize: "100% 100%",
        color: "#FFFFFF"
      },
      hasBind: false,
      isfather: true,
      validateCodeState: false, //false代表可以获取
      code: null,
      obj: getToken("user")
    };
  },
  created() {
    let that = this;
    console.log(that.$router.currentRoute.query.code);

    console.log(this.$store.getters.doneTodos);
    console.log(this.$store.state.user);
    this.$store.commit("saveUser", that.obj);
    // console.log(this.$store.getters.getUser)
    console.log(this.$store.state.user);
    // const url = window.location.href;
    // // 解决多次登录url添加重复的code与state问题
    // console.log(url);
    // const urlParams = qs.parse(url.split("?")[1]);
    // this.code = urlParams.code;
    // console.log(urlParams.code);

    // let postData = qs.stringify({
    //   code: this.code
    // });

    // this.axios.post(app + "/cpLogin/wxLogin", postData).then(function(dt) {
    //   console.log(dt.data);
    //   setToken(dt.data.result);
    // });
    // this.$http.post(app + '/cpLogin/wxLogin',{params:postData}).then(function(dt){
    //         console.log(dt.data);
    //     })
    that.isBind();
  },
  methods: {
    isBind() {
      let that = this;
      let postData = qs.stringify({ openid: that.obj.openid });
      this.axios.post(app + "/cpStudents/hasBind", postData).then(function(dt) {
        console.log(dt.data);
        if (dt.data.code == 200) {
          that.hasBind = true;
          $("input[name='phone']").val(dt.data.result.phone);
          $("input[name='phone']").attr("readOnly", "true");
          // findOne(data.result.phone);
        } else if (dt.data.code == 501) {
          // $(".bind").css("display","block");
          that.hasBind = false;
        }
      });
    },
    objChange(e) {},
    validateCode() {},
    startCp() {
      let that = this;
      var param = {
        phone: $("input[name='phone']").val(),
        openid: this.obj.openid,
        code: $("input[name='code']").val(),
        hasBind: this.hasBind ? 2 : 1,
        sex: this.isfather ? "男" : "女"
      };
      let postData = qs.stringify(param);
      this.axios.post(app + "/pdpEvaluateObj/add", postData).then(function(dt) {
        if (responseDeal(dt.data)) {
          that.$router.push({
            path: "/prof",
            query: {
              //路由传参时push和query搭配使用 ，作用时传递参数
              id: dt.data.result
            }
          });
          // window.location.href = serverUrl + "/pdp/prof.html?id=" + data.result;
        }
      });
    }
  },
  mounted() {
    this.$nextTick(() => {
      (function(doc, win) {
        var docEl = doc.documentElement,
          resizeEvt =
            "orientationchange" in window ? "orientationchange" : "resize",
          recalc = function() {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            docEl.style.fontSize = 100 * (clientWidth / 750) + "px";
          };
        if (!doc.addEventListener) return;
        win.addEventListener(resizeEvt, recalc, false);
        doc.addEventListener("DOMContentLoaded", recalc, false);
      })(document, window);
    });
  }
};
</script>

<style scoped >
@import "../../styles/public.css";
</style>