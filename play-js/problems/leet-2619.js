/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {
    const len = this.length
    return len > 0 ? this[len - 1] : -1;
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
