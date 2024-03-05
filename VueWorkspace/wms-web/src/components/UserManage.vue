<template>
    <div>
      <div style="margin-bottom: 5px;float: left;">
        <el-input v-model="name" placeholder="请输入名称" suffix-icon="el-icon-search" style="width:200px;" @keyup.enter.native="loadPost"></el-input>
        <el-select v-model="sex" filterable placeholder="请选性别" style="margin-left: 5px;">
          <el-option v-for="item in sexs" :key="item.value" :label="item.label" :value="item.value"></el-option>
        </el-select>
        <el-button type="primary" style="margin-left: 5px;" @click="loadPost" >查询</el-button>
        <el-button type="success" @click="resetParam">重置</el-button>
        <el-button type="primary" @click="add">新增</el-button>
      </div>
      <el-table :data="tableData" :header-cell-style="{background:'#f2f5fc',color:'#555555'}" border>
        <el-table-column prop="id" label="ID" width="80"></el-table-column>
        <el-table-column prop="no" label="账号" width="160"></el-table-column>
        <el-table-column prop="name" label="姓名" width="160"></el-table-column>
        <el-table-column prop="age" label="年龄" width="160"></el-table-column>
        <el-table-column prop="sex" label="性别" width="160">
          <template slot-scope="scope">
            <el-tag :type="scope.row.sex===1?'primary':'success'" disable-transitions>{{ scope.row.sex===1?'男':'女' }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="roleId" label="角色" width="160">
          <template slot-scope="scope">
            <el-tag :type="scope.row.roleId===0?'danger':(scope.row.roleId===1?'primary':'success')" disable-transitions>{{ scope.row.roleId===0?'超级管理员':(scope.row.roleId===1?'管理员':'用户') }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="phone" label="电话" width="160"></el-table-column>
        <el-table-column prop="operate" label="操作">
          <template slot-scope="scope"> 
            <el-button size="small" type=“success” @click="mod(scope.row)">编辑</el-button>
            <el-popconfirm title="确认吗？" @confirm="del(scope.row.id)" style="margin-left: 5px;">
              <el-button slot="reference" size="small" type=“danger”>删除</el-button>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
      <el-dialog title="提示" :visible.sync="centerDialogVisible" width="30%" center>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item prop="no" label="账号">
            <el-input v-model="form.no"></el-input>
          </el-form-item>
          <el-form-item prop="name" label="名字">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item prop="password" label="密码">
            <el-input v-model="form.password"></el-input>
          </el-form-item>
          <el-form-item prop="age" label="年龄">
            <el-input v-model="form.age"></el-input>
          </el-form-item>
          <el-form-item prop="sex" label="性别">
            <el-radio-group v-model="form.sex">
              <el-radio label="1">男</el-radio>
              <el-radio label="0">女</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item prop="phone" label="电话">
            <el-input v-model="form.phone"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="centerDialogVisible = false">取消</el-button>
          <el-button type="primary" @click="saveormod">确定</el-button>
        </span>
      </el-dialog>
    </div>
</template>
  
<script>
    export default {
      name:'UserManage',
      data() {
        return {
          tableData: [],
          name:'',
          sex:'',
          sexs:[{value:'1',label:'男'},{value:'0',label:'女'}],
          centerDialogVisible:false,
          form:{
            id:'',
            no:'',
            name:'',
            password:'',
            age:'',
            phone:'',
            sex:'0',
            roleId:''
          }
        }
      },
      methods:{
        del(id){
          //alert("del")
          this.$axios.get('http://localhost:8081/user/delete?id='+id).then(res=>res.data).then(res=>{
            if(res.code==200){
              this.$message({message:'操作成功',type:'success'})
              this.loadPost()
            }
            else{
              this.$message({message:'操作失败',type:'error'})
            }
          })
        },
        mod(row){
          this.centerDialogVisible=true
          this.$nextTick(()=>{
            //赋值到表单
            this.form.id=row.id
            this.form.no=row.no
            this.form.name=row.name
            this.form.password=row.password
            this.form.age=row.age+''
            this.form.sex=row.sex+''
            this.form.phone=row.phone
            this.form.roleId=row.roleId
          })
        },
        add(){
          this.centerDialogVisible=true
          this.$nextTick(()=>{
            //初始化表单
            this.$refs.form.resetFields()
            this.form.id=''
            this.form.roleId='2'
          })
        },
        saveormod(){
          this.$axios.post('http://localhost:8081/user/saveormod',this.form).then(res=>res.data).then(res=>{
            if(res.code==200){
              //alert("添加成功")
              this.$message({message:'操作成功',type:'success'})
              this.centerDialogVisible=false
              this.loadPost()
            }
            else{
              //alert("添加失败")
              this.$message({message:'操作失败',type:'error'})
            }
          })
        },
        loadGet(){
          this.$axios.get('http://localhost:8081/user/list').then(res=>res.data).then(res=>{
          //alert(res)
          //console.log(res)
          })
        },
        loadPost(){
          this.$axios.post('http://localhost:8081/user/listp',{
            name:this.name,
            sex:this.sex,
            roleId:'2'
          }).then(res=>res.data).then(res=>{
            //alert(res)
            //console.log(res)
            if(res.code==200){
              this.tableData=res.data
            }
            else{
              alert("没数据")
            }
          })
        },
        resetParam(){
          this.name=''
          this.sex=''
          this.loadPost()
        }
      },
      beforeMount(){
        this.loadGet()
        this.loadPost()
      }
    }
</script>
  
<style scoped></style>
  
  