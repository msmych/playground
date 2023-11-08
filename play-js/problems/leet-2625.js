/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    const flatArr = []
    arr.forEach(el => {
        if (n == 0 || !Array.isArray(el)) {
            flatArr.push(el)
        } else {
            flatArr.push(...flat(el, n - 1))
        }
    })
    return flatArr
};

export default flat