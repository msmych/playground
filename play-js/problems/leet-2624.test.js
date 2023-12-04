import { describe, expect, test } from "bun:test";
require("./leet-2624")

describe('2624', () => {
    test('case1', () => {
        const nums = [19, 10, 3, 7, 9, 8, 5, 2, 1, 17, 16, 14, 12, 18, 6, 13, 11, 20, 4, 15]

        expect(nums.snail(5, 4)).toEqual([
            [19,17,16,15],
            [10,1,14,4],
            [3,2,12,20],
            [7,5,18,11],
            [9,8,6,13]
           ])
    })

    test('case2', () => {
        const nums = [1,2,3,4]

        expect(nums.snail(1, 4)).toEqual([
            [1,2,3,4],
           ])
    })

    test('case3', () => {
        const nums = [1,3]

        expect(nums.snail(2, 2)).toEqual([
            [],
           ])
    })
})
