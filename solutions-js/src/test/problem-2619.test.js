import { describe, expect, test } from "bun:test";
require("./../problem-2619")

describe.todo('2619', () => {
    test('case1', () => {
        const nums = [null, {}, 3]
        expect(nums.last()).toBe(3)
    })

    test('case2', () => {
        const nums = []
        expect(nums.last()).toBe(-1)
    })
})
