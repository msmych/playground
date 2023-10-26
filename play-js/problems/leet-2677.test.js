import { describe, expect, test } from "bun:test";
import chunk from "./leet-2677";

describe('2677', () => {
    test('case1', () => {
        const arr = [1, 2, 3, 4, 5]

        expect(chunk(arr, 1)).toEqual([[1], [2], [3], [4], [5]])
    })
    test('case2', () => {
        const arr = [1, 9, 6, 3, 2]

        expect(chunk(arr, 3)).toEqual([[1, 9, 6], [3, 2]])
    })
    test('case3', () => {
        const arr = [8, 5, 3, 2, 6]

        expect(chunk(arr, 6)).toEqual([[8, 5, 3, 2, 6]])
    })
    test('case4', () => {
        const arr = []

        expect(chunk(arr, 1)).toEqual([])
    })
})