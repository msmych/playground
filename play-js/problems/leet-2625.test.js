import { describe, expect, test } from "bun:test";
import flat from "./leet-2625";

describe('2625', () => {
    test('case1', () => {
        const arr = [1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]]

        expect(flat(arr, 0)).toEqual([1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]])
    })

    test('case2', () => {
        const arr = [1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]]

        expect(flat(arr, 1)).toEqual([1, 2, 3, 4, 5, 6, 7, 8, [9, 10, 11], 12, 13, 14, 15])
    })

    test('case3', () => {
        const arr = [[1, 2, 3], [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]]

        expect(flat(arr, 2)).toEqual([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])
    })

    test('case4', () => {
        const arr = [1, 2, 3, [4, [5]], 6, [7, [8, 9], 10]]

        expect(flat(arr, 2)).toEqual([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    })
})