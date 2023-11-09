/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function (obj) {
    if (!Boolean(obj)) {
        return null
    }
    if (Array.isArray(obj)) {
        const arr = []
        obj.forEach(el => {
            const compacted = compactObject(el)
            if (compacted) {
                arr.push(compacted)
            }
        })
        return arr
    } else if (typeof obj == 'object') {
        const o = {}
        Object.keys(obj).forEach(k => {
            const compacted = compactObject(obj[k])
            if (compacted) {
                o[k] = compacted
            }
        })
        return o
    }
    return obj
};

export default compactObject