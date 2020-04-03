<template>
  <div class="zongti">
    <div class="play_games">
      <div class="bg_tu">
        <img src="../../assets/images/public_bg.jpg" />
        <!--公共头部-->
        <div class="public_title">
          <h3 style="margin-top: 0.6rem;">PDP性格测评</h3>
        </div>
        <!--文字开始-->
        <div class="play_header">
          <div class="play_header">
            <div class="play_conts">
              <p>
                <font size="5">
                  <span v-text="curNum"></span>/
                  <span v-text="allNum"></span>
                </font>
              </p>
              <p class="tips">
                <font size="5" v-if="title.length > 0">
                  <span v-text="curNum +'.'"></span>
                  <span v-text="title[curNum - 1].title"></span>
                </font>
              </p>
              <div class="play_xuanze">
                <div class="play_block">
                  <label class="lable_list_play" v-for="(item,index) in option" v-bind:key="index">
                    <input type="radio" class="demo_radio" name="score" :did="item.score" />
                    <span class="demo_radioinput"></span>
                    <span class="play_idea">
                      <font size v-text="item.title"></font>
                    </span>
                  </label>
                </div>
              </div>
            </div>
          </div>
          <!--下一题按钮-->
          <div class="play_btn" id="oper">
            <!--onclick="window.location.href='result.html'"-->
            <img src="../../assets/images/nexts.png" v-if="btnState" class="xia" @click="nextTile" />
            <img src="../../assets/images/nexts.png" v-else class="xia" />
          </div>
          <!--进度条-->
          <div class="progress" style="top: 95%;">
            <progress id="myProgress" :value="curNum" :max="allNum"></progress>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import $ from "jquery";

export default {
  name: "question",
  data() {
    return {
      title: [],
      curNum: 1,
      allNum: 1,
      option: [
        { title: "不同意", score: 1 },
        { title: "有一点同意", score: 2 },
        { title: "差不多", score: 3 },
        { title: "比较同意", score: 4 },
        { title: "非常同意", score: 5 }
      ],
      score: [],
      btnState: true
    };
  },
  created() {
    this.loadData();
  },
  methods: {
    loadData() {},
    nextTile() {},
    nextHtml() {
      console.log(this.curNum);
    },
    selUtil() {
      let that = this;
      let hasSel = false;
      $(".play_block")
        .find("input[type='radio']")
        .each(function(i, d) {
          if ($(d).get(0).checked) {
            that.score.push({ id: that.curNum, score: $(d).attr("did") });
            $(d).get(0).checked = false;
            hasSel = true;
            return true;
          }
        });
      return hasSel;
    }
  },
  mounted() {
    this.$nextTick(() => {
      $(document).ready(function() {
        var height = document.documentElement.clientHeight; //浏览器当前窗口文档body的高度
        $(".bg_tu>img").css("height", height + "px");
      });
    });
  }
};
</script>
<style scoped>
.play_btn {
  position: fixed;
  top: 87.5%;
  width: 100%;
  height: 7%;
}
.play_btn img {
  display: block;
  margin: 0 auto;
  height: 100%;
  width: auto;
}
</style>