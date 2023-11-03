/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const map = {}
    for (let i = 0; i < arr1.length; i++) {
        Object.keys(arr1[i]).forEach(k => {
            if (!map[arr1[i].id]) {
                map[arr1[i].id] = {}
            }
            map[arr1[i].id][k] = arr1[i][k]
        })
    } 
    for (let i = 0; i < arr2.length; i++) {
        Object.keys(arr2[i]).forEach(k => {
            if (!map[arr2[i].id]) {
                map[arr2[i].id] = {}
            }
            map[arr2[i].id][k] = arr2[i][k]
        })
    }
    return Object.values(map)
};

export default join
