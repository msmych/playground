/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {

  const cache = new Map()

  return function(...args) {
    return fn(...args)
  }
}

export default memoize
