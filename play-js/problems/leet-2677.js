/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function (arr, size) {
    const chunked = []
    for (let i = 0; i < arr.length;) {
        const c = []
        for (let j = 0; j < size && i < arr.length; j++, i++) {
            c.push(arr[i])
        }
        chunked.push(c)
    }
    return chunked
};

export default chunk