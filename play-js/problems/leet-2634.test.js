import { describe, expect, test } from "bun:test";
import filter from "./leet-2634";

describe('2634', () => {
    test('case1', () => {
        const arr = [0,10,20,30]
        const fn = function greaterThan10(n) { return n > 10; }

        expect(filter(arr, fn)).toEqual([20, 30])
    })

    test('case2', () => {
        const arr = [1,2,3]
        const fn = function firstIndex(n, i) { return i === 0; }

        expect(filter(arr, fn)).toEqual([1])
    })

    test('case3', () => {
        const arr = [-2,-1,0,1,2]
        const fn = function plusOne(n) { return n + 1 }

        expect(filter(arr, fn)).toEqual([-2,0,1,2])
    })
})
