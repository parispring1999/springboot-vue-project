<template>
<div style="display:flex;line-height:60px">
    <div>
    <i class="el-icon-s-fold" style="font-size: 20px;line-height:60px" @click="collapse"></i>
    </div>
    <div style="flex:1;text-align: center;font-size: 33px;line-height:60px">
        仓库管理系统
    </div>
  <el-dropdown>
    <span>王小虎</span>
    <i class="el-icon-arrow-down" style="margin-left: 5px"></i>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item @click.native="toUser">个人中心</el-dropdown-item>
      <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</div>
</template>

<script>


    export default {
    name:'Header',
    methods:{
        toUser(){
            alert('toUser')
        },
        logout(){
            alert('logout')
        },
        collapse(){
          this.$emit('doCollapse')
        }
    }
    };
  </script>

<style scoped></style>