/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function (fn) {
    const map = {}
    this.forEach(el => {
        const key = fn(el)
        if (!map[key]) {
            map[key] = []
        }
        map[key].push(el)
    })
    return map
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
