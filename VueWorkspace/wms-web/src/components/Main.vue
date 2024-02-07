<template>
<el-table :data="tableData">
    <el-table-column prop="no" label="账号" width="160">
    </el-table-column>
    <el-table-column prop="name" label="姓名" width="160">
    </el-table-column>
    <el-table-column prop="age" label="年龄" width="160">
    </el-table-column>
    <el-table-column prop="sex" label="性别" width="160">
    </el-table-column>
    <el-table-column prop="roleId" label="角色" width="160">
    </el-table-column>
    <el-table-column prop="phone" label="电话" width="160">
    </el-table-column>
    <el-table-column prop="operate" label="操作">
    </el-table-column>
</el-table>
</template>

<script>


    export default {
    name:'Aside',
    data() {
    return {
      tableData: []
    }
    },
    methods:{
      loadGet(){
        this.$axios.get('http://localhost:8081/user/list').then(res=>res.data).then(res=>{
          //alert(res)
          //console.log(res)
        })
      },
      loadPost(){
        this.$axios.post('http://localhost:8081/user/listp',{}).then(res=>res.data).then(res=>{
          //alert(res)
          //console.log(res)
          this.tableData=res
        })
      }
    },
    beforeMount(){
      this.loadGet()
      this.loadPost()
    }
    };
</script>

<style scoped></style>

