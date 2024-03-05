<template>
  <div>
    <div style="margin-bottom: 5px;float: left;">
      <el-button type="primary" @click="awvs" >awvs反制</el-button>
      <el-button type="primary" @click="as">antsword反制</el-button>
      <el-button type="primary" @click="cs">cobalt strike反制</el-button>
      <el-button type="primary" @click="awa">网站后渗透反制</el-button>
    </div>
  </div>
</template>

<script>
  export default {
    name:'Main',
    data() {
      return {
        
      }
    },
    methods:{
      awvs(){
        this.$axios.get('http://localhost:8081/user/awvs').then(res=>res.data).then(res=>{
          if(res.code==200){
            //alert("成功")
            this.$message({message:'操作成功',type:'success'})
          }
          else{
            //alert("失败")
            this.$message({message:'操作失败',type:'error'})
          }
        })
      },
      as(){
        this.$axios.get('http://localhost:8081/user/as').then(res=>res.data).then(res=>{
          if(res.code==200){
            //alert("成功")
            this.$message({message:'操作成功',type:'success'})
          }
          else{
            //alert("失败")
            this.$message({message:'操作失败',type:'error'})
          }
        })
      },
      cs(){
        this.$axios.get('http://localhost:8081/user/cs').then(res=>res.data).then(res=>{
          if(res.code==200){
            //alert("成功")
            this.$message({message:'操作成功',type:'success'})
          }
          else{
            //alert("失败")
            this.$message({message:'操作失败',type:'error'})
          }
        })
      },
      awa(){
        this.$axios.get('http://localhost:8081/user/awa').then(res=>res.data).then(res=>{
          if(res.code==200){
            //alert("成功")
            this.$message({message:'操作成功',type:'success'})
          }
          else{
            //alert("失败")
            this.$message({message:'操作失败',type:'error'})
          }
        })
      }
    },
    beforeMount(){

    }
  }
</script>

<style scoped></style>

