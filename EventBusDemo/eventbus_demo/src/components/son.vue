<template>
    <div class="son">
        <div>mes from father: {{fatherMes}}</div>
        <input v-model="mes">
        <button @click="send">send mes to father</button>
    </div>
</template>
<script>
import EventBus from './EventBus'
export default {
    name:'son',
    data(){
        return{
            mes:'',
            fatherMes:''
        }
    },
    mounted(){
        EventBus.on('fatherSay', this.fatherSay)
    },
    methods:{
        fatherSay(value) {
            this.fatherMes = value
        },
        send() {
            EventBus.emit('sonSay', this.mes)
        }
    }
    
}
</script>