<template>
  <div class="zongti">
    <div class="xingge">
      <div class="bg_tu">
        <img src="../../assets/images/public_bg.jpg" />
        <!--公共头部-->
        <div class="public_title">
          <h3 style="margin-top: 0.4rem;">PDP性格测试</h3>
        </div>
        <div class="ceshiti">
          <div class="dati_miao" style="padding-top:0px">
            <p style="padding-top:0px">
              <font size="3">
                以下30道题是依据个性特质的不同，将人区分为五大族群，分别是老虎型、孔雀型、考拉型、猫头鹰型及综合各种特质的变色龙型。
                <br />你是什么型？爱人是什么型？观察、聆听，看对方是什么角色，夫妻在家庭教育中怎么互相配合……
                先试试回答以下测试选项。
              </font>
            </p>
          </div>
          <div class="next" @click="toHtml">
            <img src="../../assets/images/dati1.png" />
          </div>
          <!--音乐开始-->
          <div class="yinping none" style="position: absolute;top: 0px;z-index: -1;">
            <audio controls id="music">
              <source src="images/1.mp3" />
            </audio>
          </div>
          <!--音乐结束-->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import $ from "jquery";

export default {
  name: "prof",
  data() {
    return {
      id: ""
    };
  },
  created() {
    //生命周期里接收参数
    this.id = this.$route.query.id; //接受参数关键代码
    console.log(this.id);
    $(document).ready(function() {
      var height = document.documentElement.clientHeight; //浏览器当前窗口文档body的高度
      $(".bg_tu>img").css("height", height + "px");
    });
  },
  methods: {
    toHtml() {
			let that = this;
      this.$router.push({
        path: "/question",
        query: {id:that.id}
      });
    }
  }
};
</script>
<style>
</style>