<template>
  <div class="hello">
    <div @click="textAxio">测试请求</div>
  </div>
</template>

<script>
import app from '@/util/app.js'

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods:{
    textAxio(){
        let that = this;
        // axios.get('/api/index.json').then(this.getHomeInfoSucc)
        // this.$http('/api/cpStudents/all').then(function(dt){
        //     console.log(dt.data);
        // })
        console.log(app);
        this.$http(app + '/cpStudents/all').then(function(dt){
            console.log(dt.data);
        })
        // this.$http(app.baseUrl() + '/cpStudents/all').then(function(dt){
        //     console.log(dt.data);
        // })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
