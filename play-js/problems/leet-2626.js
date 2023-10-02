/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let accum = init;
    for (let i = 0; i < nums.length; i++) {
        accum = fn(accum, nums[i])
    }
    return accum
};

export default reduce;
