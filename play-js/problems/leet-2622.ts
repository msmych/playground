type TimerId = ReturnType<typeof setTimeout>

class TimeLimitedCache {


    private map = new Map<number, number>()
    private timers = new Map<number, TimerId>()

    constructor() {

    }

    set(key: number, value: number, duration: number): boolean {
        let result
        if (this.map.has(key)) {
            clearTimeout(this.timers.get(key))
            result = true
        } else {
            result = false
        }
        this.map.set(key, value)
        this.timers.set(key, setTimeout(() => this.map.delete(key), duration))
        return result
    }

    get(key: number): number {
        return this.map.get(key) ?? -1
    }

    count(): number {
        return this.map.size
    }
}

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */

export default TimeLimitedCache