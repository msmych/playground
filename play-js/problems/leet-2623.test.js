import { describe, expect, test } from "bun:test";
import memoize from "./leet-2623";

describe('2623', () => {
    test('case1', () => {
        const mem = memoize((a, b) => a + b)
        expect(mem(2,2)).toBe(4)
        expect(mem(2,2)).toBe(4)
        expect(mem(2,1)).toBe(3)
    })

    test('case2', () => {
        const mem = memoize((a, b) => a + b)
        expect(mem(0,0)).toBe(0)
        expect(mem(0,0)).toBe(0)
    })
})
