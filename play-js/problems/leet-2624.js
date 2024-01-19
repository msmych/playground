/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
  if (this.length !== rowsCount * colsCount) {
    return []
  }
  const arr = []
  for (let i = 0; i < rowsCount; i++) {
    arr.push([])
  }
  for (let k = 0; k < this.length; k++) {
    const j = Math.floor(k / rowsCount)
    const i = j % 2 === 0 ? k % rowsCount : rowsCount - k % rowsCount - 1
    arr[i].push(this[k])
  }
  return arr
}

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */
