import { describe, test } from "bun:test"
import memoize from "./leet-2630"

describe('2630', () => {
  test('case1', () => {
    const getInputs = () => [[2,2],[2,2],[1,2]]
    const fn = function (a, b) { return a + b; }
    
    const memoized = memoize(fn)

    for (const arr of getInputs()) {
      memoized(...arr)
    }
  })
  test('case2', () => {
    const getInputs = () => [[{},{}],[{},{}],[{},{}]]
    const fn = function (a, b) { return ({...a, ...b}); }    

    const memoized = memoize(fn)

    for (const arr of getInputs()) {
      memoized(...arr)
    }
  })
  test('case3', () => {
    const getInputs = () => { const o = {}; return [[o,o],[o,o],[o,o]]; }
    const fn = function (a, b) { return ({...a, ...b}); }    

    const memoized = memoize(fn)

    for (const arr of getInputs()) {
      memoized(...arr)
    }
  })
})
