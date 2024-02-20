<template>
  <el-menu  
    background-color="#545c64" 
    text-color="#fff" 
    active-text-color="#ffd04b" 
    style="height:100vh;" 
    default-active="/main" 
    :collapse="isCollapse" 
    :collapse-transition="false" 
    router
  >
    <el-menu-item index="/main" style="text-align: left;">
      <i class="el-icon-s-home"></i>
      <span slot="title">首页</span>
    </el-menu-item>
    <el-menu-item :index="'/'+item.menuclick" style="text-align: left;" v-for="(item,i) in menu" :key="i">
      <i :class="item.menuicon"></i>
      <span slot="title">{{item.menuname}}</span>
    </el-menu-item>
    <!--<el-menu-item index="/user" style="text-align: left;">
      <i class="el-icon-s-opportunity"></i>
      <span slot="title">用户管理</span>
    </el-menu-item>-->
  </el-menu>
</template>

<script>
    export default {
    name:'Aside',
    data(){
      return {
        //isCollapse:false
        menu:[
          {
            menuclick:'admin',
            menuname:'管理员管理',
            menuicon:'el-icon-s-custom'
          },
          {
            menuclick:'user',
            menuname:'用户管理',
            menuicon:'el-icon-user-solid'
          }
        ]
      }
    },
    props:{
        isCollapse:Boolean
      }
    };
  </script>

<style scoped></style>