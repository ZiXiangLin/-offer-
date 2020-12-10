class EventBus{
    es = {}

    on(eventName, cb) {
        if(!this.es[eventName]) {
            this.es[eventName] = []
        }
        this.es[eventName].push({
            cb
        })
    }

    emit(eventName, ...params) {
        const listeners = this.es[eventName] || []
        let length = listeners.length
        for(let i = 0; i < length; i++) {
            const {cb} = listeners[i]
            cb.apply(this, params)
        }
    }

    off(eventName, offcb) {
        if(this.es[eventName]) {
            let index = this.es[eventName].findIndex((cb)=>{
                return offcb===cb;
            })
            this.es[eventName].splice(index,1);
            if(!this.es[eventName].length){
                delete this.es[eventName];
            }
        }
    }
}

export default new EventBus()