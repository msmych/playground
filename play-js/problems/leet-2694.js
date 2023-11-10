class EventEmitter {

    constructor() {
        this.events = {}
    }

    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
        if (!this.events[eventName]) {
            this.events[eventName] = []
        }
        const id = this.events[eventName].length
        this.events[eventName].push(callback)
        return {
            unsubscribe: () => {
                this.events[eventName].splice(id, 1)
            }
        };
    }

    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        const arr = []
        if (!this.events[eventName]) {
            return arr
        }
        this.events[eventName].forEach(fn => arr.push(fn(...args)))
        return arr
    }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */