import { describe, expect, test } from "bun:test";
import reduce from "./leet-2626";

describe('2626', () => {
    test('case1', () => {
        const nums = [1,2,3,4]
        const fn = function sum(accum, curr) { return accum + curr; }
        const init = 0

        expect(reduce(nums, fn, init)).toEqual(10)
    })

    test('case2', () => {
        const nums = [1,2,3,4]
        const fn = function sum(accum, curr) { return accum + curr * curr; }
        const init = 100

        expect(reduce(nums, fn, init)).toEqual(130)
    })

    test('case3', () => {
        const nums = []
        const fn = function sum(accum, curr) { return 0; }
        const init = 25

        expect(reduce(nums, fn, init)).toEqual(25)
    })
})
