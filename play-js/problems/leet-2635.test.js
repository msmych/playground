import { describe, expect, test } from "bun:test";
import map from "./leet-2635";

describe('2635', () => {
    test('case1', () => {
        const arr = [1,2,3]
        const fn = function plusone(n) { return n + 1; }
        expect(map(arr, fn)).toEqual([2,3,4])
    })

    test('case2', () => {
        const arr = [1,2,3]
        const fn = function plusI(n, i) { return n + i; }
        expect(map(arr, fn)).toEqual([1,3,5])
    })

    test('case3', () => {
        const arr = [10,20,30]
        const fn = function constant() { return 42; }
        expect(map(arr, fn)).toEqual([42,42,42])
    })
})
