<template>
<el-container style="height: 100%; border: 1px solid #eee">
    <el-aside :width="aside_width" style="background-color: rgb(238, 241, 246);height:100%" >
      <Aside :isCollapse="isCollapse"></Aside>
    </el-aside>
    
    <el-container style="height: 100%">
      <el-header style="text-align: right; font-size: 12px" height="100%">
        <Header @doCollapse="doCollapse"></Header>
      </el-header>
      
      <el-main>
        <Main></Main>
      </el-main>
    </el-container>
  </el-container>
</template>
  
  <style scoped>
    .el-header {
      background-color: #B3C0D1;
      color: #333;
      line-height: 60px;
    }
    
    .el-aside {
      color: #333;
    }
  </style>
  
  <script>
    import Aside from "./Aside.vue"
    import Header from "./Header.vue"
    import Main from "./Main.vue"
    export default {
    name:'Index',
    components:{Aside,Header,Main},
    data(){
      return {
        isCollapse:false,
        aside_width:'200px',
      }
    },
    methods:{
      doCollapse(){
        alert("111")
        this.isCollapse=!this.isCollapse
        if(!this.isCollapse){//展开
          aside_width='200px'
        }
        else{//收起
          aside_width='64px'
        }
      }
    }
  };
  </script>