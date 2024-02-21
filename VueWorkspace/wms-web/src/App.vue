<template>
  <div id="app">
    <!--<Index></Index>-->
    <router-view/>
  </div>
</template>

<script>
//import Index from './components/Index.vue'

export default {
  name: 'App',
  components: {
    //Index
  },
  data(){
    return{
      user:JSON.parse(sessionStorage.getItem('CurUser'))
    }
  },
  watch:{
    '$store.state.menu':{
      handler(val,old){
        //console.log(val)
        //console.log(val,old)
        if(!old&&this.user&&this.user.no){
          this.$store.commit("setMenu",val)
        }
      },
      immediate:true
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height: 100%;
}
</style>
