/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function (fn, t) {
    const ac = new AbortController()
    const timerId = setTimeout(() => {
        ac.abort()
    }, t)
    return async function (...args) {
        const result = await Promise.race([
            new Promise((resolve) => {
                resolve(fn(...args))
            }),
            new Promise((_, reject) => {
                ac.signal.addEventListener('abort', () => {
                    reject("Time Limit Exceeded")
                })
            })
        ])
        clearTimeout(timerId)
        return result;
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */

export default timeLimit;