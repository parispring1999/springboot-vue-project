<template>
  <el-menu  background-color="#545c64" text-color="#fff" active-text-color="#ffd04b" style="height:100vh;" default-active="/Home" :collapse="isCollapse" :collapse-transition="false">
    <el-menu-item index="/Home" style="text-align: left;">
      <i class="el-icon-s-home"></i>
      <span slot="title">首页</span>
    </el-menu-item>
    <el-menu-item index="/One" style="text-align: left;">
      <i class="el-icon-s-flag"></i>
      <span slot="title">导航一</span>
    </el-menu-item>
    <el-menu-item index="/Two" style="text-align: left;">
      <i class="el-icon-s-opportunity"></i>
      <span slot="title">导航二</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
    export default {
    name:'Aside',
    data(){
      return {
        //isCollapse:false
      }
    },
    props:{
        isCollapse:Boolean
      }
    };
  </script>

<style scoped></style>