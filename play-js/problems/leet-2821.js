/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        if (functions.length == 0) {
            resolve([])
        }
        const results = new Array(functions.length).fill(null)
        let count = 0;
        functions.forEach(async (fn, i) => {
            try {
                const result = await fn()
                results[i] = result
                count++;
                if (count == functions.length) {
                    resolve(results)
                }
            } catch (e) {
                reject(e)
            }
        })
    })
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */
