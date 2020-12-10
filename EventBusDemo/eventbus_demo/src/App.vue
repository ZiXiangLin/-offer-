<template>
  <div id="app">
    <input v-model="inputMes">
    <button @click="send"> send mes from App to father</button>
    <h5>aowu aowu aowu ~</h5>
    <father :appMes="mes" />
  </div>
</template>

<script>
import father from './components/father'

export default {
  name: 'App',
  components: {
    father
  },
  data(){
    return {
      mes:'',
      inputMes:''
    }
  },
  methods:{
    send(){
      this.mes = this.inputMes;
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
  margin-top: 60px;
}
</style>
