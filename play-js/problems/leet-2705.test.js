import { describe, expect, test } from "bun:test";
import compactObject from "./leet-2705";

describe('2705', () => {
    test('case1', () => {
        const obj = [null, 0, false, 1]
        expect(compactObject(obj)).toEqual([1])
    })

    test('case2', () => {
        const obj = { "a": null, "b": [false, 1] }
        expect(compactObject(obj)).toEqual({ "b": [1] })
    })

    test('case3', () => {
        const obj = [null, 0, 5, [0], [false, 16]]
        expect(compactObject(obj)).toEqual([5, [], [16]])
    })
})