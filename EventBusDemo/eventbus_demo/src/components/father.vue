<template>
    <div class="father">
        <div>mes from App by props and computed: {{computedAppMes}}</div>
        <div> mes from son: {{sonMes}}</div>
        <input v-model="mes">
        <button @click="send"> send mes to son</button>
        <h5>take a break</h5>
        <son />
    </div>
</template>
<script>
import son from './son'
import EventBus from './EventBus'

export default {
    name:'father',
    components:{
        son
    },
    props:{
        appMes:{
            type:String,
            default:''
        }
    },
    computed:{
        computedAppMes(){
            return this.appMes + " Good Night"
        }
    },
    data(){
        return{
            mes:'',
            sonMes:''
        }
    },
    mounted(){
        EventBus.on('sonSay', this.sonSay)
    },
    methods:{
        sonSay(value) {
            this.sonMes = value
        },
        send(){
            EventBus.emit('fatherSay', this.mes)
        }
    }

}
</script>