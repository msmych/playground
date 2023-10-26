import { describe, expect, test } from "bun:test";
import isEmpty from "./leet-2727";

describe('2727', () => {
    test('case1', () => {
        expect(isEmpty({ "x": 5, "y": 42 })).toBeFalse()
    })
    test('case2', () => {
        expect(isEmpty({})).toBeTrue()
    })
    test('case3', () => {
        expect(isEmpty([null, false, 0])).toBeFalse()
    })
})